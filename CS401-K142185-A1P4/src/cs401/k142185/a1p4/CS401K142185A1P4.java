/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs401.k142185.a1p4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author hammad
 */
public class CS401K142185A1P4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Game instanceOfGame = Read_Maze("A1-in1.txt");
            PrintStream out = new PrintStream(new FileOutputStream("A1-out1.txt"));
            System.setOut(out);
            Iterative_DFS(instanceOfGame);
            
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
/**
 * 
 * @param problem object of Game
 * @param parent current node
 * @param action action to be performed
 * @return Node return by applying action from parent node
 */    
    public static Node Child_Node(Game problem,Node parent,String action){ //action={"up","down","right","left","leftup", "leftdown", "rightup", "rightdown"};
        Node child=problem.Result(parent, action);
        child.pathCost=parent.pathCost+Node.stepCost;
        return child;
    }
    
    public static int DFS(Game problem,int limit){
        Node startState=new Node(problem.m,problem.n);
            startState.currentX=problem.startingX;
            startState.currentY=problem.startingY;
            startState.parent=null;
            startState.pathCost=1;
            startState.level=0;
            
            if(problem.Goal_Test(startState)){
                problem.Solution(startState);
                System.out.println(startState.pathCost);
                return 0;
            }
            
            Deque<Node> frontier = new ArrayDeque<Node>();  //Stack
            frontier.addLast(startState);
            Set<Node> explored = new HashSet<Node>();
            while(true){
                if(frontier.isEmpty()){
                    return -1;  //failure
                }
                Node node = frontier.removeLast();
                explored.add(node);
                
                for(String action: problem.actions){
                    Node child = Child_Node(problem,node,action);
                    if(child.validState){
                        if( !(Contain_In_Explored(explored,child) || Contain_In_Frontier(frontier,child)) ){
                            //child.print();
                            if(problem.Goal_Test(child)){
                                problem.Solution(child);
                                System.out.println(child.pathCost);
                                return 0;
                            }
                            if(child.level <= limit){
                                frontier.addLast(child);
                            }
                        }
                    }
                }
                
            }
            
    }
    
    public static void Iterative_DFS(Game problem){
        int limit=0,result;
        for(limit=0; limit<=(problem.m * problem.n); limit++){
            result=DFS(problem,limit);
            if(result == 0)
                break;
            
        }
    }
/**
 * 
 * @param e current Explored Set
 * @param s new node
 * @return true- if new node is already in Set else false
 */    
    public static Boolean Contain_In_Explored(Set<Node> e,Node s){
        for(Node temp: e){
            if(temp.currentX == s.currentX  && temp.currentY == s.currentY){
                return true;
            }
            
        }
        return false;
    }
/**
 * 
 * @param e current Frontier Set
 * @param s new node
 * @return true- if new node is already in Set else false
 */        
    public static Boolean Contain_In_Frontier(Deque<Node> e,Node s){
        for(Node temp: e){
            if(temp.currentX == s.currentX  && temp.currentY == s.currentY){
                return true;
            }
            
        }
        return false;
    }
   }
