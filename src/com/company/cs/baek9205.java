package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 맥주 마시면서 걸어 가기 
 */
public class baek9205 {

	static String ans;
	static int N, edx, edy, sdx, sdy;
	static int[] visit = new int[105];
	static ArrayList<Node> axis = new ArrayList<>();
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int testCase = Integer.parseInt(st.nextToken());
		int dx =0, dy =0;
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			axis.clear();
			ans = "sad";
			
			for(int i=0; i< N+2; i++) visit[i] = 0; // 초기화 
			
			st = new StringTokenizer(br.readLine());
			sdx = Integer.parseInt(st.nextToken());
			sdy = Integer.parseInt(st.nextToken());
			
			axis.add(new Node(sdx,sdy)); // 시작점 
			for(int i=0; i< N; i++) // 편의점 
			{
				st = new StringTokenizer(br.readLine());
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				axis.add(new Node(dx, dy));
			}
			
			st = new StringTokenizer(br.readLine()); // 도착 점 
			edx = Integer.parseInt(st.nextToken());
			edy = Integer.parseInt(st.nextToken());
			axis.add(new Node(edx,edy));
			
			solve(sdx,sdy);
			
			bw.write(ans+"\n");
		}
		bw.flush();
	}
	public static void solve(int dx, int dy)
	{
		que.add(new Node(dx,dy));
		visit[0] = 1;
		
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.dx == edx && n.dy == edy) {
				ans = "happy";
				break;
			}
			
			for(int i=0; i< N+2; i++)
			{
				if(visit[i] == 1) continue;
				if(dis(n, axis.get(i)))
				{
					que.add(axis.get(i));
					visit[i] = 1;
				}
			}
		}
	}
	public static boolean dis(Node s, Node e) // 거리 측정 
	{
		int sum = abs(s.dx, e.dx) + abs(s.dy, e.dy);
		if(sum <= 1000) return true;
		else return false;
	}
	public static int abs(int a, int b)
	{
		return a > b ? a - b : b - a;
	}
	static class Node {
		int dx, dy;
		Node(int a, int b) {
			dx =a; dy =b;
		}
	}
}
