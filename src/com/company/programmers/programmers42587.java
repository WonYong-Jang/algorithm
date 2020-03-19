package com.company.programmers;

public class programmers42587 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        ArrayList<Node> arr = new ArrayList<>();
        Queue<Node> que = new LinkedList<>();
        int len = priorities.length;
        for(int i=0; i< len; i++) {
            que.add(new Node(priorities[i], i));
            arr.add(new Node(priorities[i], i));
        }
        Collections.sort(arr, new mySort());
        
        for(int i= arr.size()-1; i>=0; i--) {
            Node target = arr.get(i);
            
            while(!que.isEmpty()) {
                Node c = que.poll();
                
                if(c.num == target.num) {
                    answer++;
                    if(c.index == location) return answer;
                    break;
                }
                que.add(c);
            }
            
            
        }
        
        return answer;
    }
    static class Node {
        int num, index;
        Node(int a, int b) { 
            num = a;
            index = b;
        }
    }
    static class mySort implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return a.num - b.num;
        }
    }
} 
 */
