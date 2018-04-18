package com.example.android.tictactoe2.BoardType;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.android.tictactoe2.NameActivity.NameThreeBoard;
import com.example.android.tictactoe2.OptionsActivity.AboutUs;
import com.example.android.tictactoe2.OptionsActivity.InstructionActivity;
import com.example.android.tictactoe2.R;

@SuppressWarnings("ALL")
public class FiveBoardActivity extends AppCompatActivity implements View.OnClickListener {

    Button[][] buttons = new Button[3][5];
    String player_1, player_2;
    private boolean player1Turn = true;
    private int roundCount;
    private int player1Points;
    private int player2Points;
    private int drawPoints;
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;
    private TextView drawPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five_board);
        getWindow().getAttributes().windowAnimations = R.style.Fade;
        setTitle("Five Board Game");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        textViewPlayer1 = findViewById(R.id.scorePlayer1);
        textViewPlayer2 = findViewById(R.id.scorePlayer2);
        drawPlayers = findViewById(R.id.drawPlayers);
nameDetails();

        Typeface player1text = Typeface.createFromAsset(getAssets(), "Lato-Light.ttf");
        textViewPlayer1.setTypeface(player1text);
        Typeface player2text = Typeface.createFromAsset(getAssets(), "Lato-Light.ttf");
        textViewPlayer2.setTypeface(player2text);

        LinearLayout wholeLayout = findViewById(R.id.layout_container);
        YoYo.with(Techniques.FadeIn)
                .duration(2800)
                .repeat(0)
                .playOn(findViewById(R.id.layout_container));

        try {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    String buttonID = "button_" + i + j;
                    int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    buttons[i][j] = findViewById(resID);
                    buttons[i][j].setOnClickListener(this);
                }
            }
        } catch (Exception e) {

        }

        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }

        if (player1Turn) {
            ((Button) v).setText("X");
        } else {
            ((Button) v).setText("O");
        }

        roundCount++;

        if (checkForWin()) {
            if (player1Turn) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (roundCount == 15) {
            draw();
        } else {
            player1Turn = !player1Turn;
        }

    }

    private boolean checkForWin() {
        String[][] field = new String[3][5];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }
        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && field[i][0].equals(field[i][3])
                    && field[i][0].equals(field[i][4])
                    && !field[i][0].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                return true;
            }
        }

        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            return true;
        }
        if (field[0][1].equals(field[1][2])
                && field[0][1].equals(field[2][3])
                && !field[0][1].equals("")) {
            return true;
        }
        if (field[0][2].equals(field[1][3])
                && field[0][2].equals(field[2][4])
                && !field[0][2].equals("")) {
            return true;
        }

        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")) {
            return true;
        }
        return field[0][3].equals(field[1][2]) && field[0][3].equals(field[2][1]) && !field[0][3].equals("") || field[0][4].equals(field[1][3]) && field[0][4].equals(field[2][2]) && !field[0][4].equals("");


    }

    private void player1Wins() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        player1Points++;
        builder.setMessage( player_1 + " Wins!");
        builder.setTitle("Congratulations!");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        builder.create().show();

        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_00));

        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_01));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_02));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_03));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_04));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_10));

        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_11));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_12));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_13));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_14));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_20));

        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_21));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_22));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_23));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_24));

nameDetails();
        updatePointsText();
        resetBoard();
    }
    public void nameDetails() {
        Intent information = getIntent();

        player_1 = information.getStringExtra("PLAYER_1");
        player_2 = information.getStringExtra("PLAYER_2");

        textViewPlayer1.setText(player_1);
        textViewPlayer2.setText(player_2);
    }
    private void player2Wins() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        player2Points++;
        builder.setMessage( player_2 + " Wins!");
        builder.setTitle("Congratulations");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
        builder.create().show();

        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_00));

        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_01));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_02));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_03));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_04));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_10));

        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_11));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_12));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_13));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_14));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_20));

        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_21));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_22));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_23));
        YoYo.with(Techniques.RubberBand)
                .duration(1800)
                .repeat(0)
                .playOn(findViewById(R.id.button_24));

nameDetails();
        updatePointsText();
        resetBoard();
    }

    private void draw() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        drawPoints = drawPoints + 1;
        builder.setMessage("Great Play, its a Draw!");
        builder.setTitle("Draw");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
        builder.create().show();
        Toast.makeText(this, "Its a Draw!", Toast.LENGTH_SHORT).show();

        updatePointsText();
        resetBoard();
    }

    @SuppressLint("SetTextI18n")
    private void updatePointsText() {
        textViewPlayer1.setText(player_1 + ": " + player1Points);
        textViewPlayer2.setText(player_2 + ": "  + player2Points);
        drawPlayers.setText("Draw: " + drawPoints);
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setText("");
            }
        }

        roundCount = 0;
        player1Turn = true;
    }

    private void resetGame() {
        player1Points = 0;
        player2Points = 0;
        drawPoints = 0;
        updatePointsText();
        resetBoard();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("roundCount", roundCount);
        outState.putInt("player1Points", player1Points);
        outState.putInt("player2Points", player2Points);
        outState.putInt("drawPoints", drawPoints);
        outState.putBoolean("player1Turn", player1Turn);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        roundCount = savedInstanceState.getInt("roundCount");
        player1Points = savedInstanceState.getInt("player1Points");
        player2Points = savedInstanceState.getInt("player2Points");
        drawPoints = savedInstanceState.getInt("drawPoints");
        player1Turn = savedInstanceState.getBoolean("player1Turn");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
        }
        switch (id) {
            case R.id.three_boards:
                Intent intent = new Intent(this, NameThreeBoard.class);
                startActivity(intent);
                nameDetails();
                finish();
                break;
            case R.id.five_boards:
                break;
            case R.id.aboutUs:
                Intent intent1 = new Intent(this, AboutUs.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.instructions:
                Intent intent2 = new Intent(this, InstructionActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.resetMenu:
                resetGame();
                break;
            case R.id.exit:
                finish();

                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //dialog for close of application
    @Override
    public void onBackPressed() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Tic Tac Toe");
        builder.setIcon(R.drawable.ttt2);
        builder.setMessage("Do you really want to exit? You will loose all game data.");
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