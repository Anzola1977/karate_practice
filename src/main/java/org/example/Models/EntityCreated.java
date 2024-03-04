package org.example.Models;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EntityCreated {
    private final String id;
    private final String createdAt;

    public EntityCreated(){
        this.id = "#string";
        this.createdAt = "#string";
    }

    public String getId() {
        return id;
    }

    public String toJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("createdAt", this.createdAt);
        return map;
    }
}
