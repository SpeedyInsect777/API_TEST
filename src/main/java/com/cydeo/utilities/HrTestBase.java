package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public abstract class  HrTestBase {

    @BeforeTest
    public static void init() {

        RestAssured.baseURI = "http://3.82.233.195:1000/ords/hr";
    }

    }