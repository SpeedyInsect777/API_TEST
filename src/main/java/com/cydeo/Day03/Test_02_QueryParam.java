package com.cydeo.Day03;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;

import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Test_02_QueryParam extends SpartanTestBase {


    /*
    Given acceptance file type Json
     id#  24
     When user sends GET Request to /api/spartan/search
     Then response status code 200
     And response content-type: application/json
     And "Female" should be in response payload (body)
     And "Janette" should be in response payload (body)
    */

    @DisplayName("Get Spartan with QueryParam")
    @Test
    public void test01() {

        Response response = given().accept(ContentType.JSON).
                and().queryParam("gender", "Female")
                .and().queryParam("nameContains", "e").
                when().get("/api/spartans/search");
        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.body().asString().contains("Female"));
        assertTrue(response.body().asString().contains("e"));
    }
    @DisplayName("Get Spartan with QueryParams with MAP")
    @Test
    public void test02() {

        Map<String,Object> queryMap= new HashMap<>();

        queryMap.put("gender","Female");
        queryMap.put("nameContains","e");

        Response response = given().accept(ContentType.JSON).queryParams(queryMap).
                when().get("/api/spartans/search");

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.body().asString().contains("Female"));
        assertTrue(response.body().asString().contains("e"));

    }
}



