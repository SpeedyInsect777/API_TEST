package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class SpartanAuthBase {

    @BeforeAll
    public static void init(){

        RestAssured.baseURI = "http://3.82.233.195:7000";

    }
}
