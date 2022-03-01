package com.example.restassured_homework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Main {

    private static final String BASE_URL = "https://demoqa.com/BookStore/v1/Books";

    private static Response response;
    private static Book book;

    @BeforeTest
    public void setup(){
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get();
    }

//  on my ide only single assertion works --- read comments
    @Test
    public void check_status_codes() {

        var statusCodeOk = response.statusCode();
        Assert.assertEquals(statusCodeOk, 200, "Correct status code returned");

//        var statusCodeNotFound = response.statusCode();
//        Assert.assertEquals(statusCodeNotFound, 404, "Not found returned");
//
//        var statusCodeMethodNotAllowed = response.statusCode();
//        Assert.assertEquals(statusCodeMethodNotAllowed, 405, "Method not allowed returned");
//
//        var contentType = response.getContentType();
//        Assert.assertEquals(contentType, "application/json; charset=utf-8", "Correct content type returned");
//
//        Second version which don't work on my ide
//
//        if(response.statusCode() == 200){
//            ResponseStatus responseBody = response.as(ResponseStatus.class);
//
//            Assert.assertEquals("200", responseBody.StatusCode);
//            Assert.assertEquals("Correct Status Code", responseBody.StatusMessage);
//        } else if (response.statusCode() == 404) {
//            ResponseStatus responseBody = response.as(ResponseStatus.class);
//
//            Assert.assertEquals("404", responseBody.StatusCode);
//            Assert.assertEquals("Not found content", responseBody.StatusMessage);
//        }
    }

    @Test
    public void get_book_data() {
        // Deserializing the Response body into Books class
        Books books = response.getBody().as(Books.class);
        book = books.books.get(0);

    }

    @AfterTest
    public void check_book_property_values() {
        // check book publisher
        var publisher = book.publisher;
        Assert.assertEquals(publisher, "O'Reilly Media", "Correct publisher returned");

        // check book pages
        var pages = book.pages;
        Assert.assertEquals(pages, 234, "Correct number returned");

        System.out.println(book.publisher);
        System.out.println(book.pages);
    }

}