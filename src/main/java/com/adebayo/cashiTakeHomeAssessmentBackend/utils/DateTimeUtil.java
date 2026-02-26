package com.adebayo.cashiTakeHomeAssessmentBackend.utils;

import com.google.cloud.Timestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.adebayo.cashiTakeHomeAssessmentBackend.utils.AppConstants.APP_DATE_TIME_FORMAT;

public final class DateTimeUtil {
    public static String getCurrentDateTimeAsString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(APP_DATE_TIME_FORMAT, Locale.getDefault());
        return LocalDateTime.now().format(dateTimeFormatter).toLowerCase();
    }

    public static String fromServerTimeToNormalTime(Timestamp timestamp) {
        String isoTime = Instant.ofEpochSecond(
                timestamp.getSeconds(),
                timestamp.getNanos()
        ).toString();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(APP_DATE_TIME_FORMAT);
        return dateTimeFormatter.withZone(ZoneId.of(ZoneId.systemDefault().getId())).format(Instant.parse(isoTime));
    }
}
