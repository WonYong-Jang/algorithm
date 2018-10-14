package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 알고스팟 
 */
public class baek1261 {

	static int N, M, ans;
	static int[][] map = new int[105][105];
	static int[][][] visit = new int[505][105][105];
	static Queue<Node> que = new LinkedList<>();
	static int[] dxArr = {-1, 0, 1, 0}, dyArr = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		ans = 500000;
		for(int i=1; i<= N; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= M; j++)
			{
				map[i][j] = str.charAt(j-1) - '0';
			}
		}
		solve();
		System.out.println(ans);
	}
	public static void solve()
	{
		que.add(new Node(1,1,0));
		visit[0][1][1] = 1;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.dx == N && n.dy == M) {
				ans = min(ans, n.cnt);
				continue;
			}
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				int curCnt = n.cnt;
				if(!isRange(nx, ny) ) continue;
				if(visit[n.cnt][nx][ny] == 1) continue;
				if(map[nx][ny]  == 1)
				{
					curCnt++; // 벽 부순 갯수 증가 
					if(curCnt >= ans) continue;
				}
				if(visit[curCnt][nx][ny] == 1) continue;
				visit[curCnt][nx][ny] = 1;
				que.add(new Node(nx, ny, curCnt));
			}
			
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= N && dy<= M;
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	static class Node {
		int dx, dy, cnt;
		Node(int a, int b, int c){
			dx =a; dy=b; cnt=c;
		}
	}
}
