package eShop.service;


import eShop.model.Category;
import eShop.model.Order;
import eShop.model.PaymentRecord;
import eShop.model.user.User;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface PaymentRecordService {

    public PaymentRecord savePaymentRecord(Order order);
    public abstract Integer numberOfBooksByCategorySold(Category category);
    public abstract Double amountOfSalesBySupplier(User supplier, Integer monthAgo);
    public abstract LinkedHashMap<User, Double> topSupplierBySales(Integer monthAgo);
    public abstract Double totalSalesAmount();

}
