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
import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class CS401K142185A1P1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            Game instanceOfGame = Read_Maze("A1-in1.txt");
            PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
            //System.setOut(out);
            for(int i=0;i<instanceOfGame.m;i++){
                    for(int j=0;j<instanceOfGame.n;j++){
                        System.out.print(instanceOfGame.game[i][j]+" ");
                    }
                    System.out.println("");
                }
        }
        catch(Exception e){
            System.out.println("Exception: "+e);
            
        }
    }
/**
 * 
 * @param nameOfFile name of the input file
 * @return object of "Game"
 */      
    public static Game Read_Maze(String nameOfFile){
        File file = new File(nameOfFile);
        try{
            Scanner input = new Scanner(file);
            int m,n,startingX,startingY,goalX,goalY;
            n=input.nextInt();
            m=input.nextInt();
            startingX=input.nextInt();
            startingY=input.nextInt();
            goalX=input.nextInt();
            goalY=input.nextInt();
            Game instanceOfGame = new Game(m,n,startingX,startingY,goalX,goalY);
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    instanceOfGame.game[i][j]=input.nextInt();
                }
            }
            return instanceOfGame;
        }
        catch(Exception e){
            System.out.println("Exception: "+e);
            return null;
        }
    }
    
}
