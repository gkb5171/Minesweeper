/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplified_minesweeper;

import javax.swing.JButton;

/**
 *
 * @author gpbli
 */
public class Gameboard extends Simplified_Minesweeper{
    
    
    public JButton[][] addArrayToMatrix(JButton[][] mat, JButton[] arr,int Rows, int Cols){
        int h =0;
        for(int x= 0; x<Rows; x++){
            for(int y = 0; y<Cols; y++){
                mat[x][y]=arr[h];
                h++;
            }
        }
        return mat;
    }
    
    public JButton[][] randomizeMatrix(JButton[][] mat,int Rows, int Cols){
        JButton temp1;
        JButton temp2;
        for (int x=0; x<Rows;x++){
            for (int y=0; y<Cols; y++){
                int xGen = (int) (Math.random()*(Rows));
                int yGen = (int) (Math.random()*(Cols));
                temp1 = mat[xGen][yGen];
                temp2 = mat[x][y];
                mat[x][y] = temp1;
                mat[xGen][yGen] = temp2;
        }
    }
        return mat;
    }
    
    public void printMatrix(TileObject[][] mat,int Rows, int Cols){
        String PMat="";
        for (int x=0;x<Rows;x++){
            for (int y=0;y<Cols;y++){
                PMat += mat[x][y].toString() + (y == (Cols-1) ? "\n" : "");
            }
        }
        System.out.println(PMat);
    }
    
    
    
    public JButton[][] NextToBomb(JButton[][] TileMatrix, int cols,int rows){
        
        //int cols =TileMatrix[0].length;
        System.out.println("\nRow Index: "+rows);
        System.out.println("Column Index: "+cols+"\n");
        int tempValue;
        for(int x=0; x<=(rows-1); x++){
            tempValue =0;
            for(int y=0; y<=(cols-1); y++){
                tempValue=0;
                JButton cTile = TileMatrix[x][y];
                //System.out.println("Checking: " + cTile);
                if (cTile.getText() == "9"){
                    continue;
                }
                
                //this tests the top left corner
                else if (x==0 && y==0){
                   if (TileMatrix[x+1][y+1].getText() == "9"){tempValue++;}
                   if (TileMatrix[x][y+1].getText() == "9"){tempValue++;}
                   if (TileMatrix[x+1][y].getText() == "9"){tempValue++;}
                        TileMatrix[x][y].setText(String.valueOf(tempValue)); // = cTile.value;
                    continue;
               }
                
                //this tests the first row of tiles except corners
                //try{
                     if (x==0 && y!=0 && y!=(cols-1)){
                    if (TileMatrix[x][y-1].getText() == "9"){tempValue++;} 
                    if (TileMatrix[x][y+1].getText() == "9"){tempValue++;}
                    if (TileMatrix[x+1][y-1].getText() == "9"){tempValue++;}
                    if (TileMatrix[x+1][y].getText() == "9"){tempValue++;} 
                    if (TileMatrix[x+1][y+1].getText() == "9"){tempValue++;}
                    
                    TileMatrix[x][y].setText(String.valueOf(tempValue));
                    continue;
                }
                /*catch(ArrayIndexOutOfBoundsException e){
                    System.out.println(TileMatrix[x][y].value);
                }
                    /*continue;    
                    }else{
                        continue;
                    }*/
                
                //this tests the top right corner
                if (x==0 && y==(cols-1)){
                   if (TileMatrix[x][y-1].getText() == "9"){tempValue++;}
                   if (TileMatrix[x+1][y].getText() == "9"){tempValue++;}
                   if (TileMatrix[x+1][y-1].getText() == "9"){tempValue++;}
                       TileMatrix[x][y].setText(String.valueOf(tempValue));
                    continue;
               }
                
                
                //this tests the first collumn of tiles except corners
                else if (y == 0 && x!=0 && x!=(rows-1)){
                   if (TileMatrix[x-1][y].getText() == "9"){tempValue++;}
                   if (TileMatrix[x+1][y].getText() == "9"){tempValue++;}
                   if (TileMatrix[x][y+1].getText() == "9"){tempValue++;}
                   if (TileMatrix[x-1][y+1].getText() == "9"){tempValue++;}
                   if (TileMatrix[x+1][y+1].getText() == "9"){tempValue++;}
                        
                   TileMatrix[x][y].setText(String.valueOf(tempValue));
                    continue;
                }
               
                //this tests the bottome left corner
                else if (x == (rows-1) && y==0){
                   if (TileMatrix[x-1][y].getText() == "9"){tempValue++;}
                   if (TileMatrix[x][y+1].getText() == "9"){tempValue++;}
                   if (TileMatrix[x-1][y+1].getText() == "9"){tempValue++;}
                       TileMatrix[x][y].setText(String.valueOf(tempValue));
                    continue;
               }
                
                //this tests the last row of tiles except corners 
                else if (x == (rows-1) && y!=0 && y!=(cols-1)){
                    if(TileMatrix[x][y-1].getText() == "9"){tempValue++;}
                    if(TileMatrix[x][y+1].getText() == "9"){tempValue++;}
                    if(TileMatrix[x-1][y].getText() == "9"){tempValue++;}
                    if (TileMatrix[x-1][y-1].getText() == "9"){tempValue++;}
                    if (TileMatrix[x-1][y+1].getText() == "9"){tempValue++;}
                    TileMatrix[x][y].setText(String.valueOf(tempValue));
                    continue;
                    }
                
                //this tests the bottom right corner
                else if (x==(rows-1) && y==(cols-1)){
                   if (TileMatrix[x-1][y-1].getText() == "9"){tempValue++;}
                   if (TileMatrix[x][y-1].getText() == "9"){tempValue++;}
                   if (TileMatrix[x-1][y].getText() == "9"){tempValue++;}
                        TileMatrix[x][y].setText(String.valueOf(tempValue));
                    continue;
               }
               
                
               //this tests the last collumn of tiles except corners
                else if (y == (cols-1) && x!=0 && x!=(rows-1)){
                   if (TileMatrix[x-1][y].getText() == "9"){tempValue++;} 
                   if (TileMatrix[x+1][y].getText() == "9"){tempValue++;}
                   if (TileMatrix[x][y-1].getText() == "9"){tempValue++;}
                   if (TileMatrix[x-1][y-1].getText() == "9"){tempValue++;}
                   if (TileMatrix[x+1][y-1].getText() == "9"){tempValue++;}
                        TileMatrix[x][y].setText(String.valueOf(tempValue));
                        continue;
                }
                
                //This if statement test values on the inner area of the grid
                else if (x!=0 && x!=(rows-1) && y!=0 && y!=(cols-1)){ 
                            if (TileMatrix[x][y+1].getText() == "9"){tempValue++;}
                            if (TileMatrix[x][y-1].getText() == "9"){tempValue++;} 
                            if (TileMatrix[x+1][y].getText() == "9"){tempValue++;}
                            if (TileMatrix[x-1][y].getText() == "9"){tempValue++;}
                            if (TileMatrix[x+1][y+1].getText() == "9"){tempValue++;}
                            if (TileMatrix[x-1][y-1].getText() == "9"){tempValue++;}
                            if (TileMatrix[x-1][y+1].getText() == "9"){tempValue++;}
                            if (TileMatrix[x+1][y-1].getText() == "9"){tempValue++;}
                    {
                        //System.out.println(cTile.value + "\nX : "+x+"\nY: "+y);
                        TileMatrix[x][y].setText(String.valueOf(tempValue));
                        continue;
                    }
                }
                //System.out.println(TileMatrix[x][y].value);
            }
        }
        return TileMatrix;
    }
    




}
