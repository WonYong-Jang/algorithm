package com.company.programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * k번째 수 
 */
public class pro15 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}

class Solution15 {
    public Node[] node;
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        int len = array.length;
        node = new Node[len+1];
        for(int i=0; i< len; i++)
        {
            node[i] = new Node(array[i], i+1);
        }
        Arrays.sort(node, 0, len+1, new mySort());
        
        int size = commands.length;
        int a = 0, b = 0, c = 0;
        for(int i=0; i< size; i++)
        {
            a = commands[i][0];
            b = commands[i][1];
            c = commands[i][2];
        }
        
        return answer;
    }
    public class mySort implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            if(a.num < b.num) return -1;
            else if(a.num > b.num) return 1;
            return 0;
        }
    }
    public class Node {
        int num, idx;
        Node(int a, int b) {
            num=a; idx=b;
        }
    }
}