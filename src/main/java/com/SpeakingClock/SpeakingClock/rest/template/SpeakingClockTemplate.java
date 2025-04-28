package com.SpeakingClock.SpeakingClock.rest.template;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import com.SpeakingClock.SpeakingClock.rest.operation.SpeakingClockOperations;

import java.time.LocalTime;

@Service
public class SpeakingClockTemplate implements SpeakingClockOperations {

    private static final String[] HOURS = {"twelve", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten", "eleven"};

    private static final String[] MINUTES = {"oh", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    private static final String[] TENS = {"twenty", "thirty", "forty", "fifty"};

    @Override
    public String convertTimeToWords(@NotNull String time) {
        if (!time.matches("^(?:[01]\\d|2[0-3]):[0-5]\\d$")) {
            throw new IllegalArgumentException("Invalid time format");
        }

        if ("00:00".equals(time)) {
            return "It's Midnight";
        } else if ("12:00".equals(time)) {
            return "It's Midday";
        }

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        StringBuilder sb = new StringBuilder();
        sb.append("It's ");

        sb.append(HOURS[hour % 12]).append(" ");

        if (minute == 0) {
            sb.append("o'clock");
        } else if (minute < 20) {
            sb.append(MINUTES[minute]);
        } else {
            sb.append(TENS[(minute / 10) - 2]);
            if (minute % 10 != 0) {
                sb.append(" ").append(MINUTES[minute % 10]);
            }
        }

        return sb.toString();
    }

    @Override
    public String getCurrentSystemTimeInWords() {
        LocalTime now = LocalTime.now();
        String timeString = String.format("%02d:%02d", now.getHour(), now.getMinute());
        return convertTimeToWords(timeString);
    }
}
