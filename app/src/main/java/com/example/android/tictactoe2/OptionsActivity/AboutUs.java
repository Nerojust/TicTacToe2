package com.example.android.tictactoe2.OptionsActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.android.tictactoe2.R;

/**
 * Created by ighotouch on 03/04/2018.
 */

@SuppressWarnings("ALL")
public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);
        setTitle("About Us");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        ImageView imageView = findViewById(R.id.image);
        TextView designedImage = findViewById(R.id.designedBy);
        TextView name = findViewById(R.id.myName);
        TextView takeaclimb = findViewById(R.id.takeaclimb);
        TextView location = findViewById(R.id.alcLagos);
        TextView emailaddress = findViewById(R.id.email);
        TextView phonenumber = findViewById(R.id.phoneWhatsappText);
        LinearLayout houseeverthing = findViewById(R.id.houseeverything);


        YoYo.with(Techniques.ZoomIn)
                .duration(1600)
                .repeat(0)
                .playOn(findViewById(R.id.image));

        YoYo.with(Techniques.FlipInY)
                .duration(2400)
                .repeat(0)
                .playOn(findViewById(R.id.houseeverything));


        Typeface nameTextText = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        name.setTypeface(nameTextText);

        Typeface takeaclimbtext = Typeface.createFromAsset(getAssets(), "Roboto-Italic.ttf");
        takeaclimb.setTypeface(takeaclimbtext);

        Typeface alcText = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        location.setTypeface(alcText);

        Typeface emailtext = Typeface.createFromAsset(getAssets(), "Roboto-Thin.ttf");
        emailaddress.setTypeface(emailtext);

        Typeface phoneText = Typeface.createFromAsset(getAssets(), "san_fransico.ttf");
        phonenumber.setTypeface(phoneText);


    }
}
