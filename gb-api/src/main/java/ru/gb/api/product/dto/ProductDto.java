package ru.gb.api.product.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;
import ru.gb.api.category.dto.CategoryDto;
import ru.gb.api.common.enums.Status;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    @NotBlank
    private String title;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=6, fraction=2)
    private BigDecimal cost;
    @PastOrPresent
    @JsonFormat(pattern="dd.MM.yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate manufactureDate;
    @NotNull
    private Status status;
    private String manufacturer;
    private Set<CategoryDto> categories;
}
