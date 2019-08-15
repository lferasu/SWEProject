package eShop.service.impl;

import eShop.model.Order;
import eShop.model.PaymentRecord;
import eShop.model.user.Supplier1;
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
            paymentRecord.setSupplier(order.getCart().getBooks().get(0).getSupplier());
            paymentRecord.setAmount(order.getCart().getTotalPrice());
            paymentRecord.setPaymentDate(LocalDate.now());
            paymentRecord.setBillInfo(order.getCart().getCustomer().getBillingInfos().get(0));
            paymentRecord.setBooks(order.getCart().getBooks());
            paymentRecord.setCustomer(order.getCart().getCustomer());

        return paymentRecordRepository.save(paymentRecord);
    }
}
