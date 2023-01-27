package com.cydeo.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Student {

    private int studentId;
    private String major;
    private Contact contact;
}
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
class Contact{
    private String emailAddress;
    private Company company;

}
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
class Company{
    String companyName;

}
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
class Address{
    private String street;
    private int zipCode;
}