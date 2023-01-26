package com.cydeo.Day04;

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

public class Test_02_CydeoAPI_Practice extends CydeoAPITestBase {
    /*TASK
    Given accept type is application/json
    * And path param is 2
    * When user send request /student/{id}
    * Then status code should be 200
    * And content type is application/json;charset=UTF-8
    * And Date header is exist
    * And Server header is enjoy
    * And verify the following
    * firstname Mark
    * batch 13
    * major math
    * emailAddress mark@@email.com
    * companyName Cydeo
    *  777 5th Ave
   zipcode 33222*/
    @DisplayName("SOLUTION")
    @Test
    public void test01() {
        Response response = given().log().all().accept(ContentType.JSON).pathParam("id", 2)
                .when().get("/student/{id}");
        //   response.prettyPrint();
        System.out.println("=======Status and File type confirmation=======");
        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertEquals("application/json;charset=UTF-8", response.contentType());
        JsonPath jp = response.jsonPath();
        String firstName = jp.getString("students.firstName");
        String batch = jp.getString("students.batch");
        String major = jp.getString("students.major");
        String emailAddress = jp.getString("students.contact.emailAddress");
        String companyName = jp.getString("students.company.companyName");
        String companyStreet = jp.getString("students.company.address.street");
        String companyZipCode = jp.getString("students.company.address.zipCode");
        System.out.println("firstName: " + firstName + " batch: " + batch + " major: " + major + " emailAddress: " + emailAddress);
        System.out.println(" company: " + companyName + " companyStreet: " + companyStreet + " companyZipCode: " + companyZipCode);
        //    List<String> address = jp.getList("students.company.address");
        //  System.out.println(address);
        //   System.out.println(address.size());
        // System.out.println(response.headers().toString());

        System.out.println("Content: " + response.headers().getValue("content-type"));
        System.out.println("server: " + response.headers().getValue("server"));
        System.out.println("date: " + response.headers().getValue("date"));
    }

    /*TASK
  Given accept type is application/json
  * And path param is 22
  * When user send request /student/batch/{batch}
  * Then status code should be 200
  * And content type is application/json;charset=UTF-8
  * And Date header is exist
  * And Server header is enjoy
  * And verify the following
  * batch 22
 */
    @DisplayName("SOLUTION")
    @Test
    public void test02() {

        Response response = given().log().all().
                and().accept(ContentType.JSON).
                and().pathParam("batch", 22).
                and().when().get("/student/batch/{batch}");
        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertEquals("application/json;charset=UTF-8", response.contentType());
        System.out.println(response.headers().toString());
//response.prettyPrint();
        List<String> listTest = response.path("firstName");
        System.out.println(listTest);
    }
}