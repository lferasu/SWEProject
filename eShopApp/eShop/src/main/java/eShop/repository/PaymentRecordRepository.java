package eShop.repository;

import eShop.model.PaymentRecord;
import eShop.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaymentRecordRepository extends JpaRepository<PaymentRecord, Integer> {
    public List<PaymentRecord> findAllByPaymentDateBetweenAndSupplier(LocalDate fromDate, LocalDate toDate, User supplier);
    public List<PaymentRecord> findAllByPaymentDateBetween(LocalDate fromDate, LocalDate toDate);
}
