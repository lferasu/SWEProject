package eShop.service;

import eShop.model.Cart;
import eShop.model.Order;

public interface OrderService {

    public Order saveOrder(Cart cart);
}
