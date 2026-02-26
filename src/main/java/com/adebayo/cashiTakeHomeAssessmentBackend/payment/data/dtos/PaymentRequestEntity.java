package com.adebayo.cashiTakeHomeAssessmentBackend.payment.data.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static com.adebayo.cashiTakeHomeAssessmentBackend.utils.AppConstants.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequestEntity {
    @NotNull(message = MESSAGE_EMAIL_REQUIRED)
    @NotBlank(message = MESSAGE_EMAIL_REQUIRED)
    @Email(message = MESSAGE_EMAIL_NOT_VALID)
    private String recipientEmail;

    @DecimalMin(value = "1.00", message = MESSAGE_INVALID_AMOUNT)
    private BigDecimal amount;

    private SupportedCurrency currency;
}
