package com.studentapp.studentinfo2;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentPatchtest extends TestBase {
    @Test
    public void updateStudentWithPatch() {

        {
            StudentPojo studentPojo = new StudentPojo();
            studentPojo.setEmail("tester123@gmail.com");
            Response response = given()
                    .header("Content-Type", "application/json")
                    .pathParam("id", 104)
                    .body(studentPojo)
                    .when()
                    .patch("/{id}");
            response.then().statusCode(200);
            response.prettyPrint();

        }
    }
}
