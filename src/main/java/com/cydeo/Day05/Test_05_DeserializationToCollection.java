package com.cydeo.Day05;


import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.apache.http.util.Asserts.notNull;
import static org.hamcrest.Matchers.*;

public class Test_05_DeserializationToCollection extends SpartanTestBase {

    /*
    * Given accept type is application/json
    * and path parma id=10
    * when i send GET request to /api.spartans
    * Then status code is 200
    * And content type is json
    * And spartan data matching:
    "id": 10,
    "name": "Lorenza",
    "gender": "Female",
    "phone": 3312820936
    * */

    @Test
    public void test01()
    {
        Response response = given().accept(ContentType.JSON).log().all().
                pathParam("id",10).when().get("/api/spartans/{id}").prettyPeek().
                then().statusCode(HttpStatus.SC_OK).contentType("application/json").extract().response();

        Map<String, Object> mapSpartan = response.as(Map.class);

        System.out.println("spartanMap: "+mapSpartan);

    }
    @Test
    public void test02()
    {
        JsonPath jp = given().accept(ContentType.JSON).log().all().
                pathParam("id",10).when().get("/api/spartans/{id}").prettyPeek().
                then().statusCode(HttpStatus.SC_OK).contentType("application/json").extract().jsonPath();

        Map<String, Object> mapSpartanJP = jp.getMap("");

        System.out.println("spartanMap: "+mapSpartanJP);



    }
    @Test
    public void test03(){
       Response response = given().accept(ContentType.JSON).get("/api/spartans");

        List<Map<String,Objects>> spartansList = response.as(List.class);

        System.out.println(spartansList);

        System.out.println("firstSpartan: "+response.path("[0]"));

       Map<Object,Object> firstSpartan = response.path("[0]");

        System.out.println("firstSpartan in Map: "+firstSpartan);
    }

}
