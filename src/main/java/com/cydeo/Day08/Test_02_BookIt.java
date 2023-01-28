package com.cydeo.Day08;

import com.cydeo.utilities.BookItTestBase;
import com.cydeo.utilities.BookItUtil;
import com.cydeo.utilities.SpartanAuthBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Test_02_BookIt extends BookItTestBase {


    @DisplayName("GET /api/campuses")
    @Test
    public void test01() {
        String bearer = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxNzUzNiIsImF1ZCI6InN0dWRlbnQtdGVhbS1sZWFkZXIifQ.J8vU9Nk20OmUoblzqWpU0UfOMUz5sIvrOxQA66alcvE";

        given().accept(ContentType.JSON).header("Authorization", bearer)
                .when().get("/api/campuses").prettyPeek().then().statusCode(200);

    }

    // BookItUtil bookit = new BookItUtil();
    String accessToken = BookItUtil.getToken("lfinnisz@yolasite.com", "lissiefinnis");

    @DisplayName("GET /sign")
    @Test
    public void test02() {
        System.out.println(accessToken);
        given().accept(ContentType.JSON).
                header("Authorization", accessToken)
                .when().get("/api/campuses").prettyPeek().then().statusCode(200);

    }

    @DisplayName("GET /api/users/me")
    @Test
    public void test03() {

        given().accept(ContentType.JSON).header("Authorization", accessToken).when().
                get("/api/users/me").prettyPeek().then().statusCode(200);

    }

    @DisplayName("GET /api/users/me with OAUTH2")
    @Test
    public void test04() {

        given().accept(ContentType.JSON)
                .auth().oauth2(accessToken)
               // .header("Authorization", accessToken)
                .when().
                get("/api/users/me").prettyPeek().then().statusCode(200);

    }
}
