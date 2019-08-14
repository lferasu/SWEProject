package eShop.service;

import eShop.model.BillingInfo;
import eShop.model.user.Customer1;

import java.util.List;

public interface BillingInfoService {

    List<BillingInfo> getAllBillingAddresses(Customer1 customer);
}
