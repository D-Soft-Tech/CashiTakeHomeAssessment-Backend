package com.adebayo.cashiTakeHomeAssessmentBackend.payment.data.dtos;

public enum PaymentStatus {
    PENDING, PROCESSING, SUCCESSFUL, DECLINED, FAILED, ABORTED;

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
            case PROCESSING -> {
                return "Still processing, kindly wait";
            }

            default -> {
                return "An unexpected error occurred";
            }
        }
    }
}
