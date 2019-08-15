package eShop.service.impl;

import eShop.model.Cart;
import eShop.model.Order;
import eShop.model.user.User;
import eShop.repository.OrderRepository;
import eShop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Cart cart){
            Order order = new Order();
            order.setAmount(cart.getTotalPrice());
            order.setCart(cart);
            order.setCustomer(cart.getCustomer());
            order.setDate(LocalDate.now());
            order.setShippingAddress(cart.getCustomer().getShippingAddress());

            int random = (int)(Math.random() * 1000);
            String orderNumber = "ORDER" + random;

            order.setOrderNumber(orderNumber);

        return orderRepository.save(order);
    }

}
