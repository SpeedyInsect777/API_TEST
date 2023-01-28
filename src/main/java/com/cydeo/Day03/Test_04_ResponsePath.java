package com.cydeo.Day03;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;

import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.junit.jupiter.api.*;


import java.util.List;

public class Test_04_ResponsePath extends SpartanTestBase {


    /* Given accept type Json
    And pathParam ID# 10
    When user sends a get request to "api/spartans/{id}"
    Then status code is 200
    And Content-Type is "application/json"
    And response payload value match the following:
    ID is 10
    Name is Lorenza
    Gender is Female
    Phone is 3312820936
     */

    @DisplayName("Get Spartans with ResponsePath")
    @Test
    public void test01(){

        Response response = given().accept(ContentType.JSON).pathParam("id",10)
                .when().get("/api/spartans/{id}");
        response.prettyPrint();

     Object id = response.path("id");
        System.out.println(id);

        System.out.println(response.path("name").toString());
    }
@Test    public void test02(){

/*
    /* Given Spartan file Content-type Json
    And pathParam Spartan ID is 20
    When user sends a get request to "api/spartans/{id}"
    Then status code is 200
    And Content-Type is "application/json"
    And response payload value match the following:
    ID is 10
    Name is Xxxxxx
    Gender is Xxxxxx
    Phone is xxxxxxxxx
     */

        Response response = given().accept(ContentType.JSON).pathParam("id",20).
                get("/api/spartans/{id}");
        response.prettyPrint();

       Object obj1 = response.path("gender");
       Object obj2 = response.path("phone");
       
        System.out.println(obj1);
        System.out.println(obj2);
    }

@Test    public void test03(){

        Response response = given().accept(ContentType.JSON).when().get("/api/spartans");
      //  response.prettyPrint();

        System.out.println(response.path("[1].id")+" : name.[2]");

        List<Object> objectList = response.path("name");

        System.out.println(objectList);

        long paigeCount = objectList.stream().filter(p -> p.equals("Paige")).count();

        System.out.println(paigeCount);



    }

}
