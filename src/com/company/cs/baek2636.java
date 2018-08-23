package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 치즈 
 */
public class baek2636 {
	
	static int N, M, ans, min;
	static int[][] map = new int[105][105];
	static int[][] visit = new int[105][105];
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = min =0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true)
		{
			min++; // 시간 증가 
			solve();
			int temp = check();
			if(temp ==0) break;
		}
		System.out.println(min+"\n"+ans);
	}
	public static void solve()
	{
		int cnt = 0;
		que.clear();
		que.add(new Node(1,1)); // 벽에 있는 점은 치즈가 없으므로 시작점으로 지정 
		visit[1][1] = 1;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || visit[nx][ny]== 1 ) continue;
				
				if(map[nx][ny] == 1)
				{
					cnt++;
					map[nx][ny] = -1; // 녹일 지점 체크 
				}
				else if(map[nx][ny] == 0) que.add(new Node(nx, ny));
				visit[nx][ny] = 1;
			}
		}
		ans = cnt;
	}
	public static int check()
	{
		int result =0;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				visit[i][j] = 0; // 방문 기록 제거 
				if(map[i][j] == -1) // 체크해두었던 녹일 치즈 제거 
				{
					map[i][j] = 0;
				}
				else if(map[i][j] ==1) result++; // 남아 있는 치즈 숫작 세기 
			}
		}
		return result;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 1 && dy >= 1 && dx <= N && dy <= M;
	}
	static class Node {
		int dx, dy;
		Node(int x, int y){
			dx = x ; dy = y;
		}
	}
}
