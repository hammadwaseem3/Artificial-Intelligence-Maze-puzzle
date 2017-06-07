/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs401.k142185.a1p6;

/**
 *
 * @author k142185
 */
/**
 * 
 * "Node" class is the representation of state + some extra field
 *  @var m: no. of Rows ,n: no. of Column
 *       (currentX,currentY): current position aka state
 *       parent: parent pointer
 *       pathCost: cost from root state to current state
 *       stepCost: cost add by the transition from one state to another
 *       validState: current state is valid or not
 *       
 */
public class Node {
    public int m,n;
    public int currentX,currentY;
    public Node parent;
    int pathCost;
    static int stepCost=1;
    public Boolean validState=true;
    
    public Node(int row,int column){
        m=row;
        n=column;
    }
/**
 * @return print currentX and currentY fields
 */    
    public void print(){
        System.out.println("X: "+currentX+" Y: "+currentY);
    }
/**
 * 
 * @return heuristic value according to current state 
 */     
    public double heuristic(){
        return  Math.sqrt(Math.pow(Game.goalX-currentX , 2) + Math.pow(Game.goalY-currentY, 2));
    }
/**
 * 
 * @return heuristic+actual cost according to current state 
 */     
    public double actualCost(){
        return heuristic()+pathCost;
    }
}