package com.example.android.tictactoe2.NameActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.tictactoe2.BoardType.FiveBoardActivity;
import com.example.android.tictactoe2.R;

@SuppressWarnings("ALL")
public class NameFiveBoard extends AppCompatActivity {
    private EditText etPlayer1;
    private EditText etPlayer2;
    private String PLAYER_1;
    private String PLAYER_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getAttributes().windowAnimations = R.style.Fade;
        setContentView(R.layout.namefiveboard);

        etPlayer1 = findViewById(R.id.etPlayer1);
        etPlayer2 = findViewById(R.id.etPlayer2);
        Button bPlay = findViewById(R.id.bPlay);
        Typeface player1text = Typeface.createFromAsset(getAssets(), "Roboto-LightItalic.ttf");
        etPlayer1.setTypeface(player1text);

        Typeface player2text = Typeface.createFromAsset(getAssets(), "Roboto-LightItalic.ttf");
        etPlayer2.setTypeface(player2text);


        bPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private boolean nameValidation() {
        if (TextUtils.isEmpty(etPlayer1.getText().toString().trim()) ||
                TextUtils.isEmpty(etPlayer2.getText().toString().trim())) {

            etPlayer1.setError("Please fill in your name");
            etPlayer2.setError("Please fill in your name");
            return false;
        }

        return true;
    }

    private void login() {

        if (nameValidation()) {
            //Getting strings from edit text
            PLAYER_1 = "" + etPlayer1.getText().toString();
            PLAYER_2 = "" + etPlayer2.getText().toString();

            Intent i = new Intent(NameFiveBoard.this, FiveBoardActivity.class);
            //Adding data with intent to transfer.
            i.putExtra("PLAYER_1", PLAYER_1);
            i.putExtra("PLAYER_2", PLAYER_2);
            startActivity(i);
            finish();

        } else {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        }
    }
}
