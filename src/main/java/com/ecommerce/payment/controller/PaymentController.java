package com.ecommerce.payment.controller;

import com.ecommerce.payment.model.PaymentRequest;
import com.ecommerce.payment.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/payment")
@RestController
public class PaymentController {


    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Long> makePayment(@RequestBody PaymentRequest paymentRequest) {

        Long paymentId = paymentService.makePayment(paymentRequest);

        return new ResponseEntity<>(paymentId, HttpStatus.OK);
    }
}
