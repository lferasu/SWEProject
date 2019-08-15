package eShop.service;

import eShop.model.Cart;
import eShop.model.Order;
import eShop.model.user.User;

import java.util.List;

public interface OrderService {

    public Order saveOrder(Cart cart);

}
