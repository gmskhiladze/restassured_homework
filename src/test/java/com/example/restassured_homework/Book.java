package com.example.restassured_homework;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    public String isbn;
    public String title;
    public String subTitle;
    public String author;
    public String published;
    public String publisher;
    public int pages;
    public String description;
    public String website;
}
