package com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.service;

import com.adebayo.cashiTakeHomeAssessmentBackend.payment.data.dtos.PaymentRequestEntity;
import com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.model.PaymentProcessingResponse;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    PaymentProcessingResponse processPayment(PaymentRequestEntity paymentRequest);
}
