package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;



public class ZippopotamTestBase {

    @BeforeAll

    public void init(){
        RestAssured.baseURI="http://api.zippopotam.us/us/";
    }
}
