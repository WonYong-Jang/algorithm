package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 벌꿀 채취
 *
 */
public class swExpert2115 {

	public static int[][] map = new int[11][11];
	public static int[][] visited = new int[11][11];
	public static ArrayList<Point> arr1 = new ArrayList<>(); // 첫번째 벌꿀 채취 
	public static ArrayList<Point> arr2 = new ArrayList<>(); // 두번째 벌꿀 채취   
	public static Deque<Point> que = new ArrayDeque<>();
	public static int K, N, M, C;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		for (int m = 1; m <= K; m++) 
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			for (int i = 1; i <= N; i++) // input
			{
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		
			for(int i=1; i<= N; i++)
			{
				for(int j=1; j<= N-M+1; j++)
				{
					if(visited[i][j] != 0) continue;
					visited[i][j] = 1;
					dfs(i,j,1);
					for(int k=1; k<= N; k++)
					{
						for(int l=1; l<=N-M+1; l++)
						{
							if(visited[k][l] != 0) continue;
							visited[k][l] = 1;
							dfs(k,l,1);
							visited[k][l] = 0;
						}
					}
					
					visited[i][j] = 0;
				}
			}
		}
	}

	public static void dfs(int dx,int dy, int depth) {
		if(depth == M) {
			for(int k=1; k<= N; k++)
			{
				for(int l=1; l<=N; l++)
				{
					System.out.print(visited[k][l]+" ");
				}
				System.out.println();
			}
			return;
		}
		
		for(int i=dy+1; i<= N; i++)
		{
			if(visited[dx][i] != 0) break;
			visited[dx][i] = 1;
			dfs(dx,i,depth+1);
			visited[dx][i] = 0;
		}
	}
	public static class Point{
		int dx,dy;
		Point(int x, int y) {
			dx =x; dy =y;
		}
	}
}

/*
1 
4 2 13 
6 1 9 7 
9 8 5 8 
3 4 5 3 
8 2 6 7
 */