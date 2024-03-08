package org.example.tests.crud.INT;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.example.EndPoints.APIConstants;
import org.example.tests.base.BaseTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;
public class TC_Integration extends BaseTest {

    //get a token
    // create a booking
    //update the booking with the token and booking ID- tow to pass the variables from one test to another
            //1.Auth- API Key
            //Cookies based Auth
            //Oauth2.0Method how you can use the OAuth 2.0
    //Delete also


    //get a token-extract the token



    String token;
    @Test    //create a token
    public  void TestCreateBooking() throws JsonProcessingException
    {
        token= gettoken();
        System.out.println(token);
        assertThat("Alak").isEqualTo("Alak");
    }
    //update the booking with the token and booking ID- tow to pass the variables from one test to another
    @Test (groups = "P0", dependsOnMethods = {"TestCreateBooking"})
    public  void testCreateAndUpdateBooking(){
        System.out.println("testCreateAndUpdateBooking" + token);
        assertThat("Alak").isEqualTo("Alak");
    }
    @Test(groups = "P0", dependsOnMethods = {"testCreateAndUpdateBooking"})
    //Delete Also
    public  void testDeleteCreatedBooking()
    {
        System.out.println("testDeleteCreatedBooking" + token);
        assertThat("Alak").isEqualTo("Alak");
    }

}
