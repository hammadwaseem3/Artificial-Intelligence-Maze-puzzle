/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs401.k142185.a1p2;

/**
 *
 * @author hammad
 */
/**
 * 
 * "Game" class is the representation of "Problem"
 * @var m: no. of Rows ,n: no. of Column
 *      (startingX,startingY): is the starting coordinates
 *      (goalX,goalY): is the goal coordinates
 *      game: is the 2d array representation of state
 *      action: is the set of Actions
 */

public class Game {
    public int m,n;
    public int startingX,startingY;
    public int goalX,goalY;
    public int[][] game;
    public String[] actions = {"up","down","right","left","leftup", "leftdown", "rightup", "rightdown"};
    
    public Game(int row,int column,int sX,int sY,int gX,int gY){
        m=row;
        n=column;
        startingX=sX;
        startingY=sY;
        goalX=gX;
        goalY=gY;
        game= new int[m][n];
        
    }
/**
     * 
     * @param parent This is the parent node from where the actions apply
     * @param action Single action
     * @return A node which is the result of an action from parent node
     */    
    public Node Result(Node parent,String action){    //action={"up","down","left","right","leftup", "leftdown", "rightup", "rightdown"};
        Node child=new Node(parent.m,parent.n);
        child.parent=parent;
        child.currentX=parent.currentX;
        child.currentY=parent.currentY;
        switch(action){
            case "up":
                if(child.currentX != 0)
                    child.currentX--;
                else{
                    child.validState=false;
                }
                break;
                
            case "down":
                if(child.currentX < m-1)
                    child.currentX++;
                else{
                    child.validState=false;
                }
                break;
                
            case "left":
                if(child.currentY > 0 )
                    child.currentY--;
                else{
                    child.validState=false;
                }
                break;
                
            case "right":
                if(child.currentY < n-1)
                    child.currentY++;
                else{
                    child.validState=false;
                }
                break;
                
            case "leftup":
                if(child.currentY > 0 && child.currentX != 0){
                    child.currentY--;
                    child.currentX--;
                }
                else{
                    child.validState=false;
                }
                break;
                
            case "leftdown":
                if(child.currentY > 0 && child.currentX < m-1){
                    child.currentY--;
                    child.currentX++;
                }
                else{
                    child.validState=false;
                }
                break;
                
            case "rightup":
                if(child.currentY < n-1 && child.currentX != 0){
                    child.currentX--;
                    child.currentY++;
                }
                else{
                    child.validState=false;
                }
                break;
                
            case "rightdown":
                if(child.currentY < n-1 && child.currentX < m-1){
                    child.currentX++;
                    child.currentY++;
                }
                else{
                    child.validState=false;
                }
                break;
                
                
        }
        if(game[child.currentX][child.currentY] == 1){
            child.validState=false;
        }
        return child;
    }
  /**
     * 
     * @param node A Node which is to be check
     * @return true- if current node is at goal state else false
     */   
    public Boolean Goal_Test(Node node){
        if(node.currentX== goalX && node.currentY== goalY)
            return true;
        else
            return false;
    }
    /**
     * 
     * @param node 
     * @result print from root to the node which is passed as argument
     */
    public void Solution(Node node){
        if(node.parent != null){
             Solution(node.parent);
        }
        System.out.println(node.currentX+" "+node.currentY);
             
    }
}

