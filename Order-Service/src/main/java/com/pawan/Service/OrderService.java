package com.pawan.Service;

import com.pawan.DTO.OrderRequestDTO;
import com.pawan.DTO.OrderResponseDTO;
import com.pawan.DTO.ProductDTO;
import com.pawan.DTO.UserDTO;
import com.pawan.Entity.Order;
import com.pawan.FeignClients.ProductClient;
import com.pawan.FeignClients.UserClient;
import com.pawan.Repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private UserClient userClient;
    @Autowired
    private ProductClient productClient;


    public OrderResponseDTO placeOrder(OrderRequestDTO request) {
        // Save Order
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setProductId(request.getProductId());
        order = orderRepo.save(order);

        // Fetch user and product details
        UserDTO user = userClient.getUserById(order.getUserId());
        ProductDTO product = productClient.getProductById(order.getProductId());

        // Prepare response
        OrderResponseDTO response = new OrderResponseDTO();
        response.setOrderId(order.getId());
        response.setUser(user);
        response.setProduct(product);

        return response;
    }

    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }


    public Order getOrderById(Long id) {
        return orderRepo.findById(id).orElse(null);
    }
}
