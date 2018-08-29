package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 탈옥 
 */
public class baek9376 {

	static int H, W;
	static char[][] map = new char[105][105];
	static int[][][] visit = new int[105][105][3]; // 0 : 첫번째 죄수 , 1: 두번째 죄수 , 2: 상근이  	
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k =1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			init(); // 초기화 
			int check = 0; // 죄소 1, 2 구분 
			for(int i=1; i<= H; i++)
			{
				String str = br.readLine();
				for(int j=1; j<= W; j++)
				{
					char temp = str.charAt(j-1);
					map[i][j] = temp;
					if(temp =='$') 
					{
						que.add(new Node(i, j, check)); // 죄수 위치 설정
						visit[i][j][check] = 0;
						check++;
					}
				}
			}
			que.add(new Node(0,0,2)); // 상근이 위치 밖으로 위치
			visit[0][0][2] = 0;
			solve();
			int ans = Integer.MAX_VALUE , temp =0;
			for(int i=0; i <= H+1; i++) // 문 밖 까지 초기화 
			{
				for(int j=0; j <= W+1; j++)
				{
					if(map[i][j] =='*' ) continue;
					temp = visit[i][j][0] + visit[i][j][1] + visit[i][j][2];
					if(map[i][j] == '#')
					{
						temp -= 2;
						ans = min(ans, temp);
					}
					else
					{
						ans = min(ans, temp);
					}
					
				}
			}
			bw.write(ans+"\n");
		}
		bw.flush();
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
				if(!isRange(nx, ny)) continue;
				if( map[nx][ny]== '*' ) continue;
				
				if(map[nx][ny]== '#') {
					if(visit[nx][ny][n.num] == -1 || visit[nx][ny][n.num] > visit[n.dx][n.dy][n.num] + 1)
					{
						visit[nx][ny][n.num] = visit[n.dx][n.dy][n.num] + 1;
						que.add(new Node(nx,ny,n.num));
					}
				}
				else 
				{
					if(visit[nx][ny][n.num] == -1 || visit[nx][ny][n.num] > visit[n.dx][n.dy][n.num])
					{
						visit[nx][ny][n.num] = visit[n.dx][n.dy][n.num];
						que.add(new Node(nx,ny,n.num));
					}
				}
			}
		}
	}
	public static void init()
	{
		que.clear();
		for(int i=0; i <= H+1; i++) // 문 밖 까지 초기화 
		{
			for(int j=0; j <= W+1; j++)
			{
				for(int k=0; k <= 2; k++)
				{
					visit[i][j][k] = -1; // 방문 안함 
				}
			}
		}
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=0 && dy>=0 && dx <= H+1 && dy <=W+1;
	}
	static class Node {
		int dx, dy, num; // 몇번 죄수 인지 
		Node(int a, int b, int c) {
			dx = a; dy = b; num = c;
		}
	}
}
