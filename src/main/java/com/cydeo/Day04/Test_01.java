package com.cydeo.Day04;

import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class Test_01 extends HrTestBase {

    @Test
    public void test01() {

        Response response =
                given().accept(ContentType.JSON).get("/regions");
        //   response.prettyPrint();

        JsonPath jp = response.jsonPath();

        String countryName = jp.getString("items[0].region_name");
        System.out.println(countryName);
    }
    /*Given accept type is application/json
    And query param limit 200
    When user sends request/ employees
    Then user should see ..........
    * */
    @DisplayName("Get All /employees?limit=200 -->JSONPATH")
        @Test
        public void test02(){
Response response = given().accept(ContentType.JSON).and().queryParams("limit",200).when().get("/employees");

//response.prettyPrint();

JsonPath jp = response.jsonPath();
//Get all emails

        List<String> emails = jp.getList("items.email");

        System.out.println("emails: "+emails);

        //response.prettyPrint();
//Get all IT_PROGs  emails
        List<String> employees = jp.getList("items.findAll{it.job_id=='IT_PROG'}.email");

        System.out.println("IT_PROGs  emails: "+employees);
//Highest salary
        String highestSalary= jp.getString("items.max{it.salary}.first_name");
        System.out.println("Highest salary: "+highestSalary);

        String minSalary = jp.getString("items.min{it.salary}.first_name");

        System.out.println(minSalary);

        }
    }

