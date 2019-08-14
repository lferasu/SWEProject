package eShop.service.impl;

import eShop.model.BillingInfo;
import eShop.model.user.Customer1;
import eShop.repository.BillingInfoRepository;
import eShop.service.BillingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingInfoServiceImpl implements BillingInfoService {

        @Autowired
        private BillingInfoRepository billingInfoRepository;

        public List<BillingInfo> getAllBillingAddresses(Customer1 customer){

            return billingInfoRepository.findAllById(customer.getId());
    }
}
