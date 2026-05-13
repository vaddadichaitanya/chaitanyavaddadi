package com.amazon.health.fhir.data;

import com.github.javafaker.Faker;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class TestDataGenerator {

    private static final Faker faker = new Faker();

    public static Map<String, Object> generatePatientPayload() {
        Map<String, Object> patient = new HashMap<>();
        patient.put("resourceType", "Patient");

        // Name
        List<Map<String, Object>> nameList = new ArrayList<>();
        Map<String, Object> name = new HashMap<>();
        name.put("use", "official");
        name.put("family", faker.name().lastName());
        List<String> givens = new ArrayList<>();
        givens.add(faker.name().firstName());
        name.put("given", givens);
        nameList.add(name);
        patient.put("name", nameList);

        // Gender
        patient.put("gender", faker.options().option("male", "female", "other", "unknown"));

        // BirthDate
        // Format YYYY-MM-DD
        patient.put("birthDate", "19" + faker.number().numberBetween(50, 99) + "-0" + faker.number().numberBetween(1, 9) + "-1" + faker.number().numberBetween(0, 9));

        return patient;
    }
}
