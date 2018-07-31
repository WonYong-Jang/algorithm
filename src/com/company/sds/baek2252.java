package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 줄세우기 ( 위상정렬 )  : 입력받으면서 in-degree 가 0인 정점을 순서대로 출력이 위상정렬 
 * 큐를 이용하여 연결된 노드들을 방문하는데 방문할때마다 degree를 하나씩 낮춰주며 degree 가 0이 되는 노드들을
 * 큐에 넣고 계속하여 탐색 
 */
public class baek2252 {

	static int[] degree = new int[32001]; // 각 노드 마다 연결된 간선의 갯수를 담을 배열 
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	static int N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int a, b;
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
		}
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			degree[b]++;
			adj.get(a).add(b); // 인접 리스트 
		}
		for(int i=1; i<= N; i++)
		{
			if(degree[i] == -1) continue;
			if(degree[i] == 0 ) solve(i);
		}
	}
	public static void solve(int node)
	{
		Queue<Integer> que = new LinkedList<>();
		que.add(node);
		degree[node] = -1; // 방문 표시 
		while(!que.isEmpty())
		{
			int target = que.poll();
			System.out.print(target+" ");
			for(int nextValue : adj.get(target))
			{
				if(degree[nextValue] == -1) continue;
				degree[nextValue]--;
				if(degree[nextValue] == 0) {
					degree[nextValue] = -1;
					que.add(nextValue);
				}
			}
		}
	}
}






