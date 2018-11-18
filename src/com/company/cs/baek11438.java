package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * LCA2
 */
public class baek11438 {

	static int N, M, max_level;
	static final int MAX_NODE = 100005;
	static int[] depth = new int[MAX_NODE]; // 노드의 깊이(레벨) 
	static int[][] parent = new int[MAX_NODE][20]; // parent[x][y] :: x 의 2^y번째 조상을 의미  
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(); 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
		}
		
		max_level = 0;
		int result =1;
		while(result < MAX_NODE) // max_level 구하기 
		{
			result *= 2;
			max_level++;
		}
		
		int dx =0, dy=0;
		for(int i=1; i<= N-1; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			adj.get(dx).add(dy);
			adj.get(dy).add(dx);
		}
		
		depth[0] = -1; // 루트 노드 깊이를 0으로 만들어 주기 위해 ! 
		makeTree(1,0); // 트리 만들기 !! 
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			
			if(depth[dx] != depth[dy]) // 두 노드의 깊이가 다를 경우 같게 맞춰 줘야함 
			{
				if(depth[dx] > depth[dy]) // dy 의 깊이가 더 크다라고 가정하고 끌어올린후 깊이를 같게 만든다 
				{ 
					int tmp = dx;
					dx = dy;
					dy = tmp;
				}
				
				for(int k = max_level; k >= 0; k--)
				{
					if(depth[dx] <= depth[parent[dy][k]])
						dy = parent[dy][k];
				}
			}
			
			int lca = dx;
			
			if(dx != dy)
			{
				for(int k = max_level; k >= 0; k--)
				{
					if(parent[dx][k] != parent[dy][k])
					{
						dx = parent[dx][k];
						dy = parent[dy][k];
					}
					lca = parent[dx][k];
				}
			}
			bw.write(lca+"\n");
		}
		bw.flush();
	}
	public static void makeTree(int cur, int p)
	{
		depth[cur] = depth[p] + 1; // 부모 노드의 깊이에서 +1 ==> 현재 노드 깊이 
		parent[cur][0] = p; // 바로 위 부모 노드 
		
		/*
		  	Node 의 2^i 번째 조상은 tmp 의 2^(i-1) 번째 조상의 2^(i-1)번째 조상과 
		  	같다는 의미
		  	예 ) i =3 일때
		  	Node의 8번째 조상은 tmp(Node의 4번째 조상)의 4번째 조상과 같다.
		  	i=4 일때는 Node 16번째 조상은 Node 의 8번째 조상(tmp)의 8번째와 같다.
		 */
		for(int i=1; i<= max_level; i++)
		{
			int tmp = parent[cur][i-1];
			parent[cur][i] = parent[tmp][i-1];
		}
		
		for(int next : adj.get(cur)) // 자식 노드 내려가면서 확인 
		{
			if(next != p) // 사이클 방지 아래로만 내려가기 
			{
				makeTree(next, cur);
			}
		}
	}
	
}
