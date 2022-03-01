package com.example.restassured_homework;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseStatus {
        public String StatusCode;
        public String StatusMessage;
}
