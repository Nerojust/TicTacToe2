package com.example.android.tictactoe2.OptionsActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.tictactoe2.BoardType.FiveBoardActivity;
import com.example.android.tictactoe2.BoardType.ThreeBoardActivity;
import com.example.android.tictactoe2.R;

public class NameActivity_2player extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_2player);


        final EditText etPlayer1 = (EditText) findViewById(R.id.etPlayer1);
        final EditText etPlayer2 = (EditText) findViewById(R.id.etPlayer2);

        Button bPlay = (Button) findViewById(R.id.bPlay);

        bPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Getting strings from edit text
                String PLAYER_1 = "" + etPlayer1.getText().toString();
                String PLAYER_2 = "" + etPlayer2.getText().toString();


                Intent i = new Intent(NameActivity_2player.this,ThreeBoardActivity.class);


                //Adding data with intent to transfer.
                i.putExtra("PLAYER_1",PLAYER_1);
                i.putExtra("PLAYER_2",PLAYER_2);

                startActivity(i);

            }
        });
    }
}
