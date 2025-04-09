package com.pawan.DTO_Mapper;

import com.pawan.Entity.Order;

public class OrderMapper {

    public static OrderDTO toDTO(Order order){
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setUserId(order.getUserId());
        dto.setProductId(order.getProductId());

        return dto;
    }
}
