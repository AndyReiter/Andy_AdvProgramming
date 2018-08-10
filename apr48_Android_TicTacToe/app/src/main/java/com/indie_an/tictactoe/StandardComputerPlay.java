package com.indie_an.tictactoe;

import android.os.Handler;
import android.view.View;

import java.util.Random;



// STANDARD COMPUTER PLAY CLASS

public class StandardComputerPlay {

    private MainActivity board;
    private boolean computerFirst = false;
    private boolean movePlayed = false; // Check to see if the computer played it's move

    public void nextMove(final MainActivity board) {
        computerFirst = !board.playerFirst && board.isEmpty(); // is Computer going first
        this.board = board;

        if(board.playerTurn) // if its the players turn then it doesnt run through this program
            return;

        Handler handler = new Handler(); // Give a delay of 1 second to make it look realistic
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                movePlayed = false;
                if (computerFirst && board.pieces[4].equals("")) {
                    board.iv4.setImageResource(R.drawable.yellow);
                    board.pieces[4] = "O";// Place the move in the center
                    board.midSet = true;
                    movePlayed = true;
                } else if(!computerFirst) {
                    if(!movePlayed) win(); // First priority goes to winning
                    if(!movePlayed) defend(); // Second priority goes to preventing player from winning
                    if(!movePlayed) randomMove(); // Make a random move
                }

                if(movePlayed) {
                    board.check();
                    if (board.playerWon && !board.draw) {
                        board.text.setText("Player Won!");
                        board.reset.setVisibility(View.VISIBLE);
                    }
                    else if (board.computerWon && !board.draw) {
                        board.text.setText("Computer Won!");
                        board.reset.setVisibility(View.VISIBLE);
                    }
                    else if (board.draw) {
                        board.text.setText("It's a draw!");
                        board.reset.setVisibility(View.VISIBLE);
                    }
                    else
                        board.changeTurn();
                }
            }
        }, 1000);

    }

    private void defend() {
        if(board.playerFirst)
        {
            if (board.pieces[0].equals("X") && board.pieces[1].equals("X") && board.pieces[2].equals("") && !board.playerTurn) {
                board.pieces[2]="O"; // sets the computer to block the user from winning
                board.iv2.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[2].equals("X") && board.pieces[1].equals("X") && board.pieces[0].equals("") && !board.playerTurn) {
                board.pieces[0]="O"; // sets the computer to block the user from winning
                board.iv0.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[0].equals("X") && board.pieces[2].equals("X") && board.pieces[1].equals("") && !board.playerTurn) {
                board.pieces[1]="O"; // sets the computer to block the user from winning
                board.iv1.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[3].equals("X") && board.pieces[4].equals("X") && board.pieces[5].equals("") && !board.playerTurn) {
                board.pieces[5]="O"; // sets the computer to block the user from winning
                board.iv5.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[5].equals("X") && board.pieces[4].equals("X") && board.pieces[3].equals("") && !board.playerTurn) {
                board.pieces[3]="O";// sets the computer to block the user from winning
                board.iv3.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[3].equals("X") && board.pieces[5].equals("X") && board.pieces[4].equals("") && !board.playerTurn) {
                board.pieces[4]="O"; // sets the computer to block the user from winning
                board.iv4.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[6].equals("X") && board.pieces[7].equals("X") && board.pieces[8].equals("") && !board.playerTurn) {
                board.pieces[8]="O"; // sets the computer to block the user from winning
                board.iv8.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[8].equals("X") && board.pieces[7].equals("X") && board.pieces[6].equals("") && !board.playerTurn) {
                board.pieces[6]="O"; // sets the computer to block the user from winning
                board.iv6.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[6].equals("X") && board.pieces[8].equals("X") && board.pieces[7].equals("") && !board.playerTurn) {
                board.pieces[7]="O"; // sets the computer to block the user from winning
                board.iv7.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[0].equals("X") && board.pieces[3].equals("X") && board.pieces[6].equals("") && !board.playerTurn) {
                board.pieces[6]="O"; // sets the computer to block the user from winning
                board.iv6.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[6].equals("X") && board.pieces[3].equals("X") && board.pieces[0].equals("") && !board.playerTurn) {
                board.pieces[0]="O"; // sets the computer to block the user from winning
                board.iv0.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[0].equals("X") && board.pieces[6].equals("X") && board.pieces[3].equals("") && !board.playerTurn) {
                board.pieces[3]="O"; // sets the computer to block the user from winning
                board.iv3.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[1].equals("X") && board.pieces[4].equals("X") && board.pieces[7].equals("") && !board.playerTurn) {
                board.pieces[7]="O"; // sets the computer to block the user from winning
                board.iv7.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[7].equals("X") && board.pieces[4].equals("X") && board.pieces[1].equals("") && !board.playerTurn) {
                board.pieces[1]="O"; // sets the computer to block the user from winning
                board.iv1.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[1].equals("X") && board.pieces[7].equals("X") && board.pieces[4].equals("") && !board.playerTurn) {
                board.pieces[4]="O"; // sets the computer to block the user from winning
                board.iv4.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[2].equals("X") && board.pieces[5].equals("X") && board.pieces[8].equals("") && !board.playerTurn) {
                board.pieces[8]="O"; // sets the computer to block the user from winning
                board.iv8.setImageResource(R.drawable.yellow);
                movePlayed = true;
            }  else if (board.pieces[8].equals("X") && board.pieces[5].equals("X") && board.pieces[2].equals("") && !board.playerTurn) {
                board.pieces[2]="O"; // sets the computer to block the user from winning
                board.iv2.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[2].equals("X") && board.pieces[8].equals("X") && board.pieces[5].equals("") && !board.playerTurn) {
                board.pieces[5]="O"; // sets the computer to block the user from winning
                board.iv5.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[0].equals("X") && board.pieces[4].equals("X") && board.pieces[8].equals("") && !board.playerTurn) {
                board.pieces[8]="O"; // sets the computer to block the user from winning
                board.iv8.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[8].equals("X") && board.pieces[4].equals("X") && board.pieces[0].equals("") && !board.playerTurn) {
                board.pieces[0]="O"; // sets the computer to block the user from winning
                board.iv0.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[0].equals("X") && board.pieces[8].equals("X") && board.pieces[4].equals("") && !board.playerTurn) {
                board.pieces[4]="O"; // sets the computer to block the user from winning
                board.iv4.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[2].equals("X") && board.pieces[4].equals("X") && board.pieces[6].equals("") && !board.playerTurn) {
                board.pieces[6]="O"; // sets the computer to block the user from winning
                board.iv6.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[6].equals("X") && board.pieces[4].equals("X") && board.pieces[2].equals("") && !board.playerTurn) {
                board.pieces[2]="O"; // sets the computer to block the user from winning
                board.iv2.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[2].equals("X") && board.pieces[6].equals("X") && board.pieces[4].equals("") && !board.playerTurn) {
                board.pieces[4]="O"; // sets the computer to block the user from winning
                board.iv4.setImageResource(R.drawable.yellow);
                movePlayed = true;
            }
        }
    }

    private void win() { // if the computer can win the game, then it will win the game
        if (board.playerFirst) {
            if (board.pieces[0].equals("O") && board.pieces[1].equals("O") && board.pieces[2].equals("") && !board.playerTurn) {
                board.pieces[2] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv2.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[2].equals("O") && board.pieces[1].equals("O") && board.pieces[0].equals("") && !board.playerTurn) {
                board.pieces[0] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv0.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[0].equals("O") && board.pieces[2].equals("O") && board.pieces[1].equals("") && !board.playerTurn) {
                board.pieces[1] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv1.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[3].equals("O") && board.pieces[4].equals("O") && board.pieces[5].equals("") && !board.playerTurn) {
                board.pieces[5] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv5.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[5].equals("O") && board.pieces[4].equals("O") && board.pieces[3].equals("") && !board.playerTurn) {
                board.pieces[3] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv3.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[3].equals("O") && board.pieces[5].equals("O") && board.pieces[4].equals("") && !board.playerTurn) {
                board.pieces[4] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv4.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[6].equals("O") && board.pieces[3].equals("O") && board.pieces[0].equals("") && !board.playerTurn) {
                board.pieces[0] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv0.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[8].equals("O") && board.pieces[7].equals("O") && board.pieces[6].equals("") && !board.playerTurn) {
                board.pieces[6] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv6.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[6].equals("O") && board.pieces[8].equals("O") && board.pieces[7].equals("") && !board.playerTurn) {
                board.pieces[7] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv7.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[0].equals("O") && board.pieces[3].equals("O") && board.pieces[6].equals("") && !board.playerTurn) {
                board.pieces[6] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv6.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[6].equals("O") && board.pieces[3].equals("O") && board.pieces[0].equals("") && !board.playerTurn) {
                board.pieces[0] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv0.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[0].equals("O") && board.pieces[6].equals("O") && board.pieces[3].equals("") && !board.playerTurn) {
                board.pieces[3] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv3.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[1].equals("O") && board.pieces[4].equals("O") && board.pieces[7].equals("") && !board.playerTurn) {
                board.pieces[7] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv7.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[7].equals("O") && board.pieces[4].equals("O") && board.pieces[1].equals("") && !board.playerTurn) {
                board.pieces[1] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv1.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[1].equals("O") && board.pieces[7].equals("O") && board.pieces[4].equals("") && !board.playerTurn) {
                board.pieces[4] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv4.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[2].equals("O") && board.pieces[5].equals("O") && board.pieces[8].equals("") && !board.playerTurn) {
                board.pieces[8] = "O";// if the opportunity presents itself to win here, computer will
                board.iv8.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[8].equals("O") && board.pieces[5].equals("O") && board.pieces[2].equals("") && !board.playerTurn) {
                board.pieces[2] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv2.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[2].equals("O") && board.pieces[8].equals("O") && board.pieces[5].equals("") && !board.playerTurn) {
                board.pieces[5] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv5.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[0].equals("O") && board.pieces[4].equals("O") && board.pieces[8].equals("") && !board.playerTurn) {
                board.pieces[8] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv8.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[8].equals("O") && board.pieces[4].equals("O") && board.pieces[0].equals("") && !board.playerTurn) {
                board.pieces[0] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv0.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[0].equals("O") && board.pieces[8].equals("O") && board.pieces[4].equals("") && !board.playerTurn) {
                board.pieces[4] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv4.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[2].equals("O") && board.pieces[4].equals("O") && board.pieces[6].equals("") && !board.playerTurn) {
                board.pieces[6] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv6.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[6].equals("O") && board.pieces[4].equals("O") && board.pieces[2].equals("") && !board.playerTurn) {
                board.pieces[2] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv2.setImageResource(R.drawable.yellow);
                movePlayed = true;
            } else if (board.pieces[2].equals("O") && board.pieces[6].equals("O") && board.pieces[4].equals("") && !board.playerTurn) {
                board.pieces[4] = "O"; // if the opportunity presents itself to win here, computer will
                board.iv4.setImageResource(R.drawable.yellow);
                movePlayed = true;
            }

        }
    }

    private void randomMove() { // this generates a random move for the computer to do if it doesnt have an opportunity to win
        Random r = new Random(); // or a need to block the user from winning

        while (!movePlayed) { // if the move hasnt been made yet
            switch (r.nextInt(9)) { // gets a random # 1 - 9
                case 0:
                    if (board.pieces[0].equals("") && !board.playerTurn) {
                        board.pieces[0]="O"; // place the piece here if the spot is available
                        board.iv0.setImageResource(R.drawable.yellow); // sets the image piece
                        movePlayed = true; // move place is true since computer did play
                    }
                    break;
                case 1:
                    if (board.pieces[1].equals("") && !board.playerTurn) {
                        board.pieces[1]="O"; // place piece here if the spot is available
                        board.iv1.setImageResource(R.drawable.yellow); // sets image piece
                        movePlayed = true; // move place is true since computer did play
                    }
                    break;
                case 2:
                    if (board.pieces[2].equals("") && !board.playerTurn) {
                        board.pieces[2]="O"; // places piece
                        board.iv2.setImageResource(R.drawable.yellow); // sets image
                        movePlayed = true; // move has been made
                    }
                    break;
                case 3:
                    if (board.pieces[3].equals("") && !board.playerTurn) {
                        board.pieces[3]="O"; // places piece
                        board.iv3.setImageResource(R.drawable.yellow); // sets image
                        movePlayed = true; // move has been made
                    }
                    break;
                case 4:
                    if (board.pieces[4].equals("") && !board.playerTurn) {
                        board.pieces[4]="O"; // places piece
                        board.iv4.setImageResource(R.drawable.yellow); // sets image
                        movePlayed = true; // move has been made
                    }
                    break;
                case 5:
                    if (board.pieces[5].equals("") && !board.playerTurn) {
                        board.pieces[5]="O"; // places piece
                        board.iv5.setImageResource(R.drawable.yellow); // sets image
                        movePlayed = true; // move has been made
                    }
                    break;
                case 6:
                    if (board.pieces[6].equals("") && !board.playerTurn) {
                        board.pieces[6]="O"; // places piece
                        board.iv6.setImageResource(R.drawable.yellow); // sets image
                        movePlayed = true; // move has been made
                    }
                    break;
                case 7:
                    if (board.pieces[7].equals("") && !board.playerTurn) {
                        board.pieces[7]="O"; // places piece
                        board.iv7.setImageResource(R.drawable.yellow); // sets image
                        movePlayed = true; // move has been made
                    }
                    break;
                case 8:
                    if (board.pieces[8].equals("") && !board.playerTurn) {
                        board.pieces[8]="O"; // places piece
                        board.iv8.setImageResource(R.drawable.yellow); // sets image
                        movePlayed = true; // move has been made
                    }
                    break;
            }
        }
    }
}
