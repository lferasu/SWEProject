package eShop.repository;

import eShop.model.BillingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingInfoRepository extends JpaRepository<BillingInfo, Integer> {

    List<BillingInfo> findAllById(Integer id);

}
