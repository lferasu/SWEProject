package eShop.service;


import eShop.model.Order;
import eShop.model.PaymentRecord;

public interface PaymentRecordService {

    public PaymentRecord savePaymentRecord(Order order);
}
