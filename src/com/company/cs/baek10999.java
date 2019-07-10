package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 구간 합 구하기 2
 */
public class baek10999 {

	static final int max_node = 1000010;
	static int N, M, K;
	static long[] data = new long[max_node];
	static long[][] tree = new long[2][3*max_node];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			data[i] = (long)Integer.parseInt(st.nextToken());
		}
		
		init(1,1,N);
		
		int cmd = 0, dx = 0, dy = 0;
		long value = 0;
		for(int i=1; i<= M+K; i++)
		{
			st = new StringTokenizer(br.readLine());
			cmd = Integer.parseInt(st.nextToken());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			if(cmd == 1)
			{
				value = (long)Integer.parseInt(st.nextToken());
				update(1,1,N,dx,dy,value);
			}
			else
			{
				long result = sum(1,1,N,dx,dy);
				bw.write(result+"\n");
			}
		}
		bw.flush();
	}
	public static void update(int node, int start, int end, int i, int j, long diff)
	{
		if(tree[1][node] != 0)
		{
			tree[0][node] += (end-start+1)*tree[1][node];
			if(start != end)
			{
				tree[1][node*2] += tree[1][node];
				tree[1][node*2+1] += tree[1][node];
			}
			tree[1][node] = 0;
		}
		
		if(end < i || j < start) return;
		if(i <= start && end <= j)
		{
			tree[0][node] += (end-start+1)*diff;
			if(start != end)
			{
				tree[1][node*2] += diff;
				tree[1][node*2+1] += diff;
			}
			return;
		}
		int mid =  (start + end) / 2;
		update(node*2, start, mid, i, j, diff);
		update(node*2+1, mid+1, end, i, j, diff);
		tree[0][node] = tree[0][node*2] + tree[0][node*2+1];
	}
	public static long sum(int node, int start, int end, int i, int j)
	{
		if(tree[1][node] != 0)
		{
			tree[0][node] += (end-start+1)*tree[1][node];
			if(start != end)
			{
				tree[1][node*2] += tree[1][node];
				tree[1][node*2+1] += tree[1][node];
			}
			tree[1][node] = 0;
		}
		
		int mid = (start + end) / 2;
		if(end < i || j < start) return 0;
		if(i <= start && end <= j) return tree[0][node];
		else return sum(node*2 , start , mid, i, j) + sum(node*2+1, mid+1, end, i, j);
	}
	public static long init(int node, int start, int end)
	{
		int mid = (start + end)/2;
		if(start == end) return tree[0][node] = data[start];
		else return tree[0][node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
	}
	static class Node {
		long num, lazy;
		Node(long a, long b) {
			num = a; lazy = b;
		}
	}
}
