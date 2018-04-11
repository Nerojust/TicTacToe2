package com.example.android.tictactoe2.OptionsActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.android.tictactoe2.R;

@SuppressWarnings("ALL")
public class AppsByNero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appsbynero);
        setTitle("Apps by Nerojust");

        //hides the title bar when the splash screen loads
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final Button pizza = findViewById(R.id.pizza_app);
        Button local_news = findViewById(R.id.local_news_app);
        Button world_news = findViewById(R.id.world_news_app);
        Button music = findViewById(R.id.music_app);
        Button earthquake = findViewById(R.id.earthquake_app);
        Button miwok = findViewById(R.id.miwok);
        Button movie = findViewById(R.id.movie_app);
        Button otherApps = findViewById(R.id.music_app);


        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/Nerojust/NerosPizzaApp"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        local_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        world_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        miwok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
