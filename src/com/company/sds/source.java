package com.company.sds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class source {

	static final int max_node = 1000001;
	static int N, M, K;
	static long[] tree = new long[3*max_node];
	static long[] data = new long[max_node];
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
		
		int cmd = 0,dx=0, dy=0;
		for(int i=1; i<= M+K; i++)
		{
			st = new StringTokenizer(br.readLine());
			cmd = Integer.parseInt(st.nextToken());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			if(cmd == 1)
			{
				long value = (long)dy;
				update(1,1,N, dx ,value - data[dx]);
				data[dx] = value;
			}
			else
			{
				long result = sum(1,1,N, dx,dy);
				bw.write(result+"\n");
			}
		}
		 bw.flush();
	}
	public static long sum(int node, int start, int end, int i, int j)
	{
		if(i > end || j < start) return 0;
		if(i<= start && end <= j) return tree[node];
		int mid = (start + end) / 2;
		return sum(node*2, start, mid, i, j) + sum(node*2+1,mid+1, end, i, j);
	}
	public static void update(int node, int start, int end, int index, long num)
	{
		if(start > index || index > end) return;
		
		tree[node] += num;
		if(start == end) return ;
		int mid = ( start + end ) / 2;
		update(node*2, start, mid, index, num);
		update(node*2+1, mid+1, end, index, num);
	}
	public static long init(int node, int start, int end)
	{
		int mid = ( start + end ) / 2;
		if(start == end ) return tree[node] = data[start];
		else return tree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
	}
}







