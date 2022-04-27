/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplified_minesweeper;

/**
 *
 * @author gpbli
 */
public class TileObject {
    protected int value;
    protected boolean bomb;
    
    
    public TileObject(){
        this.value =0;
        this.bomb = false;
    }
    
    public TileObject[] createBombs(TileObject[] arr,int TotalBombs){
        for(int h=0; h<TotalBombs; h++){
            arr[h].bomb = true;
            arr[h].value = 9;
            
        }
        return arr;
    }
    
    @Override
    public String toString(){
        return "["+this.value+"]";
    }
    
}

