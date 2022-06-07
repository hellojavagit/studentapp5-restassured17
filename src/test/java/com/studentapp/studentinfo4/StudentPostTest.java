package com.studentapp.studentinfo4;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentPostTest extends TestBase {
    @Test
    public void createStudent() {

        List<String> list = new ArrayList<>();
        list.add("Selenium Test");
        list.add("Api Testing");

        StudentPojo studentPojo =  new StudentPojo();
        studentPojo.setFirstName("testing");
        studentPojo.setLastName("skills");
        studentPojo.setEmail("testingskillss@gmail.com");
        studentPojo.setProgramme("Test Engineer");
        studentPojo.setCourses(list);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(studentPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
