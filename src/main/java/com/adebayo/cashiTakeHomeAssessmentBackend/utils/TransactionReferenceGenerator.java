package com.adebayo.cashiTakeHomeAssessmentBackend.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class TransactionReferenceGenerator {
    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public String generateTransactionReference() {
        StringBuilder stringBuilder = new StringBuilder(12);
        for (int i = 0; i < 12; i++) {
            stringBuilder.append(CHARS.charAt(RANDOM.nextInt(CHARS.length())));
        }
        return stringBuilder.toString();
    }
}
