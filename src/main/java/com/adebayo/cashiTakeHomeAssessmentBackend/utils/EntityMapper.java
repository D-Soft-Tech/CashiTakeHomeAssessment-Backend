package com.adebayo.cashiTakeHomeAssessmentBackend.utils;

import com.adebayo.cashiTakeHomeAssessmentBackend.payment.data.dtos.PaymentRequestEntity;
import com.adebayo.cashiTakeHomeAssessmentBackend.payment.data.dtos.PaymentStatus;
import com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.model.PaymentProcessingResponse;
import com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.model.PaymentRequestModel;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;

import java.util.Objects;

import static com.adebayo.cashiTakeHomeAssessmentBackend.utils.DateTimeUtil.fromServerTimeToNormalTime;
import static com.adebayo.cashiTakeHomeAssessmentBackend.utils.DateTimeUtil.getCurrentDateTimeAsString;

public final class EntityMapper {
    public static PaymentRequestModel mapToPaymentRequestModel(PaymentRequestEntity requestEntity, String transactionReference) {
        return PaymentRequestModel.builder()
                .transactionReference(transactionReference)
                .requestTime(getCurrentDateTimeAsString())
                .recipientEmail(requestEntity.getRecipientEmail())
                .transactionAmount(requestEntity.getAmount())
                .currency(requestEntity.getCurrency())
                .narration(requestEntity.getNarration())
                .paymentStatus(PaymentStatus.SUCCESSFUL)
                .build();
    }

    public static PaymentProcessingResponse toPaymentResponse(PaymentRequestModel paymentRequestModel, PaymentStatus paymentStatus) {
        return PaymentProcessingResponse.builder()
                .paymentStatus(paymentStatus)
                .transactionAmount(paymentRequestModel.getTransactionAmount())
                .currency(paymentRequestModel.getCurrency())
                .transactionReference(paymentRequestModel.getTransactionReference())
                .recipientEmail(paymentRequestModel.getRecipientEmail())
                .transactionDateTime(paymentRequestModel.getRequestTime())
                .responseMessage(paymentStatus.getTransactionMessage())
                .build();
    }

    public static PaymentProcessingResponse mapToPaymentResponse(DocumentSnapshot firestoreResponseDocument, PaymentStatus paymentStatus, PaymentRequestModel paymentRequestModel) {
        String processedTime = fromServerTimeToNormalTime(Objects.requireNonNull(firestoreResponseDocument.getCreateTime()));

        return PaymentProcessingResponse.builder()
                .paymentStatus(paymentStatus)
                .transactionAmount(paymentRequestModel.getTransactionAmount())
                .currency(paymentRequestModel.getCurrency())
                .transactionReference(paymentRequestModel.getTransactionReference())
                .recipientEmail(paymentRequestModel.getRecipientEmail())
                .requestTime(paymentRequestModel.getRequestTime())
                .transactionDateTime(processedTime)
                .responseMessage(paymentStatus.getTransactionMessage())
                .narration(paymentRequestModel.getNarration())
                .build();
    }
}
