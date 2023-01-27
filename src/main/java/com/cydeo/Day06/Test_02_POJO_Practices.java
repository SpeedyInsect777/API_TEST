package com.cydeo.Day06;

import com.cydeo.Pojo.Employees;
import com.cydeo.Pojo.Region;
import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Test_02_POJO_Practices extends HrTestBase {

    @Test
    public void test01(){

       JsonPath jp = given().accept(ContentType.JSON).get("/regions").then().
                statusCode(HttpStatus.SC_OK).extract().jsonPath();

      Region region1 =  jp.getObject("items[0]",Region.class);

        System.out.println(region1.getRegionsId());
    }
    @Test
    public void test02(){

        JsonPath jp = given().accept(ContentType.JSON).get("/employees").then().
                statusCode(HttpStatus.SC_OK).extract().jsonPath();

        Employees employeesOne =  jp.getObject("items[2]",Employees.class);

        System.out.println(employeesOne.getFirstName());

}}
