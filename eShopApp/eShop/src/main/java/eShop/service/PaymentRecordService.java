package eShop.service;


import eShop.model.Category;
import eShop.model.Order;
import eShop.model.PaymentRecord;
import eShop.model.user.User;

import java.util.List;
import java.util.Map;

public interface PaymentRecordService {

    public PaymentRecord savePaymentRecord(Order order);
    public abstract Integer numberOfBooksByCategorySold(Category category);
    public abstract Double amountOfSalesBySupplier(User supplier);

}
