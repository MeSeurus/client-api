package ru.gb.api.events;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.api.common.enums.OrderStatus;
import ru.gb.api.order.dto.OrderDto;

@Data
@NoArgsConstructor
public class StatusOrderEvent extends OrderEvent {

    private OrderStatus prevOrderStatus;

    public StatusOrderEvent(OrderDto orderDto, OrderStatus prevOrderStatus) {
        super(orderDto);
    }

}
