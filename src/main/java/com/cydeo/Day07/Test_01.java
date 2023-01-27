package com.cydeo.Day07;

import com.cydeo.Pojo.Student;
import com.cydeo.utilities.CydeoAPITestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test_01 extends CydeoAPITestBase {

   /*
   * Given accept type is application/json
   * path param ID 2
   * Major math
   * email mark@email.com
   * company Cydeo
   * street 777 5th ave
   * zipcode 33222
   * Ignore all unnecessary fields*/

    @DisplayName("GET /student/{id} 2")
    @Test
    public void test01(){
    JsonPath jp = given().log().all().accept(ContentType.JSON).
                and().pathParam("id",2).when().get("/student/{id}").then().extract().jsonPath();

        Student student1 = jp.getObject("students[0]",Student.class);

        System.out.println(student1);

    }
}
