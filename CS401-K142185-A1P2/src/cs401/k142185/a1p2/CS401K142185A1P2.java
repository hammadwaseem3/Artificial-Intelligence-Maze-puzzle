/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs401.k142185.a1p2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

/**
 *
 * @author hammad
 */
public class CS401K142185A1P2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Game instanceOfGame = Read_Maze("A1-in1.txt");
            PrintStream out = new PrintStream(new FileOutputStream("A1-out1.txt"));
            System.setOut(out);
            BFS(instanceOfGame);
            
        }
        catch(Exception e){
           e.printStackTrace();
            
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
    
    public static Node Child_Node(Game problem,Node parent,String action){ //action={"up","down","right","left","leftup", "leftdown", "rightup", "rightdown"};
        Node child=problem.Result(parent, action);
        child.pathCost=parent.pathCost+Node.stepCost;
        return child;
    }
    
    public static void BFS(Game problem){
            Node startState=new Node(problem.m,problem.n);
            startState.currentX=problem.startingX;
            startState.currentY=problem.startingY;
            startState.parent=null;
            startState.pathCost=1;
            
            if(problem.Goal_Test(startState)){
                problem.Solution(startState);
                System.out.println(startState.pathCost);
                return;
            }
             
            Queue<Node> frontier = new LinkedList<Node>();
            frontier.add(startState);
            Set<Node> explored = new HashSet<Node>();
            
            while(true){
                if(frontier.isEmpty()){
                    return;  //failure
                }
                Node node = frontier.remove();
                explored.add(node);
                
                for(String action: problem.actions){
                    Node child = Child_Node(problem,node,action);
                    if(child.validState){
                        
                        if( !(ContainInExplored(explored,child) || ContainInFrontier(frontier,child)) ){
                            if(problem.Goal_Test(child)){
                                problem.Solution(child);
                                System.out.println(child.pathCost);
                                return;
                            }
                            frontier.add(child);
                        }
                    }
                }
                
            }
            
    }
    
    public static Boolean ContainInExplored(Set<Node> e,Node s){
        for(Node temp: e){
            if(temp.currentX == s.currentX  && temp.currentY == s.currentY){
                return true;
            }
            
        }
        return false;
    }
    
    public static Boolean ContainInFrontier(Queue<Node> e,Node s){
        for(Node temp: e){
            if(temp.currentX == s.currentX  && temp.currentY == s.currentY){
                return true;
            }
            
        }
        return false;
    }
}
