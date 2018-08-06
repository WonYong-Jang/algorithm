package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 웜홀 ( 벨만포드 알고리즘 ) 
 */
public class baek1865 {

	static final int INF = 10005*2700;
	static int N, M, W; // 지점의 수, 도로의 수, 웜홀의 갯수 
	static ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
	static int[] dis = new int[505];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			adj.clear();
			for(int i=0; i<= N; i++)
			{
				adj.add(new ArrayList<>());
			}
			int dx, dy, cost;
			for(int i=1; i<= M; i++)
			{
				st = new StringTokenizer(br.readLine());
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				cost = Integer.parseInt(st.nextToken());
				adj.get(dx).add(new Node(dy,cost));
				adj.get(dy).add(new Node(dx,cost));
			}
			for(int i=1; i<= W; i++) // 웜홀 
			{
				st = new StringTokenizer(br.readLine());
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				cost = Integer.parseInt(st.nextToken());
				adj.get(dx).add(new Node(dy,-cost));
			}
			
			for(int i=1; i<= N; i++) dis[i] = INF;
			dis[1]=0;
			int flag =0;
			for(int i=1; i<= N; i++)
			{
				for(int j=1; j<= N; j++)
				{
					for(Node n : adj.get(j))
					{
						if(dis[j] != INF && dis[n.dx] > n.cost + dis[j])
						{
							dis[n.dx] = n.cost + dis[j];
							if(i == N) {
								flag =1; break;
							}
						}
					}
				}
			}
			if(flag ==1) System.out.println("YES");
			else System.out.println("NO");
			
		}
	}
	static class Node{
		int dx, cost;
		Node(int x, int y) {
			dx = x; cost = y;
		}
	}
}








