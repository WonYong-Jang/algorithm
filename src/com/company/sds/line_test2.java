package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class line_test2 {
	
	static int[][] map = new int[1005][1005];
	static int[] visit = new int[1005];
	static ArrayList<Integer> arr = new ArrayList<>();
	static PriorityQueue<Integer> sQue = new PriorityQueue<>();
	static ArrayList<ArrayList<Integer>> adj= new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int n = Integer.parseInt(br.readLine());
            for (int i = 1; i <= n; i++) {
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                
                arr.clear();
                while (tokenizer.hasMoreTokens()) {
                    int fork = Integer.parseInt(tokenizer.nextToken());
                    arr.add(fork);
                    
                }
                
                for(int k=0; k< arr.size()-1; k++)
                {
                	map[arr.get(k)][arr.get(k+1)] = 1;
                }
            }
            
            for(int i=0; i<= 1000; i++)
            {
            	adj.add(new ArrayList<>()); // 인접 리스트 
            	visit[i] = 0;
            }
            for(int i=1; i<= 1000; i++)
            {
            	for(int j=1; j<= 1000; j++)
            	{
            		if(map[i][j] == 1)
            		{
            			adj.get(i).add(j);
            		}
            	}
            }
            
            for(int i=1; i<=1000; i++)
            {
            	if(visit[i] == 0) solve(i);
            }
            
            while(!sQue.isEmpty())
            {
            	int num = sQue.poll();
            	System.out.print(num+ " ");
            }
        }
    }
    public static void solve(int target)
    {
    	
    	Queue<Integer> que = new LinkedList<>();
    	que.add(target);
    	visit[target] = 1;
    	int ans = -1;
    	while(!que.isEmpty())
    	{
    		int cur = que.poll();
    		
    		for(int next : adj.get(cur) )
    		{
    			if(visit[next] == 1)
    			{
    				ans = -1;
    			}
    			else {
    				que.add(next);
        			ans = next;
        			visit[next] = 1;
    			}
    			
    		}
    	}
    	if(ans != -1) sQue.add(ans);
    }
    static class Node{
    	int dx, dy;
    	Node(int x, int y) {
    		dx =x ; dy = y;
    	}
    }
}
