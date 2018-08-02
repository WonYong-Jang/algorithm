package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 타임머신 ( 벨만 포드 )
 */
public class baek11657 {
	
	static int[] d = new int[505];
	static int[][] path = new int[6001][3];
	static int N, M;
	static final int INF = 10000*500+5;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int dx, dy, cost;
		for(int i=1; i<= N; i++)
		{
			d[i] = INF;
		}
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			path[i][0] = dx;
			path[i][1] = dy;
			path[i][2] = cost;
		}
		d[1] = 0;
		for(int i=1; i<= N-1; i++)
		{
			for(int j=1; j<= M; j++)
			{
				if(d[path[j][0]] != INF && d[path[j][1]] > d[path[j][0]] + path[j][2]) {
					d[path[j][1]] = d[path[j][0]] + path[j][2];
				}
			}
		}
		for(int j=1; j<= M; j++)
		{
			if(d[path[j][0]] != INF && d[path[j][1]] > d[path[j][0]] + path[j][2]) {
				System.out.println(-1);
				return;
			}
		}
		
		
		for(int i=2; i<= N; i++)
		{
			if(d[i] == INF) System.out.println(-1);
			else System.out.println(d[i]);
		}
	}

}
