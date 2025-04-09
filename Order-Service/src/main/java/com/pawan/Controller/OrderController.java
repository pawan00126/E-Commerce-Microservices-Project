package com.pawan.Controller;

import com.pawan.DTO.OrderRequestDTO;
import com.pawan.DTO.OrderResponseDTO;
import com.pawan.DTO_Mapper.OrderDTO;
import com.pawan.DTO_Mapper.OrderMapper;
import com.pawan.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public OrderResponseDTO placeOrder(@RequestBody OrderRequestDTO request) {
        return service.placeOrder(request);
    }

    @GetMapping
    public List<OrderDTO> getAllOrders(){
        return service.getAllOrders()
                .stream()
                .map(OrderMapper::toDTO)
                .toList();
    }

    @GetMapping("{id}")
    public OrderDTO getOrderById(@PathVariable Long id){
        var order = service.getOrderById(id);
        if (order == null) {
            return getDummyOrder(); // Return a dummy order
        }
        return OrderMapper.toDTO(order);
    }


    private OrderDTO getDummyOrder() {
        OrderDTO dummy = new OrderDTO();
        dummy.setId(0L);
        dummy.setUserId(0L);
        dummy.setProductId(0L);
        return dummy;
    }

}
