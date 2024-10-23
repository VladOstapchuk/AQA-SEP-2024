package org.prog.testng.rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

//TODO: Add location to rest params
//TODO: Add Location DTO with all sub objects
//TODO: For each user, print First Name + Last Name + Street Name + building id
public class RestHomework {

    @Test
    public void randomUserTest() {
        RequestSpecification specification = RestAssured.given();
        specification.baseUri("https://randomuser.me/");
        specification.basePath("/api/");
        specification.queryParam("inc", "gender,name,nat");
        specification.queryParam("noinfo");
        specification.queryParam("results", 10);

        Response response = specification.get();
        ValidatableResponse validatableResponse = response.then();

        validatableResponse.statusCode(200);
        validatableResponse.contentType(ContentType.JSON);
        response.body().prettyPrint();
}}
