package com.cydeo.Day08;

/*BASEURL —> https://newsapi.org/v2/

=========TASK 1 —> QUERY PARAM
- Given query param is q=“bitcoin”
 - And query param is apiKey=“yourKey”
 - When user sent request / everything endpoint
- Then status code should be 200
- And each articles contains “bitcoin”
=========TASK 2 —> X-Api-Key in HEADER
- Given query param is q=“bitcoin”
 - And header is X-Api-Key=“yourKey”
 - When user sent request / everything endpoint
- Then status code should be 200
- And each articles contains “bitcoin”
========TASK 3 —> Authorization in HEADER
- Given query param is q=“bitcoin”
 - And header is Authorization=“yourKey”
 - When user sent request / everything endpoint
- Then status code should be 200
- And each articles contains “bitcoin”
=======TASK 4 —> Authorization in HEADER
- Given query param is country=“us”
 - And header is Authorization=“yourKey”
 - When user sent request / top-headlines endpoint
- Then status code should be 200
- And print out all sources names*/

import com.cydeo.utilities.NewsApiBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Test_03_News_Api extends NewsApiBase {

    @DisplayName("Task_01")
@Test
    public void test01(){
    given().accept(ContentType.JSON).queryParam("apiKey","0cbdee0aca87429289c0722a9ee9560d")
            .and().queryParam("q","bitcoin").
            when().get("/everything").then().statusCode(200);
}

}
