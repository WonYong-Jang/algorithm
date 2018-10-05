package com.company.sds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 홈 방범 서비스 
 */
public class swExpert2117 {

	static int N, M, ans;
	static int[][] map = new int[25][25];
	static int[][] visit = new int[25][25];
	static Queue<Node> que = new LinkedList<>();
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ans = 0;
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= N; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=1; i<= N; i++)
			{
				for(int j=1; j<= N; j++)
				{
					solve(i, j);
				}
			}
			
			bw.write("#"+k+" "+ans+"\n");
		}
		bw.flush();
	}
	public static void solve(int dx ,int dy)
	{
		for(int i=1; i<= N; i++) // 시작전 초기화 
			for(int j=1; j<= N; j++)
				visit[i][j] = 0;
		
		int homeCnt = 0, curDepth = 1; // 지금까지 집 갯수 , 현재 depth
		que.clear();
		que.add(new Node(dx, dy, 1));
		visit[dx][dy] = 1;
		if(map[dx][dy] == 1) homeCnt++;
		
		if(M * homeCnt - ((curDepth*curDepth) + (curDepth-1) * (curDepth-1)) >= 0)
			ans = max(ans, homeCnt); // depth 1일때 먼저 계산하고 들어가기 
		
		for(int k=1; k<= N * 2 -2; k++) // 최대 범위 만큼 
		{
			int len = que.size();
			
			if(que.isEmpty()) break;
			
			curDepth++; // depth 증가 
			
			for(int i=1; i <= len; i++) // que 사이즈 만큼 
			{
				Node n = que.poll();
				
				for(int j=0; j<4; j++)
				{
					int nx = n.dx + dxArr[j];
					int ny = n.dy + dyArr[j];
					if(!isRange(nx, ny) || visit[nx][ny] == 1) continue;
					
					if(map[nx][ny] == 1) homeCnt++;
					que.add(new Node(nx, ny, n.cnt+1));
					visit[nx][ny] = 1;
				}
			}
			
			
			if(M * homeCnt - ((curDepth*curDepth) + (curDepth-1) * (curDepth-1)) >= 0)
				ans = max(ans, homeCnt); // 손해 보지 않는다면 집의 갯수 가장 많은거 찾기 
		}
		
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=1 && dy>=1 && dx<= N && dy<= N;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	static class Node{
		int dx, dy, cnt; // depth 표시 
		Node(int a, int b, int c) { 
			dx = a; dy = b; cnt = c;
		}
	}
}
