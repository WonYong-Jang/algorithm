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
 * 로봇 
 */
public class baek13901 {

	static int[][] map = new int[1001][1001]; // 0 ~ N -1
	static int[][] visit = new int[1001][1001]; 
	static int R, C, sdx, sdy, k, edx, edy, curDir; 
	static int[] dxArr = {0, -1, 1, 0, 0}; // 1 ~ 4 상 하 좌 우 
	static int[] dyArr = {0, 0, 0, -1, 1};
	static int[] dir = new int[5]; // 1 ~ 4;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		sdx = sdy = edx = edy = 0;
		st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		int dx, dy;
		for(int i=0; i< k; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			map[dx][dy] = -1; // 벽으로 설정 
		}
		
		st = new StringTokenizer(br.readLine());
		sdx = Integer.parseInt(st.nextToken());
		sdy = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= 4; i++) dir[i] = Integer.parseInt(st.nextToken()); // 사용자가 지정한 방향 
		solve();
		bw.write(edx+" "+edy+"\n");
		bw.flush();
	}
	public static void solve()
	{
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(sdx,sdy));
		visit[sdx][sdy] = 1;
		curDir = 1;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			edx = n.dx;
			edy = n.dy;
			
			for(int i=0; i<4; i++)
			{
				if(i > 0) curDir = (curDir + 1) % 5;
				if(curDir == 0 ) curDir = 1;
				
				int ndx = n.dx + dxArr[dir[curDir]]; // 사용자가 지정한 방향부터 확인 
				int ndy = n.dy + dyArr[dir[curDir]];
				if(!isRange(ndx, ndy) || visit[ndx][ndy] == 1 || map[ndx][ndy] == -1) continue;
				que.add(new Node(ndx,ndy));
				visit[ndx][ndy] =1;
				break;
			}
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=0 && dy >= 0 && dx < R && dy < C;
	}
	static class Node{
		int dx, dy;
		Node(int x, int y) {
			dx = x; dy = y;
		}
	}
}








