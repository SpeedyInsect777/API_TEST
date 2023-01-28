package com.cydeo.Day04;

import com.cydeo.utilities.ZippopotamTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Test_03_Zippopotamus extends ZippopotamTestBase {

    @Test
    public void test01(){

Response response = given().log().all().accept(ContentType.JSON).pathParam("postal-code",43302)
                .and().when().get("{postal-code}");

response.prettyPrint();

    }

}
