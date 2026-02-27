package com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.service;

import com.adebayo.cashiTakeHomeAssessmentBackend.payment.data.dtos.PaymentRequestEntity;
import com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.model.PaymentProcessingResponse;
import com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.model.PaymentRequestModel;
import com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.repository.FirestorePaymentRepository;
import com.adebayo.cashiTakeHomeAssessmentBackend.utils.EntityMapper;
import com.adebayo.cashiTakeHomeAssessmentBackend.utils.TransactionReferenceGenerator;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImpl implements PaymentService {
    private final TransactionReferenceGenerator transactionReferenceGenerator;
    private final FirestorePaymentRepository paymentRepository;

    @Override
    public PaymentProcessingResponse processPayment(PaymentRequestEntity paymentRequest) {
        PaymentRequestModel paymentRequestModel = EntityMapper.mapToPaymentRequestModel(paymentRequest, transactionReferenceGenerator.generateTransactionReference());
        return paymentRepository.processPaymentViaFirebaseFireStore(paymentRequestModel);
    }

    public PaymentServiceImpl(TransactionReferenceGenerator transactionReferenceGenerator, FirestorePaymentRepository paymentRepository) {
        this.transactionReferenceGenerator = transactionReferenceGenerator;
        this.paymentRepository = paymentRepository;
    }
}
