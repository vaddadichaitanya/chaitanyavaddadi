package com.amazon.health.fhir.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {

    protected RequestSpecification requestSpec;

    @BeforeClass
    public void setup() {
        // Using a public HAPI FHIR server sandbox for testing
        RestAssured.baseURI = "https://hapi.fhir.org/baseR4";

        requestSpec = new RequestSpecBuilder()
                .setContentType("application/fhir+json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }
}
