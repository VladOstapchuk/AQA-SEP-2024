package org.prog.testng.rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.prog.dto.ResultsDto;
import org.prog.dto.UserDto;
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
        specification.queryParam("inc", "gender,name,nat,location");
        specification.queryParam("noinfo");
        specification.queryParam("results", 10);

        Response response = specification.get();
        ValidatableResponse validatableResponse = response.then();

        validatableResponse.statusCode(200);
        validatableResponse.contentType(ContentType.JSON);

        ResultsDto dtoHW = response.body().as(ResultsDto.class);
        System.out.println("_______________________________________");
        System.out.println(dtoHW.getResults());
        for (UserDto user : dtoHW.getResults()) {
            System.out.println("UserDTO: " + dtoHW.getResults().indexOf(user));
            System.out.println("First Name: " + user.getName().getFirst()
                    + "\n" + "Last Name: " + user.getName().getLast()
                    + "\n" + "Street Name: " + user.getLocation().getStreet().getName()
                    + "\n" + "Building id: " + user.getLocation().getStreet().getNumber());
            System.out.println("______________________________");
        }

    }
}
