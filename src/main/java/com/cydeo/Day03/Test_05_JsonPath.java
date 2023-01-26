package com.cydeo.Day03;

import com.cydeo.utilities.HrTestBase;
import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Test_05_JsonPath extends SpartanTestBase {

    @Test

    public void test01(){

        Response response = given().accept(ContentType.JSON).pathParam("id",10)
                .get("/api/spartans/{id}");

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

       int id = jsonPath.getInt("id");
        System.out.println(id);
        String name = jsonPath.getString("name");

        System.out.println(name);

        String gender = jsonPath.getString("gender");

        System.out.println(gender);

    }
}
