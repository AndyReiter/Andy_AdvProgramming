import java.util.ResourceBundle;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import java.util.List;
import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class WarController
{
    @FXML private Label p1NumTopLeft;
    @FXML private Label p2NumTopLeft;
    @FXML private Label p1NumBotRight;
    @FXML private Label p2NumBotRight;
    @FXML private Label player2Card;
    @FXML private Label gameOutcome;
    @FXML private Label handWinner;
    @FXML private Button shuffleCardButton;
    @FXML private Button playCardButton;
    @FXML private Button reshuffleAndReplayButton;
    @FXML private ImageView p1TopLeftSuit;
    @FXML private ImageView p1MidSuit;
    @FXML private ImageView p1BottomRightSuit;
    @FXML private ImageView p2TopLeftSuit;
    @FXML private ImageView p2MidSuit;
    @FXML private ImageView p2BottomRightSuit;
    
    
    
    //Image heartImage = new Image(new FileInputStream("Heart.png"));
    //p1TopLeftSuit = new ImageView(heartImage);
    //ImageView imageView = new ImageView();
    Image p1H = new Image("/Img/Heart.jpg");
    Image p1D = new Image("/Img/Diamond.jpg");
    Image p1S = new Image("/Img/Spade.jpg");
    Image p1C = new Image("/Img/Club.jpg");
    Image p2H = new Image("/Img/Heart.jpg");
    Image p2D = new Image("/Img/Diamond.jpg");
    Image p2S = new Image("/Img/Spade.jpg");
    Image p2C = new Image("/Img/Club.jpg");
    boolean deckWasShuffled = false;
    List<String> temp_Deck = new ArrayList<String>();
    List<String> p1_Deck = new ArrayList<String>();
    List<String> p2_Deck = new ArrayList<String>();
    List<String> deck = new ArrayList<String>(
                                              Arrays.asList("2-D", "3-D", "4-D", "5-D", "6-D", "7-D", "8-D", "9-D", "10-D", "11-D", "12-D", "13-D","14-D", "2-H", "3-H", "4-H", "5-H", "6-H", "7-H", "8-H", "9-H", "10-H", "11-H", "12-H", "13-H", "14-H", "2-C", "3-C", "4-C", "5-C", "6-C", "7-C", "8-C", "9-C", "10-C", "11-C", "12-C", "13-C", "14-C", "2-S", "3-S", "4-S", "5-S", "6-S", "7-S", "8-S", "9-S", "10-S", "11-S", "12-S", "13-S", "14-S")
                                              );
    @FXML
    public void shuffleCardButtonPressed(ActionEvent event)
    {
        Collections.shuffle(deck);
        System.out.print("\n\n P1 Deck:");
        
        for (int i = 0; i < deck.size(); i+=2)
        {
            p1_Deck.add(deck.get(i));
        }
        for (int i = 1; i < deck.size(); i+=2)
        {
            p2_Deck.add(deck.get(i));
        }
        System.out.println("P1 DECK: " +p1_Deck);
        System.out.println("\n P2 DECK: " +p2_Deck);
        deckWasShuffled = true;
    }
    
    @FXML
    public void playCardButtonPressed(ActionEvent event)
    {
        if (deckWasShuffled = false)
        {
            gameOutcome.setText("Please make sure you click the 'Start Game' button before playing.");
        }
        if (p1_Deck.size() <= 1)
            {
                System.out.println("Player 2 has won this game! \n");
                gameOutcome.setText("Player 2 has won this game!");
            }
        if (p2_Deck.size() <= 1)
            {
                System.out.println("Player 1 has won this game! \n");
                gameOutcome.setText("Player 1 has won this game!");
            }
        handWinner.setText("");
        String p1Card = "";
        String p2Card = "";
        String tempCard = "";
        int p1CardNumber = 0;
        int p2CardNumber = 0;
        p1Card = p1_Deck.get(p1_Deck.size()-1);
        p2Card = p2_Deck.get(p2_Deck.size()-1);
        String[] p1CardSplitter = p1Card.split("-");
        String[] p2CardSplitter = p2Card.split("-");
        String p1CardNum = p1CardSplitter[0];
        String p1CardSuit = p1CardSplitter[1];
        String p2CardNum = p2CardSplitter[0];
        String p2CardSuit = p2CardSplitter[1];
        p1CardNumber = Integer.parseInt(p1CardNum);
        p2CardNumber = Integer.parseInt(p2CardNum);
        
        switch(p1CardSuit)
        {
            case "H":
                p1TopLeftSuit.setImage(p1H);
                p1MidSuit.setImage(p1H);
                p1BottomRightSuit.setImage(p1H);
                break;
            case "D":
                p1TopLeftSuit.setImage(p1D);
                p1MidSuit.setImage(p1D);
                p1BottomRightSuit.setImage(p1D);
                break;
            case "S":
                p1TopLeftSuit.setImage(p1S);
                p1MidSuit.setImage(p1S);
                p1BottomRightSuit.setImage(p1S);
                break;
            case "C":
                p1TopLeftSuit.setImage(p1C);
                p1MidSuit.setImage(p1C);
                p1BottomRightSuit.setImage(p1C);
                break;
            default:
                p1TopLeftSuit.setImage(null);
                p1MidSuit.setImage(null);
                p1BottomRightSuit.setImage(null);
                break;
        }

        
        switch(p2CardSuit)
        {
            case "H":
                p2TopLeftSuit.setImage(p2H);
                p2MidSuit.setImage(p2H);
                p2BottomRightSuit.setImage(p2H);
                break;
            case "D":
                p2TopLeftSuit.setImage(p2D);
                p2MidSuit.setImage(p2D);
                p2BottomRightSuit.setImage(p2D);
                break;
            case "S":
                p2TopLeftSuit.setImage(p2S);
                p2MidSuit.setImage(p2S);
                p2BottomRightSuit.setImage(p2S);
                break;
            case "C":
                p2TopLeftSuit.setImage(p2C);
                p2MidSuit.setImage(p2C);
                p2BottomRightSuit.setImage(p2C);
                break;
            default:
                p2TopLeftSuit.setImage(null);
                p2MidSuit.setImage(null);
                p2BottomRightSuit.setImage(null);
                break;
        }
        
        switch(p1CardNumber)
        {
            case 11:
                p1NumTopLeft.setText("J");
                p1NumBotRight.setText("J");
                break;
            case 12:
                p1NumTopLeft.setText("Q");
                p1NumBotRight.setText("Q");
                break;
            case 13:
                p1NumTopLeft.setText("K");
                p1NumBotRight.setText("K");
                break;
            case 14:
                p1NumTopLeft.setText("A");
                p1NumBotRight.setText("A");
                break;
            default:
                p1NumTopLeft.setText(p1CardNum);
                p1NumBotRight.setText(p1CardNum);
                
        }
        switch(p2CardNumber)
        {
            case 11:
                p2NumTopLeft.setText("J");
                p2NumBotRight.setText("J");
                break;
            case 12:
                p2NumTopLeft.setText("Q");
                p2NumBotRight.setText("Q");
                break;
            case 13:
                p2NumTopLeft.setText("K");
                p2NumBotRight.setText("K");
                break;
            case 14:
                p2NumTopLeft.setText("A");
                p2NumBotRight.setText("A");
                break;
            default:
                p2NumTopLeft.setText(p2CardNum);
                p2NumBotRight.setText(p2CardNum);
        }
        
        if (p1CardNumber > p2CardNumber)
            {
                p1_Deck.add(0, p2Card);
                temp_Deck.add(0, p1Card);
                p1_Deck.remove(p1_Deck.size()-1);
                tempCard = temp_Deck.get(temp_Deck.size()-1);
                p1_Deck.add(0, tempCard);
                temp_Deck.remove(temp_Deck.size()-1);
                p2_Deck.remove(p2_Deck.size()-1);
                handWinner.setText("PLAYER 1 WON THIS HAND");
                System.out.println("\n P1 Deck Now = " +p1_Deck);
                System.out.println("\n P2 Deck Now = " +p2_Deck);
            }
        else if (p1CardNumber < p2CardNumber)
            {
                p2_Deck.add(0, p1Card);
                temp_Deck.add(0, p2Card);
                p2_Deck.remove(p2_Deck.size()-1);
                tempCard = temp_Deck.get(temp_Deck.size()-1);
                p2_Deck.add(0, tempCard);
                temp_Deck.remove(temp_Deck.size()-1);
                p1_Deck.remove(p1_Deck.size()-1);
                handWinner.setText("PLAYER 2 WON THIS HAND");
                System.out.println("\n P2 Deck Now = " +p2_Deck);
            }
        else
            {
                System.out.println("\n WAR HAS BEEN ACTIVATED");
                String warP1Card = "";
                String warP2Card = "";
                int warP1CardNumber = 0;
                int warP2CardNumber = 0;
                warP1Card = p1_Deck.get(p1_Deck.size()-2);
                warP2Card = p2_Deck.get(p2_Deck.size()-2);
                
                String[] warP1CardSplitter = warP1Card.split("-");
                String[] warP2CardSplitter = warP2Card.split("-");
                
                String warP1CardNum = warP1CardSplitter[0];
                String warP1CardSuit = warP1CardSplitter[1];
                
                String warP2CardNum = warP2CardSplitter[0];
                String warP2CardSuit = warP2CardSplitter[1];
                
                warP1CardNumber = Integer.parseInt(warP1CardNum);
                warP2CardNumber = Integer.parseInt(warP2CardNum);
                if (warP1CardNumber > warP2CardNumber)
                    {
                        p1_Deck.add(0, p2Card);
                        temp_Deck.add(0, warP2Card);
                        p1_Deck.remove(p1_Deck.size()-1);
                        tempCard = temp_Deck.get(temp_Deck.size()-1);
                        p1_Deck.add(0, tempCard);
                        temp_Deck.remove(temp_Deck.size()-1);
                        p2_Deck.remove(p2_Deck.size()-1);
                        handWinner.setText("PLAYER 1 WON THIS HAND");
                        System.out.println("\n P1 Deck Now = " +p1_Deck);
                        System.out.println("\n P2 Deck Now = " +p2_Deck);
                    }
                else if (warP1CardNumber < warP2CardNumber)
                    {
                        p2_Deck.add(0, p1Card);
                        temp_Deck.add(0, warP2Card);
                        p2_Deck.remove(p2_Deck.size()-1);
                        tempCard = temp_Deck.get(temp_Deck.size()-1);
                        p2_Deck.add(0, tempCard);
                        temp_Deck.remove(temp_Deck.size()-1);
                        p1_Deck.remove(p1_Deck.size()-1);
                        handWinner.setText("PLAYER 1 WON THIS HAND");
                        System.out.println("\n P2 Deck Now = " +p2_Deck);
                    }
            }
    }
    
    @FXML
    public void reshuffleAndReplayPressed(ActionEvent event)
    {
        ArrayList<String> deck = new ArrayList<String>();
        String[] deck1 = {"1-D", "2-D", "3-D", "4-D", "5-D", "6-D", "7-D", "8-D", "9-D", "10-D",
            "11-D", "12-D", "13-D", "1-H", "2-H", "3-H", "4-H", "5-H", "6-H",
            "7-H", "8-H", "9-H", "10-H", "11-H", "12-H", "13-H", "1-C", "2-C",
            "3-C", "4-C", "5-C", "6-C", "7-C", "8-C", "9-C", "10-C", "11-C", "12-C",
            "13-C", "1-S", "2-S", "3-S", "4-S", "5-S", "6-S", "7-S", "8-S",
            "9-S", "10-S", "11-S", "12-S", "13-S"};
        ArrayList<String> p1_Deck = new ArrayList<String>(25);
        ArrayList<String> p2_Deck = new ArrayList<String>(25);
        for (int i = 0; i < deck1.length; i++)
        {
            deck.add(deck1[i]);
        }
        
        p1TopLeftSuit.setImage(null);
        p1MidSuit.setImage(null);
        p1BottomRightSuit.setImage(null);
        p2TopLeftSuit.setImage(null);
        p2MidSuit.setImage(null);
        p2BottomRightSuit.setImage(null);
        
        p1NumTopLeft.setText("");
        p1NumBotRight.setText("");
        p2NumTopLeft.setText("");
        p2NumBotRight.setText("");
        gameOutcome.setText("");
        handWinner.setText("");
        deckWasShuffled = false;
    }
}
