package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 여행 
 */
public class baek2157 {

	static int N, M, K;
	static ArrayList<ArrayList<Node>> adj = new ArrayList<>();
	static int[][] dp = new int[305][305];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
			for(int j=0; j<= M; j++)
			{
				dp[i][j] = -1;
			}
		}
		
		int dx =0, dy =0, cost = 0;
		for(int i=1; i<= K; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			adj.get(dx).add(new Node(dy, cost));
		}
		
		int result = solve(1,1);
		System.out.println(result);
	}
	public static int solve(int curNode, int cnt)
	{
		int result = -2 ,tmp = 0;
		if(cnt > M) return -2;
		else if(curNode == N) return 0;
		else if(dp[curNode][cnt] != -1) return dp[curNode][cnt];
		else
		{
			for(Node next : adj.get(curNode))
			{
				if(next.dx <= curNode) continue;
				tmp = solve(next.dx , cnt + 1);
				if(tmp < 0) continue;
				result = max(result, tmp + next.cost);
			}
			return dp[curNode][cnt] = result;
		}
	}
	public static int max(int a, int b) { return a > b ? a : b; }
	static class Node {
		int dx, cost;
		Node(int a, int b) {
			dx=a;cost=b;
		}
	}
}

/**
5 4 6
1 2 10
2 3 10
1 3 5
3 4 10000
4 5 100
3 5 1
 */