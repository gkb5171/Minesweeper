    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplified_minesweeper;

import java.util.Scanner;

/**
 *
 * @author gpbli
 */
public class Simplified_Minesweeper {
      
    //mainMenu mainMenu = new mainMenu();
        
        //Simplified_Minesweeper me = new Simplified_Minesweeper();
        
        TileObject TILE = new TileObject();
        Scanner input = new Scanner(System.in);
        public int[][] RowArray = new int[4][2]; 
        public int[][] ColArray = new int[4][2];
        public int[][] DiffArray = new int[4][1];
        
        public int[][] setDiffArray(int[][] DiffArray){
        DiffArray[0][0] = 10;
        DiffArray[1][0] = 40;
        DiffArray[2][0] = 99;
        DiffArray[3][0] = 600;
        return DiffArray;
        }
        
        public int[][] setRowArray(int[][] RowArray){
        RowArray[0][0] = 9;
        RowArray[0][1] = 10;
        RowArray[1][0] = 13;
        RowArray[1][1] = 16;
        RowArray[2][0] = 16;
        RowArray[2][1] = 30;
        RowArray[3][0] = 50;
        RowArray[3][1] = 50;
        return RowArray;
        }
        
        public int[][] setColArray(int[][] ColArray){
        ColArray[0][0] = 9;
        ColArray[0][1] = 10;
        ColArray[1][0] = 15;
        ColArray[1][1] = 16;
        ColArray[2][0] = 30;
        ColArray[2][1] = 16;
        ColArray[3][0] = 50;
        ColArray[3][1] = 50;
        return ColArray;}
        
        
        
        
        //Gameboard GAMEBOARD = new Gameboard();
        



// TODO code application logic here
        
        
        //Print the options here
        /*System.out.println("\tMinesweeper");
        System.out.println("\n\t 1.) Easy");
        System.out.println("\n\t 2.) Normal");
        System.out.println("\n\t 3.) Hard");
        System.out.println("\nPlease choose a difficulty:\n");     
        
        
        me.selection = input.nextInt()-1;
        */
        //Assign the rows, cols, tiles, and total tiles
        //public void getVars(int selection, int[] row, int[] col, int[] diff){
            
        //int Index = DIFF.randomNum();
        //int TotalBombs = DIFF.TotalBombs;
        //int Rows = DIFF.NumOfRows(row,selection, Index);
        //int Cols = DIFF.NumOfCols(col,selection, Index);
        //int TotalTiles = Rows*Cols;
        //int TotalNonBombs = TotalTiles - TotalBombs;
        
        
        public int getTotalNonBombs(int totalTiles, int totalBombs){
            return totalTiles-totalBombs;
        }
        
        public int getTotalTiles(int Rows, int Cols){
            return Rows*Cols;
        }
        
        public int getCols(Difficulty DIFF, int[][] col, int selection, int Index){
            return DIFF.NumOfCols(col, selection, Index);
        }
        
        public int getRows(Difficulty DIFF, int[][]row,int selection, int Index){
            return DIFF.NumOfRows(row, selection, Index);
        }
        
        public int getTotalBombs(Difficulty DIFF){
            return DIFF.TotalBombs;
        }
        public int getIndex(Difficulty DIFF){
            return DIFF.randomNum();
        }
        public Difficulty setDiff(int[][] diff, int selection){
            Difficulty DIFF = new Difficulty(diff[selection][0]);
            return DIFF;
        }
        
        //create array
        public TileObject[] createArray(TileObject[] TileArray,int totalTiles){
        
        for (int t =0;t<totalTiles;t++){
            TileArray[t] = new TileObject();
        }
        return TileArray;
        }
        
        //create bombs
        public TileObject[] createBombs(TileObject[] TileArray,int TotalBombs){ 
        return TILE.createBombs(TileArray,TotalBombs);
        }      

        //create matrix
       /* TileObject[][] TileMatrix = new TileObject[Rows][Cols];
        
        //add tiles to matrix
        TileMatrix = GAMEBOARD.addArrayToMatrix(TileMatrix, TileArray, Rows, Cols);
        
        //randomize matrix
        TileMatrix = GAMEBOARD.randomizeMatrix(TileMatrix,Rows, Cols);
        
        //assign values to tiles in matrix
        TileMatrix = GAMEBOARD.NextToBomb(TileMatrix, Cols, Rows);
        
        //print matrix
        //GAMEBOARD.printMatrix(TileMatrix,Rows, Cols);*/
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    //public static void main(String[] args) {
        
    

