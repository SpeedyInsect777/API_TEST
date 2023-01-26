package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public abstract class CydeoAPITestBase {

    @BeforeTest
    public static void init() {
        RestAssured.baseURI = "https://api.training.cydeo.com";
    }
}
