package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 플로이드 워셜 알고리즘 O(N^3) 이기 때문에 1초안에 해결하려면 N =500 이하인 문제만 적용 가능! 
 */
public class baek11404 {

	static int N, M;
	static final int INF = 10000005; // 무한대 
	static int[][] d = new int[105][105];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		int dx, dy, cost;
		
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				if(i == j) d[i][j] = 0; // i to j 값이 같은 경우는 cost 0
				else d[i][j] = INF; // 무한대로 초기값 설정 
			}
		}
		
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			if(d[dx][dy] != INF) d[dx][dy] = min(cost,d[dx][dy]); // 최소 비용으로 설정 같은 경로에서 
			else d[dx][dy] = cost;
		}
		
		for(int k=1; k<= N; k++)
		{
			for(int s=1; s<= N; s++)
			{
				for(int e=1; e<= N; e++)
				{
					if(d[s][e] > d[s][k] + d[k][e]) {
						d[s][e] = d[s][k] + d[k][e];
					}
				}
			}
		}
		
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				if(d[i][j] == INF) System.out.print(0+" ");
				else System.out.print(d[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
}
