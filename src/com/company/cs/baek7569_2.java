package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 토마토 2
 */
public class baek7569_2 {

	static int N, M , K, ans, tCnt;
	static int[][][] map = new int[105][105][105];
	static int[][][] visit = new int[105][105][105];
	static Queue<Node> que = new LinkedList<>();
	static int[] dxArr = {1, -1, 0, 0}, dyArr = {0 ,0, 1, -1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M =Integer.parseInt(st.nextToken());
		N =Integer.parseInt(st.nextToken());
		K =Integer.parseInt(st.nextToken());
		ans = 0; tCnt =0;
		int num =0;
		for(int k=1; k<= K; k++)
		{
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= M; j++)
				{
					int temp = Integer.parseInt(st.nextToken());
					map[k][i][j] = temp;
					if(temp == 1) // 익은 토마토 넣어 두기 
					{
						que.add(new Node(k, i, j, 0));
					}
					if(temp != 0) num++;
				}
			}
		}
		
		
		int result = N*M*K - num; // 0인 갯수 미리 카운팅
		
		solve();
		if(result - tCnt ==0) System.out.println(ans);
		else System.out.println(-1);
		
	}
	public static void solve()
	{
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			ans = max(ans, n.cnt);
			
			for(int i=0; i<4; i++) // 상하 좌우 
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(n.height ,nx, ny) || visit[n.height][nx][ny] == 1) continue;
				if(map[n.height][nx][ny] == 0)
				{
					visit[n.height][nx][ny] = 1;
					que.add(new Node(n.height, nx, ny, n.cnt+1));
					tCnt++;
				}
			}
			
			int check = -1;
			for(int i=0; i< 2; i++)
			{
				int height = n.height + check;
				check*= -1;
				if(!isRange(height ,n.dx, n.dy) || visit[height][n.dx][n.dy] == 1) continue;
				if(map[height][n.dx][n.dy] == 0)
				{
					visit[height][n.dx][n.dy] = 1;
					que.add(new Node(height, n.dx, n.dy, n.cnt+1));
					tCnt++;
				}
			}
		}
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static boolean isRange(int h ,int dx, int dy)
	{
		return dx >=1 && dy>=1 && dx<= N && dy<= M && h >=1 && h <= K; 
	}
	static class Node{
		int height ,dx, dy, cnt; // cnt : 날짜 확인 
		Node(int a, int b, int c, int d) {
			height = a; dx = b; dy = c; cnt = d;
		}
	}
}
