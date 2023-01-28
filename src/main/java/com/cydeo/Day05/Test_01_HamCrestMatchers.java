package com.cydeo.Day05;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_01_HamCrestMatchers {


    @DisplayName("Assertion/Matchers comparator")
    @Test
    public void test01() {

        Assert.assertEquals(9, 6 + 3);

        assertThat(9, is(6 + 3)); //is(someValue)

        assertThat(9, is(equalTo(6 + 3))); //is(equalTo(someValue))

        assertThat(9, equalTo(6 + 3));//equalTo(someValue)

        assertThat(5+5,not(9));

        assertThat(5+5,is(not(9)));

        assertThat(5+5,is(not(equalTo(9))));

        assertThat(5+5,is(greaterThan(9)));

        assertThat(5+5,greaterThan(9));

        assertThat(5+5,lessThanOrEqualTo(11));



    }

    @DisplayName("String practice")
    @Test
    public void test02(){

        String msg = "API is fun!";

        assertThat(msg,is("API is fun!"));

        assertThat(msg,equalTo("API is fun!"));

        assertThat(msg,equalToIgnoringCase("aPi is fun!"));

        assertThat(msg,endsWithIgnoringCase("fun!"));

        assertThat(msg,endsWith("fun!"));

        assertThat(msg,containsString("fun!"));

        assertThat(msg,containsStringIgnoringCase("fun!"));

    }
    @Test
    public void test03(){

        List<Integer> numList = Arrays.asList(3,5,10,77,44,56);

        assertThat(numList,hasSize(6));

        assertThat(numList,hasItem(44));

        assertThat(numList,hasItems(44,10,5,56));

        assertThat(numList,hasItems(greaterThan(15)));

        assertThat(numList,everyItem(greaterThan(2)));

        assertThat(numList,containsInRelativeOrder(3,5,10,77,44,56));



    }
}
