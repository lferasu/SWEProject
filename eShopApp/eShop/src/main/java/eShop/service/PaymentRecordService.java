package eShop.service;


import eShop.model.Order;
import eShop.model.PaymentRecord;

import java.util.List;
import java.util.Map;

public interface PaymentRecordService {

    public PaymentRecord savePaymentRecord(Order order);
    List<List<Map<Object, Object>>> getCanvasjsChartData();
}
