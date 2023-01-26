package com.cydeo.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employees {

  @JsonProperty("first_name")
    private  String firstName;
    @JsonProperty("last_name")
    private  String lastName;
    private int salary;
}
