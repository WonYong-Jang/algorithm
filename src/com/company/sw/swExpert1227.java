package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 미로 
 */
public class swExpert1227 {

	static final int N = 100;
	static int[][] map = new int[105][105];
	static int[][] visit = new int[105][105];
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static int sdx, sdy, edx, edy, ans;
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for(int k=1; k<= 10; k++)
		{
			st = new StringTokenizer(br.readLine());
			int testCase = Integer.parseInt(st.nextToken());
			int temp =0;
			ans = 0;
			for(int i=0; i< N; i++)
			{
				String str = br.readLine();
				for(int j=0; j< N; j++)
				{
					visit[i][j] = 0; // 초기화 
					temp = str.charAt(j)- '0';
					map[i][j] = temp;
					if(temp == 2) { // 시작점 
						sdx = i; sdy = j;
					}
					else if(temp == 3 ) { // 끝점 
						edx = i; edy = j;
					}
				}
			}
			solve();
			bw.write("#"+k+" "+ans+"\n");
		}
		bw.flush();
	}
	public static void solve()
	{
		que.clear();
		que.add(new Node(sdx,sdy));
		visit[sdx][sdy] = 1;
		
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.dx == edx && n.dy == edy) {
				ans = 1;
				return;
			}
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				
				if(!isRange(nx, ny) || visit[nx][ny] == 1 || map[nx][ny] == 1) continue;
				visit[nx][ny] = 1;
				que.add(new Node(nx, ny));
			}
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=0 && dy >=0 && dx < N && dy < N;
	}
	static class Node {
		int dx, dy;
		Node(int x, int y) {
			dx =x; dy =y;
		}
	}
}
