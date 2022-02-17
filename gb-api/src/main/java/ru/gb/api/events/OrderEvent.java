package ru.gb.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.api.order.dto.OrderDto;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderEvent implements Serializable {

    static final long serialVersionUID = -8863620718965821728L;

    private OrderDto orderDto;
}
