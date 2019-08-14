package eShop.service.impl;

import eShop.model.Cart;
import eShop.model.Order;
import eShop.model.PaymentRecord;
import eShop.model.user.Supplier;
import eShop.repository.PaymentRecordRepository;
import eShop.service.PaymentRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PaymentRecordServiceImpl implements PaymentRecordService {
    @Autowired
    private PaymentRecordRepository paymentRecordRepository;

    public PaymentRecord savePaymentRecord(Order order){
            PaymentRecord paymentRecord = new PaymentRecord();

            paymentRecord.setOrder(order);
            paymentRecord.setSupplier((Supplier) order.getCart().getBook().getSupplier());
            paymentRecord.setAmount(order.getCart().getTotalPrice());
            paymentRecord.setPaymentDate(LocalDate.now());
            paymentRecord.setBillInfo(order.getCart().getBillingInfo());
            paymentRecord.setBook(order.getCart().getBook());
            paymentRecord.setCustomer(order.getCart().getCustomer());

        return paymentRecordRepository.save(paymentRecord);
    }
}
