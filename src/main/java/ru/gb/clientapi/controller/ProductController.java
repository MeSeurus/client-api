package ru.gb.clientapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.api.category.dto.CategoryDto;
import ru.gb.api.manufacturer.api.ManufacturerGateway;
import ru.gb.api.product.api.ProductGateway;
import ru.gb.api.product.dto.ProductDto;
import ru.gb.clientapi.service.ProductService;

import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("gbshop/product")
public class ProductController {

    private final ProductService productService;
    private final ProductGateway productGateway;
    private final ManufacturerGateway manufacturerGateway;

    @GetMapping("/all")
    public String getProductList(Model model) {
        model.addAttribute("products", productGateway.getProductList());
        return "product-list";
    }

    @GetMapping("/{productId}")
    public String info(Model model, @PathVariable("productId") Long id) {
        ProductDto productDto;
        if (id != null) {
            productDto = productGateway.getProduct(id).getBody();
        } else {
            return "redirect:/shop/product/all";
        }
        model.addAttribute("product", productDto);
        return "product-info";
    }

    @GetMapping
    public String showForm(Model model, @RequestParam(name = "id", required = false) Long id) {
        ProductDto productDto;
        if (id != null) {
            productDto = productGateway.getProduct(id).getBody();
        } else {
            productDto = new ProductDto();
        }
        model.addAttribute("product", productDto);
        model.addAttribute("manufacturers", manufacturerGateway.getManufacturerList());
        return "product-form";
    }

    @PostMapping
    public String saveProduct(ProductDto productDto) {
        Set<CategoryDto> categories = productService.getCategoryDtoFromString(productDto);
        productDto.setCategories(categories);
        if (productDto.getId() != null) {
            productGateway.handleUpdate(productDto.getId(), productDto);
        } else {
            productGateway.handlePost(productDto);
        }
        return "redirect:/gbshop/product/all";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam(name = "id") Long id) {
        productService.deleteById(id);
        return "redirect:/gbshop/product/all";
    }
}
