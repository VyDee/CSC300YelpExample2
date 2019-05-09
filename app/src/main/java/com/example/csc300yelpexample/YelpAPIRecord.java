package com.example.csc300yelpexample;

public class YelpAPIRecord
{
    public String restaurant;
    public String phoneNumber;

    public YelpAPIRecord(String restaurant,String phoneNumber)
    {
        this.restaurant = restaurant;
        this.phoneNumber = phoneNumber;
    }

    public YelpAPIRecord()
    {
        this.restaurant = "restaurant";
        this.phoneNumber="phoneNumber";
    }

    public void display()
    {
        System.out.println("*******Restaurant " + this.restaurant+ " has phone number: " +
                    this.phoneNumber);

    }

}
