package com.company.programmers;
/**
 * 다리를 지나는 트럭 
 */
public class pro42583 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
 import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        
        int len = truck_weights.length, curWeight = 0;
        Queue<Node> que = new LinkedList<>();
        for(int i=0; i< len; i++) que.add(new Node(truck_weights[i], 0));
        
        while(!que.isEmpty()) {
            
            int size = que.size();
            time++;
            int flag = 0;
            for(int i=0; i< size; i++) {
                
                Node n = que.poll();
                
                if(flag == 1 && n.location == 0) {
                    que.add(n);
                    continue;
                }
                
                if(n.location > 0) {
                    if(n.location + 1 > bridge_length) {
                        curWeight -= n.weight;
                    }
                    else que.add(new Node(n.weight, n.location+1));
                }
                else if(n.location == 0) {
                    if(curWeight + n.weight <= weight) {
                        curWeight += n.weight;
                        que.add(new Node(n.weight, n.location+1));
                    }
                    else que.add(new Node(n.weight, n.location));
                    flag = 1;
                }
            }
        }
        
        return time;
    }
    class Node {
        int weight, location;
        Node(int a, int b) {
            weight = a; location = b;
        }
    }
}
 */
