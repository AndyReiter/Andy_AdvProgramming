import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class ToHController
{
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Pane pane;
    @FXML
    private Rectangle disk0;
    @FXML
    private Rectangle disk1;
    @FXML
    private Rectangle disk2;
    @FXML
    private Rectangle disk3;
    @FXML
    private Rectangle disk4;
    @FXML
    private Rectangle disk5;
    @FXML
    private Rectangle disk6;
    @FXML
    private Rectangle disk7;
    @FXML
    private Rectangle disk8;
    @FXML
    private Rectangle disk9;
    @FXML
    private Button playButton;
    @FXML
    private Button restartButton;
    @FXML
    private TextField numOfDisks;
    
    int defaultLoc = 300;
    int positionOfBottomDisk = 300;
    int defPeg1 = defaultLoc;
    int defPeg2 = defaultLoc;
    int defPeg3 = 300;
    int numberOfDisks = 0;
    double quickness = .4;
    int value = 0;
    Rectangle topDisk; // creates an object to store what the current top Disk is.
    pegClass peg1 = new pegClass(1); // create peg object
    pegClass peg2 = new pegClass(2); // create peg object
    pegClass peg3 = new pegClass(3); // create peg object
    List<Double> listOfX = new ArrayList<>();
    LinkedList<Rectangle> disks = new LinkedList<>(); // creates a linked list of Rectangle Objects
    
    SequentialTransition sequentialTransition = new SequentialTransition();
    /**********************************************************************
     *                                                                    *
     *              FXML Functions for handling buttons pressed           *
     *                                                                    *
     **********************************************************************/
    @FXML
    void startGame(ActionEvent event)
    {
        sequentialTransition.getChildren().clear();
        numberOfDisks = Integer.valueOf(numOfDisks.getText());
        int checker = 0;
        while (checker < numberOfDisks)
        {
            defPeg1 = defPeg1-10;
            checker++;
        }
        locationOfXCoordinate(numberOfDisks);
        locationOfYCoordinate(numberOfDisks);
        makeDisksAppear(numberOfDisks);
        disksBeingUsed(numberOfDisks);
        
        solveTheTower(numberOfDisks, peg1, peg2, peg3);
        sequentialTransition.play();
    }
    @FXML
    void restartGame(ActionEvent event)
    {
        numOfDisks.setText("");
        numOfDisks.setPromptText("# of rings");
        numberOfDisks = 0;
        disk0.setVisible(false);
        disk1.setVisible(false);
        disk2.setVisible(false);
        disk3.setVisible(false);
        disk4.setVisible(false);
        disk5.setVisible(false);
        disk6.setVisible(false);
        disk7.setVisible(false);
        disk8.setVisible(false);
        disk9.setVisible(false);
        peg1.disks.clear();
        peg2.disks.clear();
        peg3.disks.clear();
        locationOfYCoordinate(0);
        locationOfXCoordinate(0);
        listOfX.clear();
        sequentialTransition.getChildren().clear();
    }
    @FXML
    void initialize()
    {
        
    }
    
    /****************************************************************
     *                                                              *
     *                    PUBLIC VOID FUNCTIONS                     *
     *                                                              *
     ****************************************************************/
    
    void disksBeingUsed(int numDisks)
    {
        peg1.addToStack(disk9); // always places disk 9 since its the largest and default bottom disk
        
        if (numDisks==1)
        {
            return;
        }
        peg1.addToStack(disk8);
        
        if (numDisks==2)
        {
            return;
            
        }
        peg1.addToStack(disk7);
        
        if (numDisks==3)
        {
            return;
            
        }
        peg1.addToStack(disk6);
        
        if (numDisks==4)
        {
            return;
            
        }
        peg1.addToStack(disk5);
        
        if (numDisks==5)
        {
            return;
            
        }
        peg1.addToStack(disk4);
        
        if (numDisks==6)
        {
            return;
            
        }
        peg1.addToStack(disk3);
        
        if (numDisks==7)
        {
            return;
            
        }
        peg1.addToStack(disk2);
        
        if (numDisks==8)
        {
            return;
            
        }
        peg1.addToStack(disk1);
        
        if (numDisks==9)
        {
            return;
        }
        peg1.addToStack(disk0);
        
        if(numDisks==10){return;}
    }
    
    void makeDisksAppear(int numDisks)
    {
        disk9.setVisible(true); // always displays this disk
        
        if(numDisks==1)
        {
            return;
        }
        else
        {
        disk8.setVisible(true);
        }
        if(numDisks==2)
        {
            return;
        }
        else
        {
            disk7.setVisible(true);
        }
        if(numDisks==3)
        {
            return;
        }
        else
        {
            disk6.setVisible(true);
        }
        if(numDisks==4)
        {
            return;
        }
        else
        {
            disk5.setVisible(true);
        }
        if(numDisks==5)
        {
            return;
        }
        else
        {
            disk4.setVisible(true);
        }
        if(numDisks==6)
        {
            return;
        }
        else
        {
            disk3.setVisible(true);
        }
        if(numDisks==7)
        {
            return;
        }
        else
        {
            disk2.setVisible(true);
        }
        if(numDisks==8)
        {
            return;
        }
        else
        {
            disk1.setVisible(true);
        }
        if(numDisks==9)
        {
            return;
        }
        else
        {
            disk0.setVisible(true);
        }
        return;
    }
    void locationOfXCoordinate(int numDisks)
    {
        disk0.setLayoutX(120);
        disk1.setLayoutX(115);
        disk2.setLayoutX(110);
        disk3.setLayoutX(105);
        disk4.setLayoutX(100);
        disk5.setLayoutX(95);
        disk6.setLayoutX(90);
        disk7.setLayoutX(85);
        disk8.setLayoutX(80);
        disk9.setLayoutX(75);
        listOfX.addAll(Arrays.asList(120.0, 115.0, 110.0, 105.0, 100.0, 95.0, 90.0, 85.0, 80.0, 75.0));
    }
    void locationOfYCoordinate(int numDisks)
    {
        disk9.setLayoutY(defaultLoc); // always set this
        
        if (numDisks == 1)
        {
            return;
        }
        else
        {
            disk8.setLayoutY(defaultLoc - 10);
        }
        if (numDisks == 2)
        {
            return;
        }
        else
        {
            disk7.setLayoutY(defaultLoc - 20);
        }
        if (numDisks == 3)
        {
            return;
        }
        else
        {
            disk6.setLayoutY(defaultLoc - 30);
        }
        if (numDisks == 4)
        {
            return;
        }
        else
        {
            disk5.setLayoutY(defaultLoc - 40);
        }
        if (numDisks == 5)
        {
            return;
        }
        else
        {
            disk4.setLayoutY(defaultLoc - 50);
        }
        if (numDisks == 6)
        {
            return;
        }
        else
        {
            disk3.setLayoutY(defaultLoc - 60);
        }
        if (numDisks == 7)
        {
            return;
        }
        else
        {
            disk2.setLayoutY(defaultLoc - 70);
        }
        if (numDisks == 8)
        {
            return;
        }
        else
        {
            disk1.setLayoutY(defaultLoc - 80);
        }
        if (numDisks == 9)
        {
            return;
        }
        else
        {
            disk0.setLayoutY(defaultLoc - 90);
        }
        return;
    }
    void animationFunction(Rectangle disk, int LOrR, double height)
    {
        Timeline timeline = new Timeline();
        String movingDisk = disk.getId();
        String converter = movingDisk.replaceAll("[^0-9]","");
        int index = Integer.parseInt(converter);
        double temporary1 = listOfX.get(index)+196;
        double temporary2 = listOfX.get(index)+392;
        double temporary3 = listOfX.get(index)-196;
        double temporary4 = listOfX.get(index)-392;
        if (LOrR == 0)
        {
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(.30*quickness), new KeyValue(disk.layoutYProperty(), 75)));
        }
        if (LOrR == 1)
        {
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(.30*quickness), new KeyValue(disk.layoutXProperty(), temporary1)));
            listOfX.set(index, temporary1);
        }
        if (LOrR == 11)
        {
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(.30*quickness), new KeyValue(disk.layoutXProperty(), temporary2)));
            listOfX.set(index, temporary2);
        }
        if (LOrR == 2)
        {
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(.30*quickness), new KeyValue(disk.layoutYProperty(), height)));
        }
        if (LOrR == 3)
        {
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(.30*quickness), new KeyValue(disk.layoutXProperty(), temporary3)));
            listOfX.set(index, temporary3);
        }
        if (LOrR == 33)
        {
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(.30*quickness), new KeyValue(disk.layoutXProperty(), temporary4)));
            listOfX.set(index, temporary4);
        }
        sequentialTransition.getChildren().add(timeline);
    }

    void changeLocation(pegClass initialPeg, pegClass finalPeg)
    {
        double height = 0.0;
        Rectangle disk = initialPeg.getTopDisk();
        int temp1 = finalPeg.value;
        int temp2 = initialPeg.value;
        int whereToGo = finalPeg.value-initialPeg.value;
        if (temp1 == 1)
        {
            height = defPeg1;
            defPeg1 = defPeg1 - 10;
        }
        if (temp1 == 2)
        {
            height = defPeg2;
            defPeg2 = defPeg2 - 10;
        }
        if (temp1 == 3)
        {
            height = defPeg3;
            defPeg3 = defPeg3 - 10;
        }
        
        if (temp2 == 1)
        {
            defPeg1 = defPeg1 + 10;
        }
        if (temp2 == 2)
        {
            defPeg2 = defPeg2 + 10;
        }
        if (temp2 == 3)
        {
            defPeg3 = defPeg3 + 10;
        }
        
        if (whereToGo == -1)
        {
            animationFunction(disk, 0, height);
            animationFunction(disk, 3, height);
            animationFunction(disk, 2, height);
        }
        if (whereToGo == 1)
        {
            animationFunction(disk, 0, height);
            animationFunction(disk, 1, height);
            animationFunction(disk, 2, height);
        }
        if (whereToGo == 2)
        {
            animationFunction(disk, 0, height);
            animationFunction(disk, 11, height);
            animationFunction(disk, 2, height);
        }
        if (whereToGo == -2)
        {
            animationFunction(disk, 0, height);
            animationFunction(disk, 33, height);
            animationFunction(disk, 2, height);
        }
        
        initialPeg.removeFromStack(); // removes the disk that was previously on the stack
        finalPeg.addToStack(disk); // adds the disk to the new stack that it is on
    }
    /**************************************************************
     *                                                            *
     *                METHODS FOR PEG LINKED LIST                 *
     *                                                            *
     **************************************************************/
    
    void pegClass(int n)
    {
        value = n; // sets the value equal to the number of disks
    }
    void addToStack(Rectangle r)
    {
        this.disks.push(r); // pused the rectangle object onto the stack in order to store it properly
    }
    Rectangle getTopDisk()
    {
        topDisk = this.disks.peek();
        return topDisk;
        //returns the disk that at the top of the stack, it is seen throught he function peek
    }
    void removeFromStack()
    {
        this.disks.pop();
        //returns the disk that was popped out of the stack;
    }
    // THIS SOLVE THE TOWER ALGORITHM WAS DERIVED FROM THE SOLUTION TO THE TOWERS OF HANOI AS GATHERED FROM
    // STACK OVERFLOW https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/
    
    void solveTheTower(int numDisks, pegClass startingPeg, pegClass auxillaryPeg, pegClass terminalPeg)
    {
        if (numDisks == 1)
        {
            changeLocation(startingPeg, terminalPeg);
        }
        else
        {
            solveTheTower(numDisks - 1, startingPeg, terminalPeg, auxillaryPeg);
            changeLocation(startingPeg, terminalPeg);
            solveTheTower(numDisks - 1, auxillaryPeg, startingPeg, terminalPeg);
        }
    }
}
