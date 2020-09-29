package com.company.programmers;

public class pro42883 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        StringBuilder sb = new StringBuilder();
        
        int len = number.length();
        int n = len - k;
        
        PriorityQueue<Node> que = new PriorityQueue<>(new mySort());
        
        for(int i=0; i< k; i++) {
            int num = number.charAt(i) - '0';
            que.add(new Node(i, num));
        }
        
        int start = -1, end = k;
        for(int i=k ; i< len; i++) {
            int num = number.charAt(i) - '0';
            
            que.add(new Node(i, num));
            end = i;
            while(!que.isEmpty()) {
                Node cur = que.poll();
                num = cur.num;
                int index = cur.index;
                if(start < index && index <= end) {
                    start = index;
                    sb.append(num);
                    break;
                }
            }
            
        }
        
        while(sb.length() > 1) {
            if(sb.toString().startsWith("0")) {
                sb.deleteCharAt(0);
            }
            else break;
        }
        
        return sb.toString();
    }
    public class Node {
        int index, num;
        Node(int a, int b) {
            index = a; num = b;
        }
    }
    public class mySort implements Comparator<Node> {
        public int compare(Node a, Node b) {
            if(a.num == b.num) return a.index - b.index;
            else return b.num - a.num;
        }
    }
} 
 */
