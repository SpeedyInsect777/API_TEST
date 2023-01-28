package com.cydeo.Day03;

import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class Test_05_Practices extends HrTestBase {

    @Test
    public void test01() {
        Response response = given().accept(ContentType.JSON).when().get("/countries");

        // response.prettyPrint();

        Object pathRegionID = response.path("items[2].region_id");
        Object pathCountryName = response.path("items[2].country_name");
        Object allCountryName = response.path("items.country_name");
        System.out.println(pathRegionID);
        System.out.println(allCountryName);

        List<Object> objectList2 = response.path("items.country_name");

        List<Object> countriesA = objectList2.stream().filter(p -> p.toString().contains("a")).collect(Collectors.toList());

        System.out.printf(countriesA.toString());


    }
}



