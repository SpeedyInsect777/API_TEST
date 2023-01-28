package com.cydeo.Day05;

import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.apache.http.util.Asserts.notNull;
import static org.hamcrest.Matchers.*;

public class Test_04_Hamcrast_Regions extends HrTestBase {
/*
      Given
               accept type is application/json
       When
               user sends get request to /regions
       Then
               response status code must be 200
               verify Date has values
               first region name is Europe
               first region id is 1
               four regions we have
               region names are not null
               Regions name should be same order as "Europe","Americas","Asia","Middle East and Africa"
               region ids needs to be 1,2,3,4
               print all the regions names

    */

    @Test
    public void test01(){
        given().accept(ContentType.JSON).get("/regions").then().statusCode(HttpStatus.SC_OK).header("Date",notNullValue())
                .body("items.region_name[0]",is("Europe"));



    }
}
