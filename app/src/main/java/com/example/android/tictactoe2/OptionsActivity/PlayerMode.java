package com.example.android.tictactoe2.OptionsActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.android.tictactoe2.NameActivity.NameFiveBoard;
import com.example.android.tictactoe2.NameActivity.NameThreeBoard;
import com.example.android.tictactoe2.R;

public class PlayerMode extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getAttributes().windowAnimations = R.style.Fade;
        setupWindowAnimations();
        setContentView(R.layout.player_mode);
        setTitle("Choose Player Mode");


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        final Button singlePlayer = findViewById(R.id.single_player);
        Button twoPlayers = findViewById(R.id.two_players);


        singlePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PlayerMode.this);
                builder.setMessage("Select board type to continue!");
                builder.setTitle("Play Mode");
                builder.setCancelable(true);
                builder.setNegativeButton("5*3 board type", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(PlayerMode.this, NameFiveBoard.class);
                        startActivity(intent);

                    }
                });

                builder.setNeutralButton("3*3 Board type", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(PlayerMode.this, NameThreeBoard.class);
                        startActivity(intent);
                    }
                });
                builder.create().show();
            }
        });


        twoPlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PlayerMode.this);
                builder.setMessage("Select board type to continue!");
                builder.setTitle("Play Mode");
                builder.setCancelable(true);
                builder.setNegativeButton("5*3 board type", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(PlayerMode.this, NameFiveBoard.class);
                        startActivity(intent);

                    }
                });

                builder.setNeutralButton("3*3 Board type", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(PlayerMode.this, NameThreeBoard.class);
                        startActivity(intent);
                    }
                });
                builder.create().show();
            }
        });


    }

    private void setupWindowAnimations() {
        Slide slide = (Slide) TransitionInflater.from(this).inflateTransition(R.transition.activity_slide);
        getWindow().setExitTransition(slide);
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


//        singlePlayer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PopupMenu popupMenu = new PopupMenu(PlayerMode.this, singlePlayer);
//                popupMenu.getMenuInflater().inflate(R.menu.menu_main,popupMenu.getMenu());
//
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//                        Intent intent = new Intent(PlayerMode.this, menuItem.getClass());
//                        startActivity(intent);
//                        Toast.makeText(PlayerMode.this,"you clicked " + menuItem.getItemId(), Toast.LENGTH_SHORT).show();
//                        return true;
//                    }
//
//                });
//                popupMenu.show();
//            }
//        });
//
//    }
//}
