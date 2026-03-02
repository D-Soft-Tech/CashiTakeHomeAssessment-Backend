package com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.model;

import com.adebayo.cashiTakeHomeAssessmentBackend.payment.data.dtos.PaymentStatus;
import com.adebayo.cashiTakeHomeAssessmentBackend.payment.data.dtos.SupportedCurrency;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.annotation.ServerTimestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequestModel {
    @DocumentId
    private String transactionReference;
    private String recipientEmail;
    private BigDecimal transactionAmount;
    private SupportedCurrency currency;
    private String requestTime;
    private String narration;
    @ServerTimestamp
    private Date transactionDateTime;
    private PaymentStatus paymentStatus;
}
