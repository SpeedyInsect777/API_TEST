package com.cydeo.Day03;

import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class Test_06_Practice_hr extends HrTestBase {

    @Test
    public void test01(){

        Response response =
                given().accept(ContentType.JSON)
                        .get("/countries");
      //  response.prettyPrint();

        //Get me 3rd country name

        JsonPath jp = response.jsonPath();

        String thirdCountryName = jp.getString("items[1].country_name");

        System.out.println(thirdCountryName);

        List<String> region2 = jp.getList("items.findAll{it.region_id==2}.country_name");

        System.out.println(region2);

    }
}
