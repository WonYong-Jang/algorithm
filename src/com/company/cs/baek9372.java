package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 상근이의 여행 ( 위상 정렬 이용 ) 
 */
public class baek9372 {

	static int[] visit = new int[1001];
	static int[] degree = new int[1001];
	static int N, M, minDegree, index,  ans;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int i=0; i< testCase ; i++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			init();
			int dx, dy;
			for(int j=1; j<= M; j++)
			{
				st = new StringTokenizer(br.readLine());
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				adj.get(dx).add(dy);
				adj.get(dy).add(dx);
				degree[dx]++; degree[dy]++;
			}
			
			for(int j=1; j<= N; j++)
			{
				if(degree[j] < minDegree) { // 가장 적은 degree 구하기 
					index = j;
					minDegree = degree[j];
				}
			}
			solve();
			System.out.println(ans);
		}
	}
	public static void solve()
	{
		Queue<Integer> que = new LinkedList<>();
		que.add(index);
		visit[index] = 1; // 가장 적은 degree 부터 시작하게 되면 겹치는 노드 방지 
		while(!que.isEmpty())
		{
			int n = que.poll();
			
			for(int next : adj.get(n))
			{
				if(visit[next] == 1) continue;
				ans++;
				visit[next] = 1;
				que.add(next);
			}
		}
	}
	public static void init()
	{
		index =0; ans =0;
		minDegree = 10005;
		adj.clear();
		for(int i=0; i<= N; i++)
		{
			adj.add(new ArrayList<>());
		}
		for(int i=1; i<= N; i++)
		{
			visit[i] = 0; degree[i] = 0;
		}
	}
}






