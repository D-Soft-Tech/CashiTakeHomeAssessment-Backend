package com.adebayo.cashiTakeHomeAssessmentBackend.payment.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {
    @Bean
    public Firestore firestore() {
        if (FirebaseApp.getApps().isEmpty()) {
            try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("firebase-admin-sdk.json")) {
                if (inputStream != null) {
                    FirebaseOptions firebaseOptions = FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(inputStream)).build();
                    FirebaseApp.initializeApp(firebaseOptions);
                } else {
                    throw new NullPointerException("firebase-admin-sdk.json could not be located in the project resources");
                }
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
                throw new RuntimeException(e);
            }
        }
        return FirestoreClient.getFirestore();
    }
}
