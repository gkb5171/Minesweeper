/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplified_minesweeper;

import java.lang.reflect.Array;

/**
 *
 * @author gpbli
 */
public class Difficulty {
    protected int TotalBombs;
    protected int TotalNonBombs;
    protected int TotalTiles;
    
    public Difficulty(int TBombs){
        this.TotalBombs = TBombs;
    }
    
    public int randomNum(){
        return (int)(Math.random())*((1-0)+1);
    }
    
    public int NumOfRows(int[][] arr, int selection, int randomNum){
        //selection is the game mode selected
        //randomNum is what determines the rows
        return arr[selection][randomNum];
    }
    public int NumOfCols(int[][] arr, int selection, int randomNum){
        return arr[selection][randomNum];
    }
}
