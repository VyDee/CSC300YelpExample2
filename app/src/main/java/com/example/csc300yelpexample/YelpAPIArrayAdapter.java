package com.example.csc300yelpexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class YelpAPIArrayAdapter extends ArrayAdapter
{
    private Context mContext;
    private YelpAPIRecord[] yelpAPIRecordList = new YelpAPIRecord[Core.yelpAPIRecordArrayLength];
    private int textViewResourceId;

    public YelpAPIArrayAdapter (Context context, int textViewResourceId,
                                       YelpAPIRecord[] list)
    {
        super(context,textViewResourceId,list);
        this.mContext = context;
        this.yelpAPIRecordList = list;
        this.textViewResourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        //android will re-use existing rows for performance reasons.
        //this checks to see if the convertView is already a thing or not
        //if it is not a thing, it inflates the layout for use this time
        //it will likely be a thing the next time we process this row.
        View listItem = convertView;
        if(listItem == null)
        {
            listItem = LayoutInflater.from(mContext).
                    inflate(this.textViewResourceId,parent,false);
        }

        //Get the PatientRecord object from bucket position which
        //is the row in our listview we are currently filling
        YelpAPIRecord yelp = this.yelpAPIRecordList[position];

        TextView restaurantTV = (TextView)listItem.findViewById(R.id.restaurantTV);
        TextView phoneTV = (TextView)listItem.findViewById(R.id.phoneTV);

        restaurantTV.setText(yelp.restaurant);
        //ageTV.setText(pr.getAgeString());
        phoneTV.setText(yelp.phoneNumber);

        //return the View after we have set all of the values
        return listItem;
    }


}
