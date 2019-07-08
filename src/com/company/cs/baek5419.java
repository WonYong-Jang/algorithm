package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 북서풍 
 */
public class baek5419 {

	static final int max_node = 75001;
	static int N, start, end;
	static Node[] data = new Node[max_node];
	static Node[] dp = new Node[max_node];
	static int[] tree = new int[4*max_node];
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
			int dx =0, dy =0, index = 0;
			start = 1;
			while(N > start ) start *= 2;
			end = start + N -1;
			
			for(int i=1; i<= N*4; i++) tree[i] = 0;
			
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				data[i] = new Node(dx,dy,0);
			}
			Arrays.sort(data, 1, N+1, new ySort());
			for(int i=1; i<= N; i++)
			{
				data[i].index = i;
				dx = data[i].dx;
				dy = data[i].dy;
				index = data[i].index;
				dp[i] = new Node(dx,dy,index);
			}
			Arrays.sort(dp, 1, N+1, new xSort());
			
			long tmp = 0, result = 0;
			for(int i=1; i<= N; i++)
			{
				index = dp[i].index;
				
				tmp = get(index, N);
				
				result += tmp;
				set(index);
			}
			bw.write(result+"\n");
		}
		bw.flush();
	}
	public static void set(int sdx)
	{
		int dx = sdx + start - 1;
		tree[dx] = 1;
		while(dx > 1)
		{
			dx /= 2;
			tree[dx] = tree[dx*2] + tree[dx*2+1];
		}
	}
	public static long get(int sdx, int edx)
	{
		int dx = sdx + start - 1;
		int dy = edx + start - 1;
		long sum = 0;
		while(dx <= dy)
		{
			if(dx % 2 != 0) sum +=(long)tree[dx];
			if(dy % 2 == 0) sum +=(long)tree[dy];
			dx = (dx + 1) / 2;
			dy = (dy - 1) / 2;
		}
		return sum;
	}
	static class xSort implements Comparator<Node> {
		@Override
		public int compare(Node a, Node b) {
			if(a.dx < b.dx) return -1;
			else if(a.dx > b.dx) return 1;
			else 
			{
				if(a.dy < b.dy) return 1;
				else if(a.dy > b.dy) return -1;
				else return 0;
			}
		}
	}
	static class ySort implements Comparator<Node> {
		@Override
		public int compare(Node a, Node b) {
			if(a.dy < b.dy) return -1;
			else if(a.dy > b.dy) return 1;
			else
			{
				if(a.dx < b.dx) return 1;
				else if(a.dx > b.dx) return -1;
				else return 0;
			}
		}
	}
	static class Node{
		int dx,dy, index;
		Node(int a, int b, int c) {
			dx=a; dy=b; index=c;
		}
	}
}


