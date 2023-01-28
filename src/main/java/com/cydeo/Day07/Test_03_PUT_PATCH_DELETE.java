package com.cydeo.Day07;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.*;


import java.util.LinkedHashMap;
import java.util.Map;


import com.cydeo.Pojo.Spartan;
import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import org.junit.jupiter.api.*;


import static io.restassured.RestAssured.given;


public class Test_03_PUT_PATCH_DELETE extends SpartanTestBase {
    @DisplayName("POST Spartan with String body")
    @Test
    public void test01() {

        Map<String, Object> newSpartan = new LinkedHashMap<>();
        newSpartan.put("name", "Michael Jackson");
        newSpartan.put("gender", "Male");
        newSpartan.put("phone", 1234567890l);

        int idToUpdate = 102;

        given().log().all().contentType(ContentType.JSON).pathParam("id", idToUpdate).
                body(newSpartan).when().put("/api/spartans/{id}").then().statusCode(204);
    }

    @DisplayName("PATCH Spartan")
    @Test
    public void test02() {

        Map<String, Object> newSpartan = new LinkedHashMap<>();
        newSpartan.put("name", "Patch James");

        int idToUpdate = 102;

        given().log().all().contentType(ContentType.JSON).pathParam("id", idToUpdate).
                body(newSpartan).when().patch("/api/spartans/{id}").then().statusCode(204);
    }
    @DisplayName("DELETE Spartan")
    @Test
    public void test03() {

        Map<String, Object> newSpartan = new LinkedHashMap<>();
        int idToUpdate = 102;

        given().log().all().contentType(ContentType.JSON).pathParam("id", idToUpdate).
                body(newSpartan).when().delete("/api/spartans/{id}").then().statusCode(204);

        given().accept(ContentType.JSON).pathParam("id",idToUpdate).when().get("/api/spartans/{id}")
                .then().statusCode(404);
    }




}
