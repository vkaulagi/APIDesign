package com.example.api_design1;

import org.json.JSONObject;

import static spark.Spark.*;

import java.text.DateFormat;
import java.time.LocalDateTime;

public class APIController {
    public static void main(String[] args) {
        port(8080);
        get("/hello", (req, res) -> "Hello World");
        getCurrentDate();
        getCurrentMonth();
        getCurrentYear();
        getEventForGivenDate();
        addEvent();
        deleteEvent();
    }

    public static void getCurrentDate() {
        get("/user/date", (req, res) -> {
//            JSONObject requestBody = new JSONObject(req.body());
//            requestBody.get("")
            res.type("application/json");
            return new JSONObject().put("current_date", LocalDateTime.now().toLocalDate());
        });
    }

    public static void getCurrentMonth() {
        get("/user/month", (req, res) -> {
//            JSONObject requestBody = new JSONObject(req.body());
//            requestBody.get("")
            res.type("application/json");
            return new JSONObject().put("current_month", LocalDateTime.now().toLocalDate());
        });
    }

    public static void getCurrentYear() {
        get("/user/year", (req, res) -> {
//            JSONObject requestBody = new JSONObject(req.body());
//            requestBody.get("")
            res.type("application/json");
            return new JSONObject().put("current_year", LocalDateTime.now().toLocalDate());
        });
    }

    public static void getEventForGivenDate() {
        get("/date/event", (req, res) -> {
//            JSONObject requestBody = new JSONObject(req.body());
//            requestBody.get("");
            LocalDateTime.of(Integer.parseInt(req.queryParams("year")),
                    Integer.parseInt(req.queryParams("month")),
                    Integer.parseInt(req.queryParams("date")), 0, 0);
            res.type("application/json");
            return new JSONObject().put("event", LocalDateTime.now().toLocalDate());
        });

    }

    public static void addEvent() {
        post("/event", (req, res) -> {
            JSONObject requestBody = new JSONObject(req.body());
            requestBody.get("date");
            res.type("application/json");
            return new JSONObject().put("success", "ok");
        });
    }

    public static void deleteEvent() {
        delete("/event", (req, res) -> {
//            JSONObject requestBody = new JSONObject(req.body());
//            requestBody.get("")
            res.type("application/json");
            return new JSONObject().put("event", LocalDateTime.now().toLocalDate());
        });
    }
}

