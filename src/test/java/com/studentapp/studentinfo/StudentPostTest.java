package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StudentPostTest extends TestBase {

    @Test
    public void createStudent() {

        List<String> courseList = new ArrayList<>();
        courseList.add("Java");
        courseList.add("Selenium");
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Prime");// you dont need to follow order its just for our ease the way we create the
        studentPojo.setLastName("testing");
        studentPojo.setEmail("primetesting@gmail.com");
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCourses(courseList);

//        String payload = "{\n" +
//                "    \"firstName\": \"alpha\",\n" +
//                "    \"lastName\": \"beta\",\n" +
//                "    \"email\": \"opotaossabla@gmail.com\",\n" +
//                "    \"programme\": \"covid\",\n" +
//                "    \"cources\": [\n" +
//                "        \"Accounting\",\n" +
//                "        \"Statistics\"\n" +
//                "    ]\n" +
//                "}\n";

        Response response=given()

                .header("Content-Type", "application/json")
                .body(studentPojo)//.body(payload)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();

    }
}
