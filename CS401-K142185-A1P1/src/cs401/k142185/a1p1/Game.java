/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs401.k142185.a1p1;

/**
 *
 * @author k142185
 */
/**
 * 
 * "Game" class is the representation of "Problem"
 * @var m: no. of Rows ,n: no. of Column
 *      (startingX,startingY): is the starting coordinates
 *      (goalX,goalY): is the goal coordinates
 *      game: is the 2d array representation of state
 *      
 */

public class Game {
    public int m,n;
    public int startingX,startingY;
    public int goalX,goalY;
    public int[][] game;
    
    public Game(int row,int column,int sX,int sY,int gX,int gY){
        m=row;
        n=column;
        startingX=sX;
        startingY=sY;
        goalX=gX;
        goalY=gY;
        game= new int[m][n];
    }
}
