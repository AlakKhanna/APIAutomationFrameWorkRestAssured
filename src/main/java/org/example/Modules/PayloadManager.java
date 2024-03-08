package org.example.Modules;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.Payload.pojos.Request.Auth;
import org.example.Payload.pojos.Request.Booking;
import org.example.Payload.pojos.Request.Bookingdates;

public class PayloadManager {
    private ObjectMapper objectMapper;

    //java-json

    public String createpayload(){
        Faker faker = new Faker();
        String firstname= faker.name().firstName();

        Booking booking = new Booking();
        booking.setFirstname(faker.name().firstName());
        booking.setLastname("Khanna");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-03-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("breakfast");
        System.out.println(booking);

        //this is object we need to convert it in json

        Gson gsonbuilder = new GsonBuilder().setPrettyPrinting().create();
        String jsonbooking= gsonbuilder.toJson(booking);
        System.out.println(jsonbooking);
        return jsonbooking;

    }

    public void updatepayload(){

    }

    public  void CreatePayLoadJackson(){//incomplete

    }
    public String setToken() throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(auth);



    }
}
