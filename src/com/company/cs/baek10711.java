package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 모래성 
 */
public class baek10711 {

	static int N, M, ans;
	static int[][] map = new int[1005][1005];
	static int[][][] del = new int[2][1005][1005];
	static Queue<Node> que = new LinkedList<>();
	static int[] dxArr = {-1, 0, 1, 0, 1, 1, -1, -1};
	static int[] dyArr = {0, 1, 0 , -1, 1, -1, -1, 1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;
		for(int i=1; i<= N; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= M; j++)
			{
				char temp = str.charAt(j-1);
				if(temp == '.') map[i][j] = 0;
				else map[i][j] = str.charAt(j-1) - '0';
			}
		}
		
		for(int i=2; i< N; i++) // del 배열 미리 계산 
		{
			for(int j=2; j< M; j++)
			{
				if(map[i][j] == 0) continue;
				for(int k=0; k<8; k++)
				{
					int nx = i + dxArr[k];
					int ny = j + dyArr[k];
					if(map[nx][ny] == 0) del[0][i][j]++; // 모래성이 무너짐 합산 
				}
				if(del[0][i][j] >= map[i][j] ) {
					que.add(new Node(i,j));
					del[1][i][j] = 1; // 지웠다라는 표시 
				}
			}
		}
		
		solve();
		
		System.out.println(ans);
	}
	public static void solve()
	{
		int len =0, min=0;
		while(!que.isEmpty())
		{
			len = que.size();
			min++;
			for(int i=0; i<len; i++)
			{
				Node n = que.poll();
				
				for(int k=0; k<8; k++)
				{
					int nx = n.dx + dxArr[k];
					int ny = n.dy + dyArr[k];
					if(map[nx][ny] == 0 || del[1][nx][ny] == 1) continue;
					
					if(map[nx][ny] > 0 && del[1][nx][ny] == 0) del[0][nx][ny]++;
					if(map[nx][ny] > 0 && del[0][nx][ny] >= map[nx][ny])
					{
						que.add(new Node(nx, ny));
						del[1][nx][ny] = 1;
					}
				}
				map[n.dx][n.dy] = 0;
			}
		}
		ans= min;
	}
	public static void debug()
	{
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				System.out.print(del[i][j]+" ");
			}
			System.out.println();
		}
	}
	static class Node{
		int dx, dy;
		Node(int a, int b){
			dx = a; dy = b;
		}
	}
}
