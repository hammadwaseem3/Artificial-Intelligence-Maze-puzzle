/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs401.k142185.a1p5;

/**
 *
 * @author k142185
 */

import java.util.Comparator;


public class MyComparator implements Comparator<Node> {
    @Override
    public int compare(Node x, Node y)
    {
        if (x.heuristic() < y.heuristic())
        {
            return -1;
        }
        if (x.heuristic() > y.heuristic())
        {
            return 1;
        }
        return 0;
    }
}
