package com.example.csc300yelpexample;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class YelpAPI extends Thread
{
    public boolean haveData = false;



    @Override
    public void run()
    {
        try
        {
            URL businessEndpoint = new URL ("https://api.yelp.com/v3/businesses/search?location" +
                    "=Mequon+WI&categories=restaurants");
            HttpURLConnection conn = (HttpURLConnection)businessEndpoint.openConnection();
            conn.setRequestProperty("Authorization", "Bearer lXgnFmK3LAj00w7K588pz1CeSPhX39X_dzOoaqy6fI7vNmemohn2MhkugmrFoH8m9ZlIZEsuNykeexj8W8tq4qiLAQB8aO_bixHZZMszb61c2S0LHYgerZ2z8TbSXHYx");
            Scanner input = new Scanner(conn.getInputStream());
            String data = "";

            while (input.hasNextLine())
            {
                data = data + input.nextLine();
            }
            input.close();
            System.out.println("****DATA:" +data);

            //get businesses name
            JSONObject objBusiness = new JSONObject(data);
            JSONArray businesses = objBusiness.getJSONArray("businesses");


            //business Array
            Core.yelpRestaurant = new String[businesses.length()];

            //phone Array
            Core.yelpRestaurantPhone = new String[businesses.length()];
            Core.yelpAPIRecord = new YelpAPIRecord[businesses.length()];

            Core.yelpAPIRecordArrayLength = businesses.length();

            for (int i = 0; i < businesses.length();i++)
            {
                String name = businesses.getJSONObject(i).getString("name");
                String phone = businesses.getJSONObject(i).getString("phone");

                //System.out.println("***"+name);
                Core.yelpRestaurant[i]= ""+ name;
                Core.yelpRestaurantPhone[i] =""+ phone;
                YelpAPIRecord yelp = new YelpAPIRecord(name,phone);
                Core.yelpAPIRecord[i]=yelp;
                System.out.println("*** R"+ i +" " + Core.yelpRestaurant[i]);

            }

            this.haveData = true;


        }
        catch(Exception e)
        {
            System.out.println("***"+e.toString());
        }
    }


}
