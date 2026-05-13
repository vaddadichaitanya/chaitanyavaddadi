package com.amazon.health.fhir.tests;

import com.amazon.health.fhir.base.BaseApiTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CoverageApiTest extends BaseApiTest {

    @Test
    public void testSearchCoverage() {
        Response response = RestAssured.given()
                .spec(requestSpec)
                .queryParam("_count", 5)
                .when()
                .get("/Coverage");

        Assert.assertEquals(response.getStatusCode(), 200, "Expected 200 OK status code");
        Assert.assertEquals(response.jsonPath().getString("resourceType"), "Bundle");
    }
}
