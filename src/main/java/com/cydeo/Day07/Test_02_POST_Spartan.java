package com.cydeo.Day07;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

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
    public void test01(){

        String newSpartan = " {\n" +
                "     \"gender\":\"Male\",\n" +
                "     \"name\":\"John Doe\",\n" +
                "     \"phone\":8877445596\n" +
                "     }";

        String message = "A Spartan is Born";

given().accept(ContentType.JSON).
        and().
        contentType("application/json").body(newSpartan).when().post("api/spartans/");


    }
}
