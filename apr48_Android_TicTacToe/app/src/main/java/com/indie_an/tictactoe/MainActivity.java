package com.indie_an.tictactoe;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {

    // BUTTON DECLARATIONS THAT ARE USED TO FIND OUT EXACTLY WHAT SQUARE WAS CLICKED
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;
    public Button button9;


    public Button reset; // button to handle the game reset. only made visible when game is over
    public TextView text; // place to display whos turn it is and who won
    public StandardComputerPlay standard; // For when not using minimax aka when the computer goes first
    public MiniMaxSmartComputer smart; // For when using the minimax algorithm to try to win

    public Button userFirst; // BUTTONS TO HANDLE WHETHER THE USER GOES FIRST OR THE COMPUTER
    public Button computerFirst;

    // IMAGE VIEWS TO DISPLAY EITHER A YELLOW PIECE OR A RED
    public ImageView iv0;
    public ImageView iv1;
    public ImageView iv2;
    public ImageView iv3;
    public ImageView iv4;
    public ImageView iv5;
    public ImageView iv6;
    public ImageView iv7;
    public ImageView iv8;


    public RelativeLayout relative1; // used to display the tic tac toe board
    public boolean playerTurn = false; // boolean to be used to know whos turn it is
    public boolean playerWon = false; // boolean to hold whether or not the player won
    public boolean computerWon = false; // boolean to hold whether or not the computer won
    public boolean draw = false; // used to hold whether or not to draw
    public boolean winnable = true; //holds true if the computer should use the minimax algorithm to win
    public boolean playerFirst = true; // player goes first boolean
    public boolean midSet = false; //  holds the condition of whether or not the the middle spot has been played

    //Booleans to hold conditions for what spots have been played on the tic tac toe board
    public boolean tL = false;
    public boolean tC = false;
    public boolean tR = false;
    public boolean mL = false;
    public boolean mC = false;
    public boolean mR = false;
    public boolean bL = false;
    public boolean bC = false;
    public boolean bR = false;

    // array of strings that hold what pieces were placed where
    public String[] pieces = {"", "", "", "", "", "", "", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews(); // calls the beginning function
        standard = new StandardComputerPlay(); // creates an object of the ComputerLogic Class
        smart = new MiniMaxSmartComputer(); // creates object of the MiniMaxSmartComputer
    }

    private void initViews() {
        button1 = (Button) findViewById(R.id.button1); // creates objects to hold IDS of the xml File
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        reset = (Button) findViewById(R.id.reset);
        userFirst = (Button) findViewById(R.id.userFirst);
        computerFirst = (Button) findViewById(R.id.computerFirst);
        iv0 = (ImageView) findViewById(R.id.iv0);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        iv3 = (ImageView) findViewById(R.id.iv3);
        iv4 = (ImageView) findViewById(R.id.iv4);
        iv5 = (ImageView) findViewById(R.id.iv5);
        iv6 = (ImageView) findViewById(R.id.iv6);
        iv7 = (ImageView) findViewById(R.id.iv7);
        iv8 = (ImageView) findViewById(R.id.iv8);
        text = (TextView) findViewById(R.id.text);
        relative1 = (RelativeLayout) findViewById(R.id.relative1);

        button1.setOnClickListener(this); // sets listeners to determine whether or not a button was clicked
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        userFirst.setOnClickListener(this);
        computerFirst.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) { // function for handling button clicks
        switch (v.getId()) {
            case R.id.userFirst: // if the user first button was clicked
                // Make the menu item and views required to start the game invisible
                relative1.setVisibility(View.VISIBLE); // sets the tic tac toe board visible

                // makes the computer/user First buttons invisible while playing
                userFirst.setVisibility(View.INVISIBLE);
                computerFirst.setVisibility(View.INVISIBLE);
                if(playerFirst)
                {
                    playerTurn = true;
                    text.setText("Player's turn");
                }

                break;
            case R.id.computerFirst: // if the computer was clicked to play first
                relative1.setVisibility(View.VISIBLE); // sets vibility
                userFirst.setVisibility(View.INVISIBLE);
                computerFirst.setVisibility(View.INVISIBLE);
                playerTurn = false;
                playerFirst = false;
                text.setText("Computer's Turn");
                standard.nextMove(this); // calls the computer to play in the middle first
                break;
            case R.id.reset: // resets all the pieces of the Tic Tac Toe Android Game to get ready for a new game
                // Make all the invisible views visible again
                relative1.setVisibility(View.INVISIBLE);
                userFirst.setVisibility(View.VISIBLE);
                computerFirst.setVisibility(View.VISIBLE);
                reset.setVisibility(View.INVISIBLE);
                text.setText("");
                playerTurn = false;
                playerWon = false;
                computerWon = false;
                draw = false;
                button1.setText("");
                button2.setText("");
                button3.setText("");
                button4.setText("");
                button5.setText("");
                button6.setText("");
                button7.setText("");
                button8.setText("");
                button9.setText("");
                tL = false;
                tC = false;
                tR = false;
                mL = false;
                mC = false;
                mR = false;
                bL = false;
                bC = false;
                bR = false;

                pieces[0]=(""); // Resets the array of pieces played
                pieces[1]=("");
                pieces[2]=("");
                pieces[3]=("");
                pieces[4]=("");
                pieces[5]=("");
                pieces[6]=("");
                pieces[7]=("");
                pieces[8]=("");
                iv0.setImageResource(android.R.color.transparent); // hides the images by making them transparent
                iv1.setImageResource(android.R.color.transparent);
                iv2.setImageResource(android.R.color.transparent);
                iv3.setImageResource(android.R.color.transparent);
                iv4.setImageResource(android.R.color.transparent);
                iv5.setImageResource(android.R.color.transparent);
                iv6.setImageResource(android.R.color.transparent);
                iv7.setImageResource(android.R.color.transparent);
                iv8.setImageResource(android.R.color.transparent);
                break;
            default:
                if(userFirst.getVisibility() == View.VISIBLE)
                    break; // If a button is pressed without starting the game
                placeObject(v.getId());
                if(!midSet)
                    standard.nextMove(this); // Don't use minimax
                else
                    smart.nextMove(this); // Use minimax
        }
    }
    
    public void placeObject(int id) {
        Button button = (Button) findViewById(id);
        if(playerTurn)
        {
            //button.setText("X");
            if (button == button1.findViewById(R.id.button1) && !tL)
            {
                pieces[0] = "X";
                iv0.setImageResource(R.drawable.red);
                tL = true;
            }
            else if (button == button2.findViewById(R.id.button2) && !tC)
            {
                pieces[1] = "X";
                iv1.setImageResource(R.drawable.red);
                tC = true;
            }
            else if (button == button3.findViewById(R.id.button3) && !tR)
            {
                pieces[2] = "X";
                iv2.setImageResource(R.drawable.red);
                tR = true;
            }
            else if (button == button4.findViewById(R.id.button4) && !mL)
            {
                pieces[3] = "X";
                iv3.setImageResource(R.drawable.red);
                mL = true;
            }
            else if (button == button5.findViewById(R.id.button5) && !mC)
            {
                pieces[4] = "X";
                iv4.setImageResource(R.drawable.red);
                mC = true;
            }
            else if (button == button6.findViewById(R.id.button6) && !mR)
            {
                pieces[5] = "X";
                iv5.setImageResource(R.drawable.red);
                mR = true;
            }
            else if (button == button7.findViewById(R.id.button7) && !bL)
            {
                pieces[6] = "X";
                iv6.setImageResource(R.drawable.red);
                bL = true;
            }
            else if (button == button8.findViewById(R.id.button8) && !bC)
            {
                pieces[7] = "X";
                iv7.setImageResource(R.drawable.red);
                bC = true;
            }
            else if (button == button9.findViewById(R.id.button9) && !bR)
            {
                pieces[8] = "X";
                iv8.setImageResource(R.drawable.red);
                bR = true;
            }
        }

        check(); // check if the game is over
        if(playerWon && !draw) {
            reset.setVisibility(View.VISIBLE);
            text.setText("Player Won!");
        }
        // if the computer won then it displays that the computer did indeed win
        else if(computerWon && !draw) {
            reset.setVisibility(View.VISIBLE);
            text.setText("Computer Won!");
        }
        // if the game is a tie then it displays the game was indeede a tie
        else if(draw) {
            reset.setVisibility(View.VISIBLE);
            text.setText("It's a draw!");
        }
        else
            changeTurn();
    }

    public void changeTurn() { // changes whos turn it is
        playerTurn = !playerTurn;
        if(playerTurn)
            text.setText("Player's Turn");
        else
            text.setText("Computer's Turn");
    }

    public void check() { // checks the possible win combinations
        if (crossHorizontal() || crossVertical() || crossDiagonal()) {
                playerWon = true;
        }
        else if (naughtsHorizontal() || naughtsVertical() || naughtsDiagonal()) {
                computerWon = true;
        }
        else if(full() && !playerWon && !computerWon)
            draw = true;
    }

    public boolean full(){
        return !pieces[0].equals("")
                && !pieces[1].equals("")
                && !pieces[2].equals("")
                && !pieces[3].equals("")
                && !pieces[4].equals("")
                && !pieces[5].equals("")
                && !pieces[6].equals("")
                && !pieces[7].equals("")
                && !pieces[8].equals("");
    }

    public boolean isEmpty() {
        return pieces[0].equals("")
                && pieces[1].equals("")
                && pieces[2].equals("")
                && pieces[3].equals("")
                && pieces[4].equals("")
                && pieces[5].equals("")
                && pieces[6].equals("")
                && pieces[7].equals("")
                && pieces[8].equals("");
    }

    public boolean crossHorizontal() {
        return (pieces[0].equals("X") && pieces[1].equals("X") && pieces[2].equals("X")) ||
                (pieces[3].equals("X") && pieces[4].equals("X") && pieces[5].equals("X")) ||
                (pieces[6].equals("X") && pieces[7].equals("X") && pieces[8].equals("X"));
    }

    public boolean naughtsHorizontal() {
        return (pieces[0].equals("O") && pieces[1].equals("O") && pieces[2].equals("O")) ||
                (pieces[3].equals("O") && pieces[4].equals("O") && pieces[5].equals("O")) ||
                (pieces[6].equals("O") && pieces[7].equals("O") && pieces[8].equals("O"));
    }

    public boolean crossVertical() {
        return (pieces[0].equals("X") && pieces[3].equals("X") && pieces[6].equals("X")) ||
                (pieces[1].equals("X") && pieces[4].equals("X") && pieces[7].equals("X")) ||
                (pieces[2].equals("X") && pieces[5].equals("X") && pieces[8].equals("X"));
    }

    public boolean naughtsVertical() {
        return (pieces[0].equals("O") && pieces[3].equals("O") && pieces[6].equals("O")) ||
                (pieces[1].equals("O") && pieces[4].equals("O") && pieces[7].equals("O")) ||
                (pieces[2].equals("O") && pieces[5].equals("O") && pieces[8].equals("O"));
    }

    public boolean crossDiagonal() {
        return (pieces[0].equals("X") && pieces[4].equals("X") && pieces[8].equals("X")) ||
                (pieces[2].equals("X") && pieces[4].equals("X") && pieces[6].equals("X"));
    }

    public boolean naughtsDiagonal() {
        return (pieces[0].equals("O") && pieces[4].equals("O") && pieces[8].equals("O")) ||
                (pieces[2].equals("O") && pieces[4].equals("O") && pieces[6].equals("O"));
    }
}
