package com.adebayo.cashiTakeHomeAssessmentBackend.payment.data.dtos;

import java.util.concurrent.ThreadLocalRandom;

public enum PaymentStatus {
    PENDING, SUCCESSFUL, DECLINED, FAILED, ABORTED;

    public String getTransactionMessage() {
        switch (this) {
            case PENDING -> {
                return "Response not available at this time";
            }
            case SUCCESSFUL -> {
                return "Approved Successfully";
            }
            case FAILED -> {
                return "An error occurred";
            }
            case ABORTED -> {
                return "Unable to complete the transaction";
            }
            case DECLINED -> {
                return "Transaction Declined";
            }

            default -> {
                return "An unexpected error occurred";
            }
        }
    }

    public static PaymentStatus getRandomStatus() {
        PaymentStatus[] values = PaymentStatus.values();
        int randomIndex = ThreadLocalRandom.current().nextInt(values.length);
        return values[randomIndex];
    }
}
