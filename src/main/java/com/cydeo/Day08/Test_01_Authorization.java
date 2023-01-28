package com.cydeo.Day08;

import com.cydeo.utilities.SpartanAuthBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Test_01_Authorization extends SpartanAuthBase {

//Negative Test Case

@DisplayName("GET Spartans as a Guest User >Expect 401")
@Test
    public void test01(){

given().accept(ContentType.JSON).when().get("/api/spartans").then().log().ifValidationFails()
        .statusCode(401).body("error",is("Unauthorized"));

}

    @DisplayName("GET Spartans as a Guest >Expect 200")
    @Test
    public void test02(){

        given().accept(ContentType.JSON).when().
            auth().basic("user","user"). //Basic Authorization with RestAssured
                get("/api/spartans").then().log().ifValidationFails()
                .statusCode(200);

    }
    @DisplayName("DELETE /api/spartans/{id} as a Editor >Expect 403")
    @Test
    public void test03(){

        given().pathParam("id",56).accept(ContentType.JSON).
                auth().basic("editor","editor"). //Basic Authorization with RestAssured
        when().delete("/api/spartans/{id}").then()
                .statusCode(403).body("error",is("Forbidden"));

    }

    @DisplayName("DELETE /api/spartans/{id} as a Admin >Expect 403")
    @Test
    public void test04(){

        given().pathParam("id",10).
                auth().basic("admin","admin"). //Basic Authorization with RestAssured
                when().delete("/api/spartans/{id}").then()
                .statusCode(204);

    }
}
