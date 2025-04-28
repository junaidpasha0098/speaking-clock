package com.SpeakingClock.SpeakingClock.resource;

import com.SpeakingClock.SpeakingClock.SpeakingClockApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpeakingClockApplication.class)
@TestExecutionListeners(listeners = DependencyInjectionTestExecutionListener.class)
public class ResourceTest {

    @LocalServerPort
    protected int port;

    protected static String baseURI = "http://localhost:8080/";

    @Test
    public void test() {

    }
}