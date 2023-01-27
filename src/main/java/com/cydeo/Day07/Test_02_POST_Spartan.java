package com.cydeo.Day07;

import com.cydeo.Pojo.Spartan;
import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

/*
     Given accept type is JSON
     And Content type is JSON
     And request json body is:
     {
     "gender":"Male",
     "name":"John Doe",
     "phone":8877445596
     }
     When user sends POST request to '/api/spartans'
     Then status code 201
     And content type should be application/json
     And json payload/response/body should contain:
     verify the success value is A Spartan is Born!
     "name": "John Doe",
     "gender": "Male",
     "phone": 1231231231
     */

public class Test_02_POST_Spartan extends SpartanTestBase {

    @DisplayName("POST Spartan with String body")
    @Test
    public void test01() {

        String newSpartan = " {\n" +
                "     \"gender\":\"Male\",\n" +
                "     \"name\":\"John Doe\",\n" +
                "     \"phone\":8877445596\n" +
                "     }";

        String message = "A Spartan is Born";

        JsonPath jsonPath = given().accept(ContentType.JSON).
                and().log().body().
                contentType("application/json").body(newSpartan).when().post("api/spartans/").
                then().statusCode(201).extract().jsonPath();

        assertEquals("John Doe", jsonPath.getString("data.name"));
        assertEquals("Male", jsonPath.getString("data.gender"));
        assertEquals(8877445596l, jsonPath.getLong("data.phone"));
        System.out.println("id: " + jsonPath.getInt("data.id"));

    }

    @DisplayName("POST Spartan with POJO")
    @Test
    public void test02() {

        Spartan newSpartan = new Spartan();
        newSpartan.setName("John Pojo");
        newSpartan.setGender("Male");
        newSpartan.setPhone(8877445596l);

        JsonPath jsonPath = given().accept(ContentType.JSON).
                and().log().body().
                contentType("application/json").
                body(newSpartan).//   ! ! !  Serialization  ! ! !
                        when().post("api/spartans/").
                then().statusCode(201).extract().jsonPath();

        assertEquals(newSpartan.getName(), jsonPath.getString("data.name"));
        assertEquals(newSpartan.getGender(), jsonPath.getString("data.gender"));
        assertEquals(newSpartan.getPhone(), jsonPath.getLong("data.phone"));

    }

    @DisplayName("POST Spartan with POJO and GET {id}")
    @Test
    public void test03() {

        Spartan newSpartan = new Spartan();
        newSpartan.setName("John Pojo");
        newSpartan.setGender("Male");
        newSpartan.setPhone(8877445596l);
        String message = "A Spartan is Born";
        int newSpartanId = given().accept(ContentType.JSON).
                and().log().body().
                contentType("application/json").
                body(newSpartan).//   ! ! !  Serialization  ! ! !
                        when().post("api/spartans/").
                then().statusCode(201).extract().jsonPath().getInt("data.id");

    }

    @DisplayName("POST Spartan with POJO and POJO")
    @Test
    public void test04() {

        Spartan newSpartan = new Spartan();
        newSpartan.setName("John Pojo");
        newSpartan.setGender("Male");
        newSpartan.setPhone(8877445596l);

        int newSpartanId = given().accept(ContentType.JSON).
                and().log().body().
                contentType("application/json").
                body(newSpartan).//   ! ! !  Serialization  ! ! !
                        when().post("api/spartans/").
                then().statusCode(201).extract().jsonPath().getInt("data.id");

    }

    @DisplayName("GET new Spartan with POJO")
    @Test
    public void test05() {

        Spartan newSpartan = new Spartan();
        newSpartan.setName("Jackson");
        newSpartan.setGender("Male");
        newSpartan.setPhone(1234567890l);

        int newSpartanId = given().accept(ContentType.JSON).
                and().log().body().
                contentType("application/json").
                body(newSpartan).//   ! ! !  Serialization  ! ! !
                        when().post("api/spartans/").
                then().statusCode(201).extract().jsonPath().getInt("data.id");

        Spartan mySpartan = given().accept(ContentType.JSON).
                contentType("application/json").
                pathParam("id", newSpartanId).
                when().get("api/spartans/{id}").
                then().statusCode(200).extract().jsonPath().getObject("", Spartan.class);
        System.out.println(mySpartan);
    }
}
