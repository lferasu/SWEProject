package eShop.service;

import eShop.model.DeliveryInfo;
import eShop.model.Order;

public interface DeliveryInfoService {

    public DeliveryInfo saveDeliveryInfo(Order order);
}
