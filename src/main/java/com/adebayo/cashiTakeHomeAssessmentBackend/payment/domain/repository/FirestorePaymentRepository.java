package com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.repository;

import com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.model.PaymentProcessingResponse;
import com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.model.PaymentRequestModel;
import org.springframework.stereotype.Repository;

@Repository
public interface FirestorePaymentRepository {
    PaymentProcessingResponse processPaymentViaFirebaseFireStore(PaymentRequestModel paymentRequestModel);
}
