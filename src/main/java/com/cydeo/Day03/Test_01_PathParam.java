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

public class Test_01_PathParam extends SpartanTestBase {

/*
Given acceptance file type Json
 id#  24
 When user sends GET Request to /api/spartan/{ID}
 Then response status code 200
 And response content-type: application/json
 And "Julio" should be in response payload (body)
*/

    @DisplayName("Get Spartan with PathParam {id} 24")
    @Test
    public void test01() {

        Response response = given().accept(ContentType.JSON)
                .and()
                .pathParam("id", 24)
                .when().get("/api/spartans/{id}");

        response.prettyPrint();
        //prints all

        assertEquals(HttpStatus.SC_OK, response.getStatusCode());
        //  assertEquals(200,response.getStatusCode());  Both same

        assertEquals("application/json", response.contentType());


        //
        assertTrue(response.body().asString().contains("Julio"));
    }
    /* =======> NEGATIVE TESTING WITH INVALID Parameters
     * Given acceptance file type Json
     * id#  500
     * When user sends GET Request to /api/spartan/{ID}
     * Then response status code 404
     * And response content-type: application/json
     * And "Not Found" should be in response payload (body)*/

    @Test
    public void test02() {

        Response response = given().accept(ContentType.JSON).pathParam("id", 500)
                .when().get("/api/spartans/{id}");
        response.prettyPrint();

        assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.body().asString().contains("Not Found"));

    }
    @Test
    public void test03(){
        Response response = given().accept(ContentType.JSON).get("/api/spartans/");
        response.prettyPrint();
    }

    @Test
    public void test001(){
        Response response = given().accept(ContentType.JSON).
                and()
                .queryParam("gender","Female")
                .and()
                .queryParam("nameContains","e").
                when().get("/api/spartans/search");
    }



}
