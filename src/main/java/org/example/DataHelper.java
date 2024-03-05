package org.example;

import com.github.javafaker.Faker;
import org.example.Models.Data;
import org.example.Models.Entity;
import org.example.Models.EntityCreated;
import org.example.Models.EntityUpdated;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;


public class DataHelper {
    static Entity entity = new Entity();
    static Data data = new Data();
    static Faker faker = new Faker(new Locale("en"));

    public static Map<String, Object> getEntityPostMap(String json) throws IOException {
        return new Entity(json).toMap();
    }


    public static Map<String, Object> getEntityCreatedMap() {
        return new EntityCreated().toMap();
    }

    public static Map<String, Object> getEntityUpdatedMap() {
        return new EntityUpdated().toMap();
    }

    public static void printMessage(Object message) {
        System.out.println(message);
    }

    public static String createEntityData() throws IOException {
        data.setCpuModel("Intel Core i9");
        data.setHardDiskSize("2 TB");
        data.setPrice(1300.67);
        data.setYear(2023);
        entity.setName(faker.name().fullName());
        entity.setData(data);
        return entity.toJson();
    }

    public static String updateEntityData() throws IOException {
        data.setCpuModel("Intel Core i12");
        data.setHardDiskSize("5 TB");
        data.setPrice(1800.0);
        data.setYear(2024);
        entity.setName(faker.name().fullName());
        entity.setData(data);
        return entity.toJson();
    }

    public static String patchEntityData() throws IOException {
        entity.setName(faker.name().fullName());
        return entity.toJson();
    }
}
