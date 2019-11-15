package com.company.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * K Closest Points To Origin
 */
public class leetcode973 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
       
    }
}

class Solution973 {
    
    public int len;
    public int[][] answer;
    public Node[] arr;
    public int[][] kClosest(int[][] points, int K) {
        
        len = points.length;
        arr = new Node[len];
        answer = new int[K][2];
        int dis = 0;
        for(int i=0; i< len; i++)
        {
            dis = func(points[i][0], points[i][1]);
            arr[i] = new Node(points[i][0], points[i][1], dis);
        }
        Arrays.sort(arr, 0, len, new mySort());
        
        for(int i=0; i< K; i++)
        {
            answer[i][0] = arr[i].dx;
            answer[i][1] = arr[i].dy;
        }
        
        return answer;
    }
    public int func(int dx, int dy)
    {
        return dx*dx + dy*dy;
    }
    public class mySort implements Comparator<Node> {
        
        @Override
        public int compare(Node a, Node b){
            if(a.dis < b.dis) return -1;
            else if(a.dis > b.dis) return 1;
            else return 0;
        }
    }
    public class Node {
        int dx, dy, dis;
        Node(int a, int b, int c) {
            dx=a; dy=b; dis = c;
        }
    }
}
