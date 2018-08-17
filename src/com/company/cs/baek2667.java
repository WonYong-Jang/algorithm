package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 단지 번호 붙이기 
 */
public class baek2667 {

	static int[][] map = new int[26][26];
	static int[][] visit = new int[26][26];
	static int N;
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static PriorityQueue<Integer> result = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		String str;
		for(int i=1; i<= N; i++)
		{
			str = br.readLine();
			for(int j=1; j<= N; j++)
			{
				map[i][j] = str.charAt(j-1) - '0';
			}
		}
		
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				if(visit[i][j] == 1 || map[i][j] == 0) continue; // 방문 했거나 0 continue 
				int ans = solve(i,j);
				result.add(ans);
			}
		}
		System.out.println(result.size());
		while(!result.isEmpty()) System.out.println(result.poll());
	}
	public static int solve(int dx, int dy)
	{
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(dx,dy));
		visit[dx][dy] = 1;
		int cnt =1;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx,ny) || visit[nx][ny] == 1 || map[nx][ny] == 0) continue;
				que.add(new Node(nx, ny));
				visit[nx][ny] = 1;
				cnt++;
			}
		}
		return cnt;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 1 && dy >= 1 && dx <= N && dy <= N;
	}
	static class Node {
		int dx, dy;
		Node(int x, int y) {
			dx = x; dy = y;
		}
	}
}
