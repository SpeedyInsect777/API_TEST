package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;

public class NewsApiBase {


    @BeforeAll
    public static void init() {

        RestAssured.baseURI = "https://newsapi.org/v2";

    }
}
