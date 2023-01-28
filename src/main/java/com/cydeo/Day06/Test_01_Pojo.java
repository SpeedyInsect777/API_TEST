package com.cydeo.Day06;

import com.cydeo.Pojo.Search;
import com.cydeo.Pojo.Spartan;
import com.cydeo.utilities.HrTestBase;
import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class Test_01_Pojo extends SpartanTestBase {

@Test
public void test01(){

    Response response = given().accept(ContentType.JSON).pathParam("id",15)
             .when().get("/api/spartans/{id}").then().statusCode(HttpStatus.SC_OK).extract().response();

    Spartan spartan = response.as(Spartan.class);
/* "id": 15,
    "name": "Meta",
    "gender": "Female",
    "phone": 1938695106*/

    System.out.println("With Response| "+spartan);

    JsonPath jp = response.jsonPath();

    Spartan spartan1 = jp.getObject("", Spartan.class);
    System.out.println("With Json| "+spartan1);
}

/*
*  Create POJOs for All ID numbers 3,4,5 !
* */
@DisplayName("Creating POJOs for IDs 3,4,5")
@Test
    public void test02(){
    Response response = given().accept(ContentType.JSON)
            .when().get("/api/spartans/search")
            .then().statusCode(HttpStatus.SC_OK).extract().response();

   //RESPONSE Disadvantage
    //response.as()--> We can not get specific part of response ! ! !

    //JSON PATH

    JsonPath jp = response.jsonPath();

    Spartan spartanOne = jp.getObject("content[0]",Spartan.class);
    Spartan spartanTwo = jp.getObject("content[1]",Spartan.class);
    Spartan spartanThree = jp.getObject("content[2]",Spartan.class);

    System.out.println(spartanOne);
    System.out.println(spartanTwo);
    System.out.println(spartanThree);
}
    @Test
    public void test03() {
        JsonPath jp = given().accept(ContentType.JSON)
                .when().get("/api/spartans/search")
                .then().statusCode(HttpStatus.SC_OK).extract().jsonPath();

        Search search = jp.getObject("", Search.class);

        System.out.println(search.getContent().get(1));

        System.out.println(search.getContent().stream().filter(p -> p.getId() == 5).collect(Collectors.toList()));

    }
}
