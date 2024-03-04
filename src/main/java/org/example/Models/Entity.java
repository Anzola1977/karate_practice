package org.example.Models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Entity {
    private String name;
    private Data data;

    public Entity() {
        // Вот где собака порылась
        // Для десериализации объекта jackson'у нужен был пустой конструктор
        // Я вам об этом напоминал несколько раз, а сейчас сам забыл
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Entity(String name, Data data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public Data getData() {
        return data;
    }

    public String toJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }

    public Entity(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Entity entity = objectMapper.readValue(json, Entity.class);
        this.name = entity.getName();
        this.data = entity.getData();
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", this.name);
        map.put("data", this.data.toMap());
        return map;
    }
}
