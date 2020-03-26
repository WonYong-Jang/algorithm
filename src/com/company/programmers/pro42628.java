package com.company.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class pro42628 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "abc";
        str.startsWith("a");
        PriorityQueue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());
        
    }
    
}
/**
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int len = operations.length;
        PriorityQueue<Integer> maxQue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQue = new PriorityQueue<>();
        for(int i=0; i< len; i++) {
            if(operations[i].startsWith("I")) {
                
                String target = operations[i].substring(2, operations[i].length());
                int num = Integer.parseInt(target);
                maxQue.add(num);
                minQue.add(num);
            }
            else if(operations[i].startsWith("D 1")) {
                if(!maxQue.isEmpty()) {
                    int num = maxQue.peek();
                    maxQue.remove(num);
                    minQue.remove(num);
                }
            }
            else {
                if(!minQue.isEmpty()) {
                    int num = minQue.peek();
                    maxQue.remove(num);
                    minQue.remove(num);
                }
            }
        }
        
        
        
        if(!minQue.isEmpty() && !maxQue.isEmpty()) {
            answer[1] = minQue.peek();
            answer[0] = maxQue.peek();
        }
        
        return answer;
    }
} 
 */
