package eShop.service;

import eShop.model.user.Customer1;
import eShop.model.user.User;

public interface CustomerService {

    public abstract User getCustomerById(Integer id);
}
