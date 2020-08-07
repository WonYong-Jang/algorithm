package com.company.leetcode;

public class leetcode1475 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
import java.util.*;
class Solution {
    public int[] finalPrices(int[] prices) {
        
        int len = prices.length;
        int[] data = new int[len];
        Stack<Node> stack = new Stack<>();
        
        for(int i=0; i< len; i++) {
            int num = prices[i];
            data[i] = num;
            
            while(!stack.isEmpty()) {
                Node cur = stack.peek();
                if(cur.num >= num) {
                    data[cur.index] = cur.num - num;
                    stack.pop();
                }
                else break;
            }
            stack.add(new Node(num,i));
            
        }
        
        return data;
    }
    public class Node {
        
        int num, index;
        Node(int a, int b) {
            num = a; index = b;
        }
    }
} 
 */
