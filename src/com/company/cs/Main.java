package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static final int max_value = 1000001;
	static int N, M, K;
	static Node[] tree = new Node[4*max_value+5];
	static long[] data = new long[max_value+5];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		long num = 0;
		
		for(int i=1; i<= N*4; i++)
		{
			tree[i] = new Node(0,0);
		}
		
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			num = (long)Integer.parseInt(st.nextToken());
			data[i] = num;
		}
		init(1, 1, N);
		int cmd = 0, dx = 0, dy = 0;
		for(int i=1; i<= M+K; i++)
		{
			st = new StringTokenizer(br.readLine());
			cmd = Integer.parseInt(st.nextToken());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			if(cmd == 1)
			{
				num = (long)Integer.parseInt(st.nextToken());
				update(1, 1, N, dx, dy, num);
			}
			else
			{
				long result = sum(1, 1, N, dx, dy);
				bw.write(result+"\n");
			}
		}
		bw.flush();
	}
	public static long sum(int node, int start, int end, int i, int j)
	{
		if(tree[node].lazy != 0)
		{
			tree[node].num += (end-start+1)*tree[node].lazy;
			if(start != end)
			{
				tree[node*2].lazy += tree[node].lazy;
				tree[node*2+1].lazy += tree[node].lazy;
			}
			tree[node].lazy = 0;
		}
		
		if(end < i || j < start) return 0;
		else if(i <= start && end <= j)
		{
			return tree[node].num;
		}
		else
		{
			int mid = (start + end) >> 1;
			return sum(node*2, start, mid, i, j) + sum(node*2+1, mid+1, end, i, j);
		}
	}
	public static void update(int node, int start, int end, int i, int j, long num)
	{
		if(tree[node].lazy != 0)
		{
			tree[node].num += (end-start+1)*tree[node].lazy;
			if(start != end)
			{
				tree[node*2].lazy += tree[node].lazy;
				tree[node*2+1].lazy += tree[node].lazy;
			}
			tree[node].lazy = 0;
		}
		
		if(end < i || j < start) return;
		else if(i <= start && end <= j) 
		{
			tree[node].num += (end-start+1)*num;
			if(start != end)
			{
				tree[node*2].lazy += num;
				tree[node*2+1].lazy += num;
			}
			return;
		}
		int mid = ( start + end) >> 1;
		update(node*2, start, mid, i, j, num);
		update(node*2+1, mid+1, end, i, j, num);
		tree[node].num = tree[node*2].num + tree[node*2+1].num;
	}
	public static long init(int node, int start, int end)
	{
		int mid = (start + end) >> 1;
		if(start == end) return tree[node].num = data[start];
		else return tree[node].num = init(node*2, start, mid) + init(node*2+1, mid+1, end);
	}
	static class Node {
		long num, lazy;
		Node(long a, long b) {
			num = a; lazy = b;
		}
	}
}




