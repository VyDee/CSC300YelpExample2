package com.example.csc300yelpexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView restaurantLV;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        //initializes the array
        /*for (int i = 0; i < 10000;i++)
        {
            Core.yelpAPIRecord[i]= new YelpAPIRecord();
        }*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.restaurantLV = (ListView)this.findViewById(R.id.restaurantLV);

        YelpAPI yelp = new YelpAPI();
        yelp.start();
        //yelp.run();
        while(!yelp.haveData)
        {

        }


        Core.yelpAA = new YelpAPIArrayAdapter(this, R.layout.list_view_row_advanced,
                Core.yelpAPIRecord);
        ListView lv = (ListView)this.findViewById(R.id.restaurantLV);
        lv.setAdapter(Core.yelpAA);
       // lv.invalidateViews();

    }
}
