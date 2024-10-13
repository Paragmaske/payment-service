package com.ecommerce.payment.service;

import com.ecommerce.payment.entity.TransactionDetails;
import com.ecommerce.payment.model.PaymentRequest;
import com.ecommerce.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class PaymentServiceImpl implements  PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public Long makePayment(PaymentRequest paymentRequest) {
        TransactionDetails transactionDetails=TransactionDetails.builder().paymentMode(paymentRequest.getPaymentMode().name())
                .payementDate(new Timestamp(System.currentTimeMillis()))
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getAmount())
                .build();
        TransactionDetails savedTransaction = paymentRepository.save(transactionDetails);
        return savedTransaction.getId();
    }
}
