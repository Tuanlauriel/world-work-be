package com.worldwork.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EntityResponse {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("timeStamp", new Date());
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", data);

        return ResponseEntity.status(status).body(map);
    }
}
