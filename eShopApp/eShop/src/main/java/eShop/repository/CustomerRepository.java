package eShop.repository;

import eShop.model.user.Customer1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer1,Integer> {
}
