package eShop.service.impl;

import eShop.model.DeliveryInfo;
import eShop.model.Order;
import eShop.model.user.Supplier1;
import eShop.repository.DeliveryInfoRepository;
import eShop.service.DeliveryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryInfoServiceImpl implements DeliveryInfoService {
    @Autowired
    private DeliveryInfoRepository deliveryInfoRepository;

    public DeliveryInfo saveDeliveryInfo(Order order){

        DeliveryInfo deliveryInfo = new DeliveryInfo();
        deliveryInfo.setOrder(order);
        deliveryInfo.setCustomer(order.getCustomer());
        deliveryInfo.setOrderedDate(order.getDate());
        deliveryInfo.setSupplier(order.getCart().getBooks().get(0).getSupplier());
        deliveryInfo.setExpectedArrival(order.getDate().plusDays(5));

        //Generating tracking number
        int tracking = (int)(Math.random() * 1000000);

        deliveryInfo.setTrackingNumber(tracking);

        return deliveryInfoRepository.save(deliveryInfo);
    }
}
