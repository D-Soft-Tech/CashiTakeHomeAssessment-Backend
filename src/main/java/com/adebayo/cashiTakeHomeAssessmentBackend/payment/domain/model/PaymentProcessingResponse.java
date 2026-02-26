package com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.model;

import com.adebayo.cashiTakeHomeAssessmentBackend.payment.data.dtos.PaymentStatus;
import com.adebayo.cashiTakeHomeAssessmentBackend.payment.data.dtos.SupportedCurrency;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PaymentProcessingResponse {
    private String transactionReference;
    private String recipientEmail;
    private BigDecimal amount;
    private SupportedCurrency currency;
    private PaymentStatus paymentStatus;
    private String requestDateTime;
    private String transactionDateTime;
    private String responseMessage;
}
