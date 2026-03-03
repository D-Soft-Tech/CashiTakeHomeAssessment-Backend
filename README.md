# 💳 Cashi Take-Home Assessment Backend

This repository contains the backend REST API for the **Cashi Take-Home
Assessment** built using **Java Spring Boot**.\
It implements the `/payments` endpoint required by the FinTech mobile
application and handles payment processing requests.

The backend was built to support a Kotlin Multiplatform mobile app where
payments are processed via API and stored in Firebase Firestore.

------------------------------------------------------------------------

## 🚀 Overview

The purpose of this backend service is to:

-   Expose a REST API endpoint to accept payment requests.
-   Validate and process payments.
-   Return appropriate success/error responses.
-   Serve as the payment processor for the Kotlin Multiplatform mobile
    app.

This service is implemented using Spring Boot with a clean layered
architecture.

------------------------------------------------------------------------

## 📦 Features

### 🔹 API Endpoint

**POST `/payments`**

Accepts a JSON payload:

``` json
{
    "recipientEmail": "recipientemail@gexample.com",
    "amount": "30000.00",
    "currency" : "USD",
    "narration" : "Payment from test app"
}
```

Returns a response containing processed payment metadata or an error
message if validation fails.

------------------------------------------------------------------------

## 🧠 Technical Stack

Component            Technology
  -------------------- -----------------------------
Backend Framework    Java Spring Boot
Build Tool           Maven
Java Version         17+
API Server           Embedded Tomcat
JSON Serialization   Jackson
Validation           Spring Validation
Logging              Spring Boot Starter Logging

------------------------------------------------------------------------

## 🛠️ Getting Started

### 1️⃣ Clone the Repository

``` bash
git clone https://github.com/D-Soft-Tech/CashiTakeHomeAssessment-Backend
cd CashiTakeHomeAssessment-Backend
```

### 2️⃣ Build the Project

Ensure you have JDK 17+ and Maven installed.

``` bash
./mvnw clean install
```

### 3️⃣ Run the API

``` bash
./mvnw spring-boot:run
```

The API will start on:

    http://localhost:8080

------------------------------------------------------------------------

## 🎯 API Usage Example

Using curl:

``` bash
curl -X POST http://localhost:8080/payments \
     -H "Content-Type: application/json" \
     -d '{
            "recipientEmail": "recipientemail@gexample.com",
            "amount": "30000.00",
            "currency" : "USD",
            "narration" : "Payment from test app"
        }'
```

Expected success response:

``` json
{
    "transactionReference": "2TdhggMf2D2YnuXzpykH",
    "recipientEmail": "recipientemail@example.com",
    "transactionAmount": 30000.00,
    "currency": "USD",
    "paymentStatus": "SUCCESSFUL",
    "requestTime": "2026-03-02 07:49 55 am",
    "transactionDateTime": "2026-03-02 07:49 57 am",
    "responseMessage": "Approved Successfully",
    "narration": "Payment from test app"
}
```

------------------------------------------------------------------------

## 🔗 Integration With Mobile App

This backend is consumed by the Kotlin Multiplatform mobile application:

1.  The app sends a request to `/payments`.
2.  On success, the app stores the transaction in Firebase Firestore.
3.  The transaction appears in real-time within the app's transaction
    history.

------------------------------------------------------------------------

## 🧩 Architecture

The project follows a clean layered structure:

-   **Controller Layer** -- Handles HTTP requests.
-   **Service Layer** -- Contains business logic.
-   **Repository Layer** -- Connects and saves data to FirebaseFirestore.
-   **DTOs** -- Request and response models.
-   **Validation Layer** -- Input validation using annotations.
-   **Exception Handling** -- Standardized error responses.

This design ensures scalability, testability, and maintainability.

------------------------------------------------------------------------

## 🚀 Future Improvements

-   Add database persistence (MySQL/PostgreSQL)
-   Add Swagger/OpenAPI documentation
-   Add CI/CD pipeline
-   Add authentication & authorization
-   Implement comprehensive unit & integration tests

------------------------------------------------------------------------

## 📌 Related Project

Mobile Application Repository:\
https://github.com/D-Soft-Tech/CashiTakeHomeAssessment-KMP

------------------------------------------------------------------------

## 👨‍💻 Author

Developed by [Adebayo Oloyede](https://www.linkedin.com/in/adebayo-oloyede/) as part of a Kotlin Multiplatform FinTech technical assessment for Cashi.
You can reah me on linkedin [here](https://www.linkedin.com/in/adebayo-oloyede/)

Email to: oloyedeadebayoolawale@gmail.com

Phone: +234 907 5771 869
