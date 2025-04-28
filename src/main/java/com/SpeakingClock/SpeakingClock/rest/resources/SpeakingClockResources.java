package com.SpeakingClock.SpeakingClock.rest.resources;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.SpeakingClock.SpeakingClock.rest.operation.SpeakingClockOperations;

@RestController
@RequestMapping("v1/clock")
public class SpeakingClockResources {
    @Autowired
    private SpeakingClockOperations clockOperations;

    @GetMapping("/current-time")
    public String getCurrentTime() {
        return clockOperations.getCurrentSystemTimeInWords();
    }

    @GetMapping("/convert")
    public String convertTime( @Valid @RequestParam("time") String time) {
        return clockOperations.convertTimeToWords(time);
    }

}
