package com.ecommerce.payment.repository;

import com.ecommerce.payment.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<TransactionDetails,Long> {
}
