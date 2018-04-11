package com.example.android.tictactoe2.OptionsActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.android.tictactoe2.R;

public class InstructionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instruction);
        setTitle("How to Play: Game Instructions");

        //to display the title bar arrow button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        TextView tic1 = findViewById(R.id.tic1);
        TextView tic2 = findViewById(R.id.tic2);


        Typeface tic1text = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        tic1.setTypeface(tic1text);

        Typeface tic2text = Typeface.createFromAsset(getAssets(), "Roboto-Italic.ttf");
        tic2.setTypeface(tic2text);

        YoYo.with(Techniques.FadeIn)
                .duration(3000)
                .repeat(0)
                .playOn(findViewById(R.id.tic1));

        YoYo.with(Techniques.FadeIn)
                .duration(3000)
                .repeat(0)
                .playOn(findViewById(R.id.tic2));
    }

    //method for going back to the main activity pressing the back arrow
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }
        return true;
    }
}
