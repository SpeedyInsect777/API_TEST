package com.cydeo.utilities;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class BookItUtil {
    public static String getToken(String email, String password){


       return "Bearer "+ given().accept(ContentType.JSON).
                queryParam("email",email).
                queryParam("password",password).
                when().get("/sign").then().statusCode(200)
                .extract().jsonPath().getString("accessToken");


    }
}
