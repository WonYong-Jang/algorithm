package com.company.sds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class LG_tree {
	static Queue<Node> que = new LinkedList<>();
	static boolean[] visit = new boolean[100001]; // 1 ~ 
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();  
    public int[] solution(int N, int[][] directory, int[][] query) {
    	
    	int dLen = directory.length;
    	int qLen = query.length;
    	
    	for(int i=0; i<= N; i++)
    	{
    		arr.add(new ArrayList<>());
    	}
    	
    	for(int i = 0; i< dLen; i++) // 인접 리스트 
    	{
    		arr.get(directory[i][0]).add(directory[i][1]);
    		arr.get(directory[i][1]).add(directory[i][0]);
    	}
    	
    	int rIndex = -1;
    	int[] answer = new int[qLen];
    	for(int i=0; i< qLen; i++)
    	{
    		int start = query[i][0];
    		int end = query[i][1];
    		que.clear();
    		que.add(new Node(start,1));
    		
    		for(int k=1; k<= N; k++)
    		{
    			visit[k] = false;
    		}
    		
    		while(!que.isEmpty())
    		{
    			Node n = que.poll();
    			
    			if(n.index == end) {
    				answer[++rIndex] = n.cnt;
    				break;
    			}
    			
    			for(int next : arr.get(n.index))
    			{
    				if(visit[next] == false)
    				{
    					visit[next] = true;
    					que.add(new Node(next, n.cnt+1));
    				}
    			}
    			
    		}
    	}
    	
        return answer;
    }
    static class Node{
    	int index, cnt;
    	Node(int a, int b) {
    		index = a; cnt = b;
    	}
    }
}