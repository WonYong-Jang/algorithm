package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * LCA 
 */
public class baek11437 {

	static int N, M;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	static int[] parent = new int[50005];
	static int[] depth = new int[50005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=N; i++)
		{
			adj.add(new ArrayList<>());
		}
		
		int dx=0, dy=0;
		for(int i=1; i<= N-1; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			adj.get(dx).add(dy);
			adj.get(dy).add(dx);
		}
		
		dfs(1,1,0); // parent, depth 배열 완성하기 
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			
			int xDepth = depth[dx];
			int yDepth = depth[dy]; // 각각의 depth 가져와서 확인!
			
			while(xDepth > yDepth) // x 가 클 경우 낮춰주면서 부모노드로 이동 
			{
				dx = parent[dx];
				xDepth--;
			}
			
			while(xDepth < yDepth)
			{
				dy = parent[dy];
				yDepth--;
			}
			
			while( dx != dy ) // 같은 depth 일때 둘다 부모노드로 올라가면서 찾기 
			{
				dx = parent[dx];
				dy = parent[dy];
			}
			
			System.out.println(dx);
		}
	}
	public static void dfs(int cur, int d, int p) // 현재 노드, 깊이, 부모 노드 
	{
		depth[cur] = d;
		parent[cur] = p;
		for(int next : adj.get(cur))
		{
			if(next != p) // 해당 노드에서 depth 가 더 깊은 곳으로만 이동 / 부모노드로 이동하지 않는다
			{
				dfs(next, d+1, cur); // 다음 depth 로 이동 / 현재 노드가 부모 노드가 됨 
			}
		}
	}
}








