package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
/** 
 * 아이템 먹기 
 */
public class baek2411 {

	static int N, M, A, B;
	static int[][] map = new int[105][105];
	static int[][] dp = new int[105][105];
	static ArrayList<Node> point = new ArrayList<>();
	static int[] dxArr = {1, 0}, dyArr = {0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				dp[i][j] = -1;
			}
		}
		
		int dx = 0, dy = 0;
		for(int i=1; i<= A; i++) // item 
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			map[dx][dy] = 1;
			point.add(new Node(dx, dy));
		}
		for(int i=1; i<= B; i++) // obstacle 
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			map[dx][dy] = -1;
		}
		point.add(new Node(1,1));
		point.add(new Node(N,M));
		Collections.sort(point, new mySort());
		int result = 1;
		for(int i=0; i < point.size() - 1; i++)
		{
			
			result *= solve(point.get(i), point.get(i+1), point.get(i));
			
		}
		
		System.out.println(result);
	}
	public static int solve(Node start, Node end, Node cur)
	{
		int dx = cur.dx, dy = cur.dy, sum = 0;
		if(dp[dx][dy] != -1) return dp[dx][dy];
		else if(dx == end.dx && dy == end.dy) return 1;
		else
		{
			for(int i=0; i < 2; i++)
			{
				int rdx = dx + dxArr[i];
				int rdy = dy + dyArr[i];
				if(!isRange(rdx,rdy) || map[rdx][rdy] == -1) continue;
				if(rdx > end.dx || rdy > end.dy) continue;
				
				Node newNode = new Node(rdx,rdy);
				sum += solve(start, end, newNode);
			}
			
			return dp[dx][dy] = sum;
		}
	}
	static class mySort implements Comparator<Node> {
		@Override
		public int compare(Node a, Node b) {
			if(a.dx < b.dx) return -1;
			else if(a.dx > b.dx) return 1;
			else {
				if(a.dy < b.dy) return -1;
				else if(a.dy > b.dy) return 1;
				else return 0;
			}
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 1 && dy >= 1 && dx <= N && dy <= M;
	}
	static class Node {
		int dx, dy;
		Node(int a, int b) {
			dx = a; dy = b;
		}
	}
}
