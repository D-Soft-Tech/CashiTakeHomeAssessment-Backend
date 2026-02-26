package com.adebayo.cashiTakeHomeAssessmentBackend.payment.controller;

import com.adebayo.cashiTakeHomeAssessmentBackend.payment.data.dtos.PaymentRequestEntity;
import com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.model.PaymentProcessingResponse;
import com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payments")
    public PaymentProcessingResponse processPayment(@Valid @RequestBody PaymentRequestEntity paymentRequest) {
        return paymentService.processPayment(paymentRequest);
    }
}