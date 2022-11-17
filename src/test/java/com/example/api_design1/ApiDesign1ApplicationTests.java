package com.example.api_design1;


import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiDesign1ApplicationTests {

    @BeforeAll
    public static void setup() {
        APIController.main(null);
    }

    @Test
    public void getCurrentDateHappy() {
        given().
                when().
                get("/user/date").
                then().
                statusCode(200).body("current_date", equalTo(LocalDateTime.now().toLocalDate().toString()));
    }

    @Test
    public void getCurrentMonthHappy() {
        given().
                when().
                get("/user/month").
                then().
                statusCode(200).body("current_month", equalTo(LocalDateTime.now().toLocalDate().toString()));
    }

    @Test
    public void getCurrentYearHappy() {
        given().
                when().
                get("/user/year").
                then().
                statusCode(200).body("current_year", equalTo(LocalDateTime.now().toLocalDate().toString()));
    }

    @Test
    public void getEventForGivenDateHappy() {
        given().
                param("year", 2022).
                param("month", 11).
                param("date", 16).

                when().
                get("/date/event").

                then().
                statusCode(200);
    }

    @Test
    public void addEventHappy() throws JSONException {
        JSONObject postObj = new JSONObject().put("date", 2022);
        given().body(postObj.toString()).
                when().
                post("/event").
                then().
                statusCode(200);
    }

    @Test
    public void deleteEventHappy() {
        given().
                when().
                delete("/event").
                then().
                statusCode(200);
    }

    @Test
    public void getCurrentDateUnhappy() {
        given().
                when().
                get("/user/data").
                then().
                statusCode(404);
    }

    @Test
    public void getCurrentMonthUnhappy() {
        given().
                when().
                get("/user/months").
                then().
                statusCode(404);
    }

    @Test
    public void getCurrentYearUnhappy() {
        given().
                when().
                get("/user/years").
                then().
                statusCode(404);
    }

    @Test
    public void getEventForGivenDateUnhappy() {
        given().
                when().
                get("/date/events").
                then().
                statusCode(404);
    }

    @Test
    public void addEventUnhappy() {
        given().
                when().
                post("/events").
                then().
                statusCode(404);
    }

    @Test
    public void deleteEventUnhappy() {
        given().
                when().
                delete("/events").
                then().
                statusCode(404);
    }

}
