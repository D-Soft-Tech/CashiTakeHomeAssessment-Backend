package com.adebayo.cashiTakeHomeAssessmentBackend.payment.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.adebayo.cashiTakeHomeAssessmentBackend.utils.AppConstants.FIREBASE_CREDENTIALS_TAG;

@Configuration
public class FirebaseConfig {
    @Bean
    public Firestore firestore() throws IOException {
        String firebaseConfig = System.getenv(FIREBASE_CREDENTIALS_TAG);
        if (firebaseConfig != null) {
            InputStream serviceAccountInputStream = new ByteArrayInputStream(firebaseConfig.getBytes(StandardCharsets.UTF_8));
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccountInputStream);
            FirebaseOptions firebaseOptions = FirebaseOptions.builder().setCredentials(credentials).build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(firebaseOptions);
            }
            return FirestoreClient.getFirestore();
        } else {
            throw new NullPointerException("Could not find the env. variable, FIREBASE_CREDENTIALS");
        }
    }
}
