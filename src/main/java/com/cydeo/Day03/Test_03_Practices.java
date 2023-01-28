package com.cydeo.Day03;


import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_03_Practices extends HrTestBase {
    /*Q1:
    - Given accept type is Json
    - When users sends request to /countries/US
    - Then status code is 200
    - And Content - Type is application/json
    - And response contains United States of America
    Q2:
    - Given accept type is Json
    - When users sends request to /employees/1
    - Then status code is 404
    Q3:
    - Given accept type is Json
    - When users sends request to /regions/1
    - Then status code is 200
    - And Content - Type is application/json
    - And response contains Europe
    - And header should contains Date
    - And Transfer-Encoding should be chunked
    */
    @DisplayName("Q1")
    @Test
    public void test01() {

        Response response = given().accept(ContentType.JSON).get("/countries");
        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.body().asString().contains("United States of America"));

    }

    @DisplayName("Q2")
    @Test
    public void test02() {

        Response response = given().accept(ContentType.JSON).queryParams("q", "{\"job_id\":\"IT_PROG\"}").
                when().get("/employees/");
        response.prettyPrint();

    }



    @DisplayName("Get request/countries with regionID")
    @Test
    public void test04() {

        Response response = given().accept(ContentType.JSON).queryParams("q", "{\"region_id\":2}").
                and().when().get("/countries");
        response.prettyPrint();

    }
}
