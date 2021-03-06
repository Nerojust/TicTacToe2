package com.example.android.tictactoe2.OptionsActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.TransitionInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.android.tictactoe2.R;

@SuppressWarnings("ALL")
public class OptionMenu extends AppCompatActivity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupWindowAnimations();
        setContentView(R.layout.option_menu);
        setTitle("Select Options");


        //hides the title bar when the splash screen loads
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final Button playmode = findViewById(R.id.playMode);
        Button instructions = findViewById(R.id.instructionsOptionMenu);
        Button aboutUS = findViewById(R.id.aboutUsOptionMenu);
        Button otherApps = findViewById(R.id.other_apps);
        LinearLayout linearLayout = findViewById(R.id.generallayout);
        Button exit = findViewById(R.id.exitGame);

        YoYo.with(Techniques.RotateIn)
                .duration(1300)
                .repeat(0)
                .playOn(findViewById(R.id.generallayout));

        YoYo.with(Techniques.FlipInY)
                .duration(1400)
                .repeat(1)
                .playOn(findViewById(R.id.playMode));

        YoYo.with(Techniques.FlipInY)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.instructionsOptionMenu));
        YoYo.with(Techniques.RotateIn)
                .duration(1700)
                .repeat(0)
                .playOn(findViewById(R.id.other_apps));

        YoYo.with(Techniques.RotateIn)
                .duration(1700)
                .repeat(0)
                .playOn(findViewById(R.id.aboutUsOptionMenu));

        YoYo.with(Techniques.FlipInY)
                .duration(1700)
                .repeat(0)
                .playOn(findViewById(R.id.exitGame));

playmode.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        PopupMenu popupMenu = new PopupMenu(OptionMenu.this, playmode);
        popupMenu.getMenuInflater().inflate(R.menu.menu_main,popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                return true;
            }

        });
        popupMenu.show();
    }
});


        playmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OptionMenu.this, PlayerMode.class);
                startActivity(intent);


            }
        });

        instructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OptionMenu.this, InstructionActivity.class);
                startActivity(intent);
            }
        });


        aboutUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OptionMenu.this, AboutUs.class);
                startActivity(intent);
            }
        });

        otherApps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OptionMenu.this, AppsByNero.class);
                startActivity(intent);
            }
        });


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(OptionMenu.this);
                builder.setCancelable(false);
                builder.setTitle("Tic Tac Toe");
                builder.setIcon(R.drawable.ttt3);
                builder.setMessage("Do you really want to exit?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //if user pressed "yes", then he is allowed to exit from application
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //if user select "No", just cancel this dialog and continue with app
                        dialog.cancel();
                    }
                });
                android.app.AlertDialog alert = builder.create();
                alert.show();
            }


        });
    }


    private void setupWindowAnimations() {
        Fade fade = (Fade) TransitionInflater.from(this).inflateTransition(R.transition.activity_fade);
        getWindow().setEnterTransition(fade);
    }


    //dialog for close of application
    @Override
    public void onBackPressed() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Tic Tac Toe");
//        builder.setIcon(R.drawable.pizza);
        builder.setMessage("Do you really want to exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        android.app.AlertDialog alert = builder.create();
        alert.show();
    }


}
