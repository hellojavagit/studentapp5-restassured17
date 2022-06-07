package com.studentapp.studentinfo3;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentDeleteTest extends TestBase {

    @Test
    public void deleteSingleStudentInfo() {

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 9)
                .when()
                .delete("/{id}");
        response.then().statusCode(204);
        response.prettyPrint();
    }
}