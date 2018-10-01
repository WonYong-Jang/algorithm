package com.company.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/** 
 * 뱀 
 */
public class baek3190 {

	static int N, K, L;
	static int min, dx, dy, dir;
	static int[] dxArr = {-1, 0, 1, 0}, dyArr= {0 ,1, 0, -1}; // 북 동 남 서 
	static int[][] map = new int[105][105]; // 1 사과 
	static int[] time = new int[10005]; // 1 : D / 2 : L        ==> 0 ~ 10000 초  
	static Deque<Node> que = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		min = 0; dx = 1; dy = 1; dir = 1; // 오른쪽 방향 초기 설정 
		for(int i=0; i< K; i++)
		{
			st = new StringTokenizer(br.readLine());
			int tx = Integer.parseInt(st.nextToken());
			int ty = Integer.parseInt(st.nextToken());
			map[tx][ty] = 1; // 사과 표시 
		}
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		for(int i=0; i< L; i++)
		{
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char cmd = st.nextToken().charAt(0);
			if(cmd == 'D') time[t] = 1; // 시간에 따라 방향 전환 기록 
			else if(cmd == 'L') time[t] = 2;
		}
		solve();
		System.out.println(min);
	}
	public static void solve()
	{
		que.addFirst(new Node(1,1));
		map[1][1] = 2; // 뱀 초기 위치 
		while(!que.isEmpty())
		{
			if(time[min] == 1) dir = (dir+1) % 4; // D
			else if(time[min] == 2) dir = (dir+3) % 4; // L
			
			dx = dx + dxArr[dir];
			dy = dy + dyArr[dir]; // 다음 방향 
			min++; // 시간 증가 
			
			if(!isRange(dx, dy) || map[dx][dy] == 2) break; // 범위 넘어가거나 자기 몸에 에 닿았을때 
			que.addFirst(new Node(dx, dy));
			
			if(map[dx][dy]  != 1)
			{
				Node n = que.pollLast(); // 꼬리 빼 
				map[n.dx][n.dy] = 0; // 지워 
			}
			map[dx][dy] = 2;
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=1 && dy >=1 && dx <= N && dy <= N;
	}
	static class Node {
		int dx, dy;
		Node(int a, int b) {
			 dx = a; dy = b;
		}
	}
}
