package com.amazon.health.fhir.tests;

import com.amazon.health.fhir.base.BaseApiTest;
import com.amazon.health.fhir.data.TestDataGenerator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class PatientApiTest extends BaseApiTest {

    private String patientId;

    @Test(priority = 1)
    public void testCreatePatient() {
        Map<String, Object> payload = TestDataGenerator.generatePatientPayload();

        Response response = RestAssured.given()
                .spec(requestSpec)
                .body(payload)
                .when()
                .post("/Patient");

        Assert.assertEquals(response.getStatusCode(), 201, "Expected 201 Created status code");
        patientId = response.jsonPath().getString("id");
        Assert.assertNotNull(patientId, "Patient ID should not be null");
    }

    @Test(priority = 2, dependsOnMethods = "testCreatePatient")
    public void testGetPatient() {
        Response response = RestAssured.given()
                .spec(requestSpec)
                .pathParam("id", patientId)
                .when()
                .get("/Patient/{id}");

        Assert.assertEquals(response.getStatusCode(), 200, "Expected 200 OK status code");
        Assert.assertEquals(response.jsonPath().getString("id"), patientId, "Returned ID does not match");
    }
}
