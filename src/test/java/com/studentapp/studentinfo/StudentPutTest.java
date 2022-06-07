package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentPutTest  extends TestBase {

    @Test
    public void updateRecord() {

        List<String> list = new ArrayList<>();
        list.add("Manual Testing");
        list.add("API Testing");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("hello");
        studentPojo.setLastName("hi");
        studentPojo.setEmail("prime123@gmail.com");
        studentPojo.setProgramme("Testing");
        studentPojo.setCourses(list);
        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 104)
                .body(studentPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
