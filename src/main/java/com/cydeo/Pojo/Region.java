package com.cydeo.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) //if we want to not add any fields
@Data
public class Region {

    @JsonProperty("region_id")
    private int regionsId;

    private String region_name;
    private List<String> links;
}
