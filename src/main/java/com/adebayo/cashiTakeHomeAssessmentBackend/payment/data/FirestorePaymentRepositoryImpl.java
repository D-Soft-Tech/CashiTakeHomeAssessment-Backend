package com.adebayo.cashiTakeHomeAssessmentBackend.payment.data;

import com.adebayo.cashiTakeHomeAssessmentBackend.payment.data.dtos.PaymentStatus;
import com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.model.PaymentProcessingResponse;
import com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.model.PaymentRequestModel;
import com.adebayo.cashiTakeHomeAssessmentBackend.payment.domain.repository.FirestorePaymentRepository;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ExecutionException;

import static com.adebayo.cashiTakeHomeAssessmentBackend.utils.AppConstants.FIRESTORE_PAYMENT_DOCUMENT;
import static com.adebayo.cashiTakeHomeAssessmentBackend.utils.EntityMapper.mapToPaymentResponse;
import static com.adebayo.cashiTakeHomeAssessmentBackend.utils.EntityMapper.toPaymentResponse;

@Repository
public class FirestorePaymentRepositoryImpl implements FirestorePaymentRepository {
    private final Firestore firestore;

    @Override
    public PaymentProcessingResponse processPaymentViaFirebaseFireStore(PaymentRequestModel paymentRequestModel) {
        try {
            ApiFuture<DocumentReference> firestorePaymentResponse = firestore.collection(FIRESTORE_PAYMENT_DOCUMENT).add(paymentRequestModel);
            String documentId = firestorePaymentResponse.get().getId(); // blocks until response is available
            DocumentSnapshot appFirestoreCreatedPaymentDocument = firestore.collection(FIRESTORE_PAYMENT_DOCUMENT).document(documentId).get().get();
            if (appFirestoreCreatedPaymentDocument.exists() && appFirestoreCreatedPaymentDocument.getCreateTime() != null) {
                PaymentRequestModel paymentResponse = appFirestoreCreatedPaymentDocument.toObject(PaymentRequestModel.class);
                if (paymentResponse != null) {
                    return mapToPaymentResponse(appFirestoreCreatedPaymentDocument, PaymentStatus.SUCCESSFUL, paymentResponse);
                } else {
                    return toPaymentResponse(paymentRequestModel, PaymentStatus.DECLINED);
                }
            } else {
                return toPaymentResponse(paymentRequestModel, PaymentStatus.FAILED);
            }
        } catch (ExecutionException | InterruptedException e) {
            return toPaymentResponse(paymentRequestModel, PaymentStatus.ABORTED);
        }
    }

    public FirestorePaymentRepositoryImpl(Firestore firestore) {
        this.firestore = firestore;
    }
}
