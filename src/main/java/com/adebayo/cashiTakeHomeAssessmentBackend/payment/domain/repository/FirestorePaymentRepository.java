package com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.repository;

import com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.model.PaymentProcessingResponse;
import com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.model.PaymentRequestModel;

public interface FirestorePaymentRepository {
    PaymentProcessingResponse processPaymentViaFirebaseFireStore(PaymentRequestModel paymentRequestModel);
}
