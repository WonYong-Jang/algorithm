package com.company.programmers;

import java.util.Stack;

public class pro42588 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stack<Integer> st = new Stack<>();
        
    }
    
}
/**
import java.util.*;

class Solution {
    public int[] solution(int[] heights) {
        int len = heights.length;
        int[] answer = new int[len];
        
        Stack<Node> stack = new Stack<>();
        for(int i=1; i<= len; i++) {
            Node n = new Node(heights[i-1], i);
            int target = heights[i-1];
            
            if(stack.isEmpty()) stack.add(n);
            else {
                
                while(!stack.isEmpty()) {
                    Node cur = stack.peek();
                    if(cur.num > target) {
                        answer[i-1] = cur.index;
                        break;
                    }
                    stack.pop();
                }
                stack.add(n);
            }
            
        }
        
        return answer;
    }
    class Node {
        int num, index;
        Node(int a, int b) {
            num = a; index = b;
        }
    }
}
 */
