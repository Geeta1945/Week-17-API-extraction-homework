package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentsInfo() {
        Response response =given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleStudentInfo() {
        Response response =given()
                .pathParam("id",4) // pathParam without S
                .when()
                .get("/{id}"); // we are using single curly bracket
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchStudentWithParameter() {
        HashMap<String,Object>qParams = new HashMap<>();
        qParams.put("programme","Computer Science");
        qParams.put("limit",2);

        Response response =given()
//                .queryParam("programme","Computer Science")
//                .queryParam("limit",2)
                .queryParams(qParams)
                .when()
                .get("/list");
       // response.then().statusCode(200);
        response.prettyPrint();

    }

}
