package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 하나로 
 */
public class swExpert1251 {
	
	static int N;
	static double E;
	static int[] dx = new int[1005];
	static int[] dy = new int[1005];
	static int[] parent = new int[1005];
	static PriorityQueue<Node> que = new PriorityQueue<>(new mySort());
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			que.clear();
			
			for(int i=1; i<= N; i++)
			{
				parent[i] = i;
			}
			
			st = new StringTokenizer(br.readLine()); // x 
			for(int i=1; i<= N; i++)
			{
				dx[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine()); // y
			for(int i=1; i<= N; i++)
			{
				dy[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			E = Double.parseDouble(st.nextToken());
			
			for(int i=1; i< N; i++)
			{
				for(int j= i+1; j<= N; j++)
				{
					double cost = dis(dx[i],dy[i], dx[j],dy[j]);
					que.add(new Node(i, j, cost));
				}
			}
			
			int index = 0; // N -1 만큼 나오면 mst 
			double ans = 0.0;
			while(!que.isEmpty())
			{
				Node n = que.poll();
				
				if(index == N-1) break;
				
				int pa = find(n.dx);
				int pb = find(n.dy);
				if(pa != pb)
				{
					union(pa, pb);
					index++;
					ans += n.cost;
				}
			}
			System.out.printf("%c%d %.0f\n",'#',k,ans);
		}
	}
	public static int find(int a)
	{
		if(parent[a] == a) return a;
		else return parent[a] = find(parent[a]);
	}
	public static void union(int a, int b)
	{
		int pa = find(a);
		int pb = find(b);
		parent[pa] = pb;
	}
	public static double dis(int sdx, int sdy, int edx, int edy)
	{
		double result =0;
		
		double temp1 = sdx > edx ? sdx - edx : edx - sdx;
		double temp2 = sdy > edy ? sdy - edy : edy - sdy;
		
		result = ((temp1 * temp1) + (temp2 * temp2)) * E;
		
		return result;
	}
	static class mySort implements Comparator<Node>{
		@Override
		public int compare(Node a, Node b) {
			// TODO Auto-generated method stub
			if(a.cost < b.cost) return -1;
			else if(a.cost > b.cost) return 1;
			else return 0;
		}
	}
	static class Node {
		double cost;
		int dx, dy;
		Node (int a, int b, double c) {
			dx = a ; dy = b; cost = c;
		}
	}
}
