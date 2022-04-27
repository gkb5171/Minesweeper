package simplified_minesweeper;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gpbli
 */
public class mainForm extends JFrame {
    
  JButton easyBtn;
  JButton normalBtn;
  JButton hardBtn;
  JButton exitBtn;
  JButton pExitBtn;
  JButton playAgainBtn;
  
  JLabel titleLbl;
  JLabel subtitleLbl;
  JLabel pTitleLbl;
  JLabel winLoss;
  
  
  JPanel mainMenu;
  JPanel gameboard;
  JPanel postGame;
  
  int totalBombs;       //storest he number of bombs
  int totalTiles;       //stores the total number of tiles
  int totalNonBombs;    //stores the total number of non bombs
  int rows;             //stores the total number of rows
  int cols;             //stores the total number of columns
  int Index;            //Index value used to determine all other values
  
  int selection;        /*   Stores the selected difficulty 
                           1=easy
                           2=normal
                           3=hard*/
  
  Difficulty DIFF;
  
  boolean start = false;
  boolean endGame = false;
  boolean win = false;
  boolean lose = false;
  int counter=0;
  //ArrayList<JButton> tileArray = new ArrayList<>();
  
  
  
  
  
mainForm(){
    initComponents();
}  

//creates non variable dependent components
public void initComponents(){
    setLayout(new FlowLayout());
    
    mainMenu = new JPanel();
    BoxLayout box = new BoxLayout(mainMenu, BoxLayout.Y_AXIS);
    mainMenu.setLayout(box);
    
    //Main Menu components
    titleLbl = new JLabel ("Minesweeper");
    subtitleLbl = new JLabel ("Please select a difficulty");
    
    easyBtn = new JButton("Easy");
    //Action Listener for Easy Button
    easyBtn.addActionListener(ev ->{
        selection = 1;
        start = true;
        mainMenu.setVisible(false);
    });
    
    
    normalBtn = new JButton("Normal");
    //Action LIstener for Normal Button
    normalBtn.addActionListener(ev2 ->{
        selection =2;
        start = true;
        mainMenu.setVisible(false);
    });
    
    hardBtn = new JButton("Hard");
    //Action Listener for Hard Buttons
    hardBtn.addActionListener(ev3 ->{
        selection =3;
        start = true;
        mainMenu.setVisible(false);
    });
    
    exitBtn = new JButton("Exit");
    exitBtn.addActionListener(ev4 ->{
        System.exit(0);
    });
    
    
    mainMenu.add(titleLbl);
    mainMenu.add(subtitleLbl);
    mainMenu.add(easyBtn);
    mainMenu.add(normalBtn);
    mainMenu.add(hardBtn);
    mainMenu.add(exitBtn);
    add(mainMenu);
    
    pack();




}
/*This method will create the game board (variable dependant components)
and display them in a grid*/
public void initGameComponents(int rows, int cols, int totalTiles, int totalBombs, int totalNonBombs){
    BoxLayout PBox = new BoxLayout(postGame, BoxLayout.Y_AXIS);
    postGame = new JPanel(PBox);
    
    //creates the desired grid for the game
    GridLayout grid = new GridLayout(rows,cols);
    Gameboard arrayBackend = new Gameboard();
    gameboard = new JPanel(grid);
    
    //initializing arrays
    JButton[][] tileMatrix = new JButton[rows][cols];
    JButton[] tileArray = new JButton[totalTiles];
    

    //create bomb buttons
    for (int x =0; x<totalBombs; x++){
        JButton newBomb = new JButton("9");
       
        //Bomb button action listener
        newBomb.addActionListener(ev3 ->{
            
            newBomb.setForeground(Color.red);
            newBomb.setBorder(BorderFactory.createLineBorder(Color.black));
            lose = true;
            winLoss = new JLabel("YOU LOSE!");
            postGame.setVisible(true);
            /*
            show end game panel
            */
        });
        newBomb.setBackground(Color.GREEN);
        newBomb.setForeground(newBomb.getBackground());
        newBomb.setBorder(BorderFactory.createBevelBorder(0));
        tileArray[x] =newBomb;
        
        
    }
    
    //create non bomb buttons
    for (int x=0; x<totalNonBombs;x++){
        JButton newTile = new JButton("");
        
        //Tile button action listener
        newTile.addActionListener(ev4 ->{
            newTile.setForeground(Color.black);
            newTile.setBorder(BorderFactory.createLineBorder(Color.black));
            counter++;
            System.out.println(counter);
            newTile.setEnabled(false);
            
            if (counter == totalNonBombs){
                winLoss = new JLabel("YOU WIN!");
                win = true;
                postGame.setVisible(true);
            }
            
        });
        
        newTile.setForeground(newTile.getBackground());
        newTile.setBorder(BorderFactory.createBevelBorder(0));
        tileArray[x+(totalBombs)] = newTile;
    }
    
    
    //Transforming the Array into a matrix
    tileMatrix = arrayBackend.addArrayToMatrix(tileMatrix, tileArray, rows, cols);
    
    //Randomizing the ArrayList
    tileMatrix = arrayBackend.randomizeMatrix(tileMatrix, rows, cols);
    
    //Assigning non bombs a value
    tileMatrix = arrayBackend.NextToBomb(tileMatrix, cols, rows);

    //add buttons to gameboard Panel
    for (int x=0; x<rows;x++){
        for(int y=0;y<cols;y++){
        gameboard.add(tileMatrix[x][y]);
        
        }
    }
    
    
    add(gameboard);
    gameboard.setVisible(true);
    pack();
    revalidate();
    
    
    
}

public void initPostGameComponents(){
    
    
    pTitleLbl = new JLabel("MINESWEEPER");
    winLoss = new JLabel("");
    
    if (win == true){winLoss.setText("YOU WON!");}
    if (lose == true){winLoss.setText("YOU LOSE!");}
    
    playAgainBtn = new JButton("Play Again");
    //playAgainBtn Action Listenr
    playAgainBtn.addActionListener(ev ->{
        //play again code goes here
    });
    
    
    pExitBtn = new JButton("Exit");
    //exit button Action Listener
    pExitBtn.addActionListener(ev ->{
    System.exit(0);
    });
    

}

public static void main(String[] args){
    mainForm main = new mainForm();
    Simplified_Minesweeper backend = new Simplified_Minesweeper();
    main.setVisible(true);
    
    //Filling the arrays with values
    backend.RowArray = backend.setRowArray(backend.RowArray);
    backend.DiffArray = backend.setDiffArray(backend.DiffArray);
    backend.ColArray = backend.setColArray(backend.ColArray);
    
    //Storing the correct values to variables
    
    /*
    Becasue the gameboard is dependent on an input I use
    a boolean statement to determine when to start the game
    the while loop is to stop the code from reading the if statement before 
    an option is selected
    */
    while (main.start == false){
        System.out.println("i tricked you stupid computer");
    }
    
    if (main.start == true){
        main.DIFF = backend.setDiff(backend.DiffArray, main.selection);
        main.Index = backend.getIndex(main.DIFF);
        main.totalBombs = backend.getTotalBombs(main.DIFF);
        main.rows = backend.getRows(main.DIFF, backend.RowArray, main.selection, main.Index);
        main.cols = backend.getCols(main.DIFF, backend.ColArray, main.selection,main.Index);
        main.totalTiles = backend.getTotalTiles(main.rows,main.cols);
        main.totalNonBombs = backend.getTotalNonBombs(main.totalTiles, main.totalBombs);
        main.initGameComponents(main.rows,main.cols,main.totalTiles,main.totalBombs,main.totalNonBombs);
    }
    
    while (main.endGame == false){
        
    }
    if (main.endGame == true){
    
    
    }
}
}
