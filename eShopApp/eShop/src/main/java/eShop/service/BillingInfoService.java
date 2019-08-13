package eShop.service;

import eShop.model.BillingInfo;
import eShop.model.user.Customer;

import java.util.List;

public interface BillingInfoService {

    List<BillingInfo> getAllBillingAddresses(Customer customer);
}
