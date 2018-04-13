package com.example.android.tictactoe2.Splashscreen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.android.tictactoe2.OptionsActivity.OptionMenu;
import com.example.android.tictactoe2.R;

@SuppressWarnings("ALL")
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
//        getWindow().getAttributes().windowAnimations = R.style.Fade;

        //hides the title bar when the splash screen loads
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        @SuppressLint("CutPasteId") TextView tic = findViewById(R.id.tic);
        TextView tac = findViewById(R.id.tac);
        TextView toe = findViewById(R.id.toe);
        ImageView imageViewGif = findViewById(R.id.gifImageView);

        Typeface ticText = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");
        tic.setTypeface(ticText);
        Typeface tacText = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");
        tac.setTypeface(tacText);
        Typeface toeText = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");
        toe.setTypeface(toeText);


        @SuppressLint("CutPasteId") ImageView tictactoe = findViewById(R.id.tictactoe);
        YoYo.with(Techniques.FlipInY)
                .duration(2000)
                .repeat(0)
                .playOn(findViewById(R.id.tictactoe));

        @SuppressLint("CutPasteId") TextView tic1 = findViewById(R.id.tic);
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(2)
                .playOn(findViewById(R.id.tic));
        @SuppressLint("CutPasteId") ImageView tac1 = findViewById(R.id.tictactoe);
        YoYo.with(Techniques.Hinge)
                .duration(2000)
                .repeat(1)
                .playOn(findViewById(R.id.tac));
        @SuppressLint("CutPasteId") ImageView toe1 = findViewById(R.id.tictactoe);
        YoYo.with(Techniques.Pulse)
                .duration(1800)
                .repeat(2)
                .playOn(findViewById(R.id.toe));

        YoYo.with(Techniques.Pulse)
                .duration(2200)
                .repeat(2)
                .playOn(findViewById(R.id.gifImageView));



        Thread timer = new Thread(){

            @Override
            public void run() {

                try {
                    sleep(3500);
                    Intent intent = new Intent(getApplicationContext(),OptionMenu.class);
                    startActivity(intent);
                    finish();
                    super.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        };

        timer.start();
    }
}
