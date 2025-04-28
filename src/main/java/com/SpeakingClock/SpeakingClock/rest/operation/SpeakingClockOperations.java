package com.SpeakingClock.SpeakingClock.rest.operation;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface SpeakingClockOperations {
    String convertTimeToWords(@NotNull String time);

    String getCurrentSystemTimeInWords();
}
