package com.company.leetcode;

import java.util.Comparator;

public class leetcode630 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }

}


/**
class Solution {
    public int N;
    public PriorityQueue<Integer> que = new PriorityQueue<>();
    public ArrayList<Node> arr = new ArrayList<>();
    public int scheduleCourse(int[][] courses) {
        N = courses.length;
        for(int i=0; i< N; i++)
        {
            arr.add(new Node(courses[i][0], courses[i][1]));
        }
        Collections.sort(arr, new mySort());
        
        int sum = 0, num = 0;
        for(int i=0; i< N; i++)
        {
            num = arr.get(i).dx;
            sum += num;
            que.add(-num);
            if( sum > arr.get(i).dy)
            {
                sum -= (-que.poll());   
            }
        }
        
        return que.size();
    }
    public class mySort implements Comparator<Node> {
        
        @Override
        public int compare(Node a, Node b)
        {
            if(a.dy < b.dy) return -1;
            else if(a.dy > b.dy) return 1;
            else return 0;
        }
    }
    public class Node {
        int dx, dy;
        Node(int a, int b) {
            dx = a; dy = b;
        }
    }
}
 */
 

