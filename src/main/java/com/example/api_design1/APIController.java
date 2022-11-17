package com.example.api_design1;

import org.json.JSONObject;

import static spark.Spark.*;

import java.time.LocalDateTime;

public class APIController {
    public static void main(String[] args) {
        port(8080);
        getCurrentDate();
        getCurrentMonth();
        getCurrentYear();
        getEventForGivenDate();
        addEvent();
        deleteEvent();
    }

    // Get today's date
    public static void getCurrentDate() {
        get("/user/date", (req, res) -> {
            res.type("application/json");
            return new JSONObject().put("current_date", LocalDateTime.now().toLocalDate());
        });
    }

    // Return current month
    public static void getCurrentMonth() {
        get("/user/month", (req, res) -> {
            res.type("application/json");
            return new JSONObject().put("current_month", LocalDateTime.now().toLocalDate());
        });
    }

    // Return current year
    public static void getCurrentYear() {
        get("/user/year", (req, res) -> {
            res.type("application/json");
            return new JSONObject().put("current_year", LocalDateTime.now().toLocalDate());
        });
    }

    // Check appointment
    public static void getEventForGivenDate() {
        get("/date/event", (req, res) -> {
            LocalDateTime.of(Integer.parseInt(req.queryParams("year")),
                    Integer.parseInt(req.queryParams("month")),
                    Integer.parseInt(req.queryParams("date")), 0, 0);
            res.type("application/json");
            return new JSONObject().put("event", LocalDateTime.now().toLocalDate());
        });

    }

    // Add appointment
    public static void addEvent() {
        post("/event", (req, res) -> {
            JSONObject requestBody = new JSONObject(req.body());
            requestBody.get("date");
            res.type("application/json");
            return new JSONObject().put("success", "ok");
        });
    }

    // Remove appointment
    public static void deleteEvent() {
        delete("/event", (req, res) -> {
            res.type("application/json");
            return new JSONObject().put("event", LocalDateTime.now().toLocalDate());
        });
    }
}

