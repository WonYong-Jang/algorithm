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
 * knight
 */
public class digital_test3 {

	static int N, M, maxValue;
	static int[][] map = new int[1005][1005]; // 임의로 설정 
	static int[][] visit = new int[1005][1005]; // 임의로 설정 
	static Queue<Node> que = new LinkedList<>();
	static int[] dxArr = {1, -1, 1, -2, -2, 1, 2, 2};
	static int[] dyArr = {-2, 2, -2, -1, 1, 2, -1, 1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		if(N < 2 || M < 2) {
			System.out.println(-1);
			return; // 종료 
		}
		maxValue = 0;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				visit[i][j] = -1;
			}
		}
		
		
		solve();
		boolean flag = false;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				if(visit[i][j] == -1) flag = true;
			}
		}
		char answer;
		if(flag) answer = 'F';
		else answer = 'T';
		System.out.print(answer);
		System.out.println(maxValue);
		
	}
	public static void solve()
	{
		que.add(new Node(1,1, 0));
		visit[1][1] = 0;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(maxValue < n.cnt) maxValue = n.cnt;
			
			for(int i=0; i<8; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || visit[nx][ny] >= 0) continue;
				que.add(new Node(nx, ny, n.cnt+1));
				visit[nx][ny] = n.cnt+1;
			}
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=1 && dy >=1 && dx <= N && dy <= M;
	}
	static class Node {
		int dx, dy, cnt;
		Node(int x, int y, int z) { 
			dx = x; dy = y; cnt = z;
		}
	}
}
