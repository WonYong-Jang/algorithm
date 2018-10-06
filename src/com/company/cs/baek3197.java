package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백조의 호수 
 */
public class baek3197 {

	static int R, C, sdx, sdy, edx, edy, ans;
	static char[][] map = new char[1505][1505];
	static int[][] prediction = new int[1505][1505];
	static int[][] visit = new int[1505][1505];
	static Queue<Node> que = new LinkedList<>();
	static int[] dxArr = {0 , 0, 1, -1} , dyArr = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		ans = Integer.MAX_VALUE; // 정답 변수 
		int check =0;
		for(int i=1; i<= R; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= C; j++)
			{
				char temp = str.charAt(j-1);
				map[i][j] = temp;
				if(temp == 'L')
				{
					if(check == 0) {
						sdx = i ; sdy = j; // 백조 위치 
						check++;
					}
					else {
						edx = i; edy = j; // 백조 위치 
					}
					
				}
			}
		}
		
		for(int i=1; i<= R; i++)
		{
			for(int j=1; j<= C; j++)
			{
				if(map[i][j] == 'X')
				{
					for(int k=0; k<4; k++)
					{
						int nx = i + dxArr[k];
						int ny = j + dyArr[k];
						if(!isRange(nx, ny)) continue;
						if(map[nx][ny] == '.' || map[nx][ny] == 'L') // 물과 인접해있는 노드 넣기 
						{
							que.add(new Node(i,j, 0));
							prediction[i][j]  = 1;
						}
					}
				}
			}
		}
		solve();
		debug();
		
		System.out.println(ans);
	}
	public static void solve()
	{
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || prediction[nx][ny] > 0 ) continue;
				if(map[nx][ny] == 'X')
				{
					que.add(new Node(nx, ny, 0));
					prediction[nx][ny] = prediction[n.dx][n.dy] + 1;
				}
			}
		}
		
		// 첫번째 백조 출발 시키기 
		que.clear();
		que.add(new Node(sdx, sdy, 0));
		visit[sdx][sdy] = 1;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			int cnt = n.cnt;
			if(n.dx == edx && n.dy == edy) ans = min(ans, n.cnt); // 짧은 거리 찾기 
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || visit[nx][ny] > 0 ) continue;
				if(map[nx][ny] == '.' || map[nx][ny] == 'L')
				{
					que.add(new Node(nx, ny, n.cnt));
					visit[nx][ny] = 1;
				}
				else if(map[nx][ny] == 'X')
				{
					if(prediction[nx][ny] > n.cnt) cnt = prediction[nx][ny];
					que.add(new Node(nx, ny, cnt));
					visit[nx][ny] = 1;
				}
			}
		}
	}
	public static void debug()
	{
		for(int i=1; i<= R; i++)
		{
			for(int j=1; j<= C; j++)
			{
				System.out.print(prediction[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 1 && dy >=1 && dx <= R && dy <= C;
	}
	public static int max(int a, int  b)
	{
		return a > b ? a : b;
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	static class Node {
		int dx, dy, cnt;
		Node(int a, int b, int c) {
			dx = a; dy = b; cnt =c;
		}
	}
}
