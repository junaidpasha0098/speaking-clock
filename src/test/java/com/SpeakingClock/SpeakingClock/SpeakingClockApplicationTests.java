package com.SpeakingClock.SpeakingClock;

import com.SpeakingClock.SpeakingClock.resource.ResourceTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class SpeakingClockApplicationTests extends ResourceTest {
	private String baseClockUrl = "/v1/clock";

	@BeforeEach
	public void setUp() {
		baseURI = "http://localhost";
		port = port;
	}

	@Test
	void testConvertValidTimeToWords() {
		given()
				.queryParam("time", "08:34")
				.when()
				.get(baseClockUrl + "/convert")
				.then()
				.statusCode(200)
				.body(equalTo("It's eight thirty four"));
	}

	@Test
	void testConvertMidnightTimeToWords() {
		given()
				.queryParam("time", "00:00")
				.when()
				.get(baseClockUrl + "/convert")
				.then()
				.statusCode(200)
				.body(equalTo("It's Midnight"));
	}

	@Test
	void testConvertMiddayTimeToWords() {
		given()
				.queryParam("time", "12:00")
				.when()
				.get(baseClockUrl + "/convert")
				.then()
				.statusCode(200)
				.body(equalTo("It's Midday"));
	}

	@Test
	void testGetCurrentSystemTimeInWords() {
		when()
				.get(baseClockUrl + "/current-time")
				.then()
				.statusCode(200)
				.body(notNullValue());
	}

	@Test
	void testConvertTimeToWords_OClock() {
		given()
				.queryParam("time", "03:00")
				.when()
				.get(baseClockUrl + "/convert")
				.then()
				.statusCode(200)
				.body(equalTo("It's three o'clock"));
	}

	@Test
	void testConvertTimeToWords_OneMinute() {
		given()
				.queryParam("time", "03:01")
				.when()
				.get(baseClockUrl + "/convert")
				.then()
				.statusCode(200)
				.body(equalTo("It's three one"));
	}

	@Test
	void testConvertTimeToWords_TensAndOnes() {
		given()
				.queryParam("time", "03:24")
				.when()
				.get(baseClockUrl + "/convert")
				.then()
				.statusCode(200)
				.body(equalTo("It's three twenty four"));
	}

	@Test
	void testConvertTimeToWords_TensOnly() {
		given()
				.queryParam("time", "03:20")
				.when()
				.get(baseClockUrl + "/convert")
				.then()
				.statusCode(200)
				.body(equalTo("It's three twenty"));
	}
}
