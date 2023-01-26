package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class ZippopotamTestBase {

    @BeforeTest
    public void init(){
        RestAssured.baseURI="http://api.zippopotam.us/us/";
    }
}
