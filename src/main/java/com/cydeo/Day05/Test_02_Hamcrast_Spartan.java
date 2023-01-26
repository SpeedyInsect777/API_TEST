package com.cydeo.Day05;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class Test_02_Hamcrast_Spartan extends SpartanTestBase {

    @DisplayName("Get Single Spartan with Hamcrast")
    @Test
    public void test01() {

        /*
     Given accept type is application/json
     And Path param id = 15
     When i send GET request to /api/spartans/{id}
     Then status code is 200
     And content type is json
     And spartan json data matching:
     "id": 15,
    "name": "Meta",
    "gender": "Female",
    "phone": 1938695106
     */
        JsonPath jp =
                given()
                        //  .log().ifValidationFails()
                        .accept(ContentType.JSON).
                        pathParam("id", 15).
                        when().get("/api/spartans/{id}")
                        //   .prettyPeek()
                        .then()
                        //  .log().ifValidationFails()
                        .statusCode(HttpStatus.SC_OK).
                        contentType("application/json").
                        body("id", is(15),
                                "name", is("Meta"),
                                "gender", is("Female"),
                                "phone", is(1938695106))
                        .extract()
                        .response()
                                .jsonPath();

    //    System.out.println("ID: " + response.path("id"));
        System.out.println("ID: " +jp.getInt("id"));

    }
}
