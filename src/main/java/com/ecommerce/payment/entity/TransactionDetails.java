package com.ecommerce.payment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@Table(name="transaction_details")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "transaction_id_seq")
    @SequenceGenerator(name="transaction_id_seq",initialValue = 1,allocationSize = 1)
    private long id;
    private long orderId;
    private String paymentMode;
    private String referenceNumber;
    private Timestamp payementDate;
    private String paymentStatus;
    private double amount;
}
