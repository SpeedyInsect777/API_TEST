package com.cydeo.Day05;

import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class Test_03_Hamcrest_HR extends HrTestBase {

    /*
     * Given accept type is Json
     * And parameters :q={"job_id":"IT_PROG"}
     * When users sends a GET request to "/employees"
     * Then status code is 200
     * And Content type is application/json
     * Verify:
     * -each employee has manager
     * -each employee working as IT_PROG
     * -each of them getting salary greater than 3000
     * -extract firstnames and emails into list
     */
    @Test
    public void test01() {

        JsonPath jsonPath = given().accept(ContentType.JSON).
                queryParam("q", "{\"job_id\":\"IT_PROG\"}")
                .when().get("/employees").then().statusCode(HttpStatus.SC_OK).
                contentType("application/json").
                body("items.job_id",
                        is(everyItem(equalToIgnoringCase
                                ("IT_PROG"))), "items.manager_id",
                        is(notNullValue()), "items.salary",
                        everyItem(greaterThan(3000))).extract().jsonPath();

        List<String> firstNames = jsonPath.getList("items.last_name");
        List<String> emails = jsonPath.getList("items.email");

        System.out.println(firstNames);
        System.out.println(emails);

    }
}
