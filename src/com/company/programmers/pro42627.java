package com.company.programmers;

public class pro42627 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}

/**
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Node> que = new PriorityQueue<>(new queSort());
        int len = jobs.length;
        Arrays.sort(jobs, new mySort());
        int curTime = jobs[0][1]+jobs[0][0], sum = curTime-jobs[0][0];
        
        for(int i=1; i< len; i++) {
            
            int requestTime = jobs[i][0];
            int jobTime = jobs[i][1];
            if(curTime >= requestTime) {
                que.offer(new Node(requestTime, jobTime));
            }
            else {
                
                while(!que.isEmpty()) {
                    Node cur = que.poll();
                    curTime += cur.dy;
                    sum += (curTime - cur.dx);
                    if(curTime >= requestTime) {
                        que.offer(new Node(requestTime, jobTime));
                        break;
                    }        
                }
                if(que.isEmpty()) {
                    curTime = requestTime + jobTime;
                    sum += (curTime - requestTime);
                }
                
            }
        }
        
        while(!que.isEmpty()) {
            Node cur = que.poll();
            curTime += cur.dy;
            sum += (curTime - cur.dx);
        }
        
        return sum/len;
    }
    public class queSort implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return a.dy - b.dy;
        }
    }
    public class Node {
        int dx, dy;
        Node(int a, int b) {
            dx=a; dy=b;
        }
    }
    public class mySort implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if(a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        }
    }
}
 */
