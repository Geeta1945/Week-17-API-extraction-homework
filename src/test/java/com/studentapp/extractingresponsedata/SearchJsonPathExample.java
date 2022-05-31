package com.studentapp.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class SearchJsonPathExample {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI ="http://localhost";
        RestAssured.port =3030;
      response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }


    // 1) Extract the value of limit
    @Test
    public void test001() {
     int limit_no =   response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : "+limit_no);
        System.out.println("------------------End of Test---------------------------");

    }

    // 2) Extract the total
    @Test
    public void test02() {

        int total =response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : "+total);
        System.out.println("------------------End of Test---------------------------");

    }





    @Test
    public void test002() {


     List<Integer> listOfIds= response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : "+listOfIds);
        System.out.println("------------------End of Test---------------------------");

    }

    // 3) Extract the name of 5th store
    @Test
    public void test003() {

        String name = response.extract().path("data[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : "+name);
        System.out.println("------------------End of Test---------------------------");
    }

    // 4) Extract the names of all the store
    @Test
    public void test004() {
        //
        List<String> listOfNames= response.extract().path("data.name");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of all the stores are : ");
        System.out.println("_________________________________");
        for (String store :listOfNames) {
            System.out.println(store);
        }
        System.out.println("------------------End of Test---------------------------");

    }

    // 5)Extract the storeId of all the store
    @Test
    public void test005() {

        List<Integer> listOfIds = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of all the store : ");
        System.out.println("_________________________________");
        for (int id :listOfIds) {
            System.out.println(id);
        }
        System.out.println("------------------End of Test---------------------------");
    }

    // 6) Print the size of the data list
    List<String> listOfData= response.extract().path("data");
    @Test
    public void test006() {

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the products are : "+listOfData.size());
        System.out.println("------------------End of Test---------------------------");
    }

    // 7) Get all the value of the store where store name is St Cloud

    @Test
    public void test007() {
       List<HashMap<String,?>> values = response.extract().path("data.findAll{it.name=='St Cloud'}");// this one is groovy language
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the store where store name is St Cloud: "+values);
        System.out.println("------------------End of Test---------------------------");
    }

    // 8) Get the address of the store where store name is Rochester
    @Test
    public void test008() {

      List<String>address =  response.extract().path("data.findAll{it.name=='Rochester'}.address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address of the store where store name is Rochester : "+address);
        System.out.println("------------------End of Test---------------------------");
    }



    // 9) Get all the services of 8th store
    @Test
    public void test09() {
        List<String> listOfServices = response.extract().path("data[7].services");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the services of 8th store are: "+listOfServices);
                System.out.println("------------------End of Test---------------------------");
    }

    // 10) Get store services of the store where service name = Windows Store
    @Test
    public void test010() {
        List<String> serviceName = response.extract().path("data.findAll{it.services.findAll{it.name=='Windows Store'}}.services.storeservices");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store services of the store where service name = Windows Store: "+serviceName);
        System.out.println("------------------End of Test---------------------------");
    }

    // 11) Get all the storeId of all the store
    @Test
    public void test011() {
        List<List<String >> ids = response.extract().path("data.services.storeId");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the storeId of all the store is : "+ids);
        System.out.println("------------------End of Test---------------------------");
    }
    // 12) Get all the storeId of all the store
    @Test
    public void test012() {
        List<Integer> ids = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the storeId of all the store is : "+ids);
        System.out.println("------------------End of Test---------------------------");
    }

}
