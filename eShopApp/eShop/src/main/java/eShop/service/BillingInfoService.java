package eShop.service;

import eShop.model.BillingInfo;
import eShop.model.user.User;

import java.util.List;

public interface BillingInfoService {

    List<BillingInfo> getAllBillingAddresses(User customer);
}
