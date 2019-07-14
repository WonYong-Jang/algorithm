package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baek12844 {

	static final int max_node = 5000001;
	static int N, Q;
	static int[] data = new int[max_node];
	static Node[] tree = new Node[4*max_node];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i< N*4; i++)
		{
			tree[i] = new Node(0,0);
		}
		init(1, 1, N);
		
		st = new StringTokenizer(br.readLine());
		Q = Integer.parseInt(st.nextToken());
		int cmd = 0, dx = 0, dy = 0, value = 0;
		for(int i=1; i<= Q; i++)
		{
			st = new StringTokenizer(br.readLine());
			cmd = Integer.parseInt(st.nextToken());
			dx = Integer.parseInt(st.nextToken())+1;
			dy = Integer.parseInt(st.nextToken())+1; // 쿼리 순서 바뀔 수 있음 
			if(dx > dy)
			{
				int tmp = dx;
				dx = dy;
				dy = tmp;
			}
			if(cmd == 1)
			{
				value = Integer.parseInt(st.nextToken());
				update(1, 1, N, dx, dy, value);
			}
			else
			{
				int result = sum(1, 1, N, dx, dy);
				bw.write(result+"\n");
			}
		}
		bw.flush();
	}
	public static int sum(int node, int start, int end, int i, int j)
	{
		if(tree[node].lazy != 0)
		{
			if( (end-start+1) % 2 !=0)
			{
				tree[node].num ^= tree[node].lazy;
			}
			
			if(start != end)
			{
				tree[node*2].lazy ^= tree[node].lazy;
				tree[node*2+1].lazy ^= tree[node].lazy;
			}
			tree[node].lazy = 0;
		}
		
		if(i > end || j < start) return -1;
		else if(i <= start && end <= j)
		{
			return tree[node].num;
		}
		int mid = (start + end) / 2;
		int d1 = sum(node*2, start, mid, i, j);
		int d2 = sum(node*2+1, mid+1, end, i, j);
		if(d1 >= 0 && d2 >= 0)
		{
			return d1 ^ d2;
		}
		else if(d1 < 0 && d2 >= 0)
		{
			return d2;
		}
		else if(d1 >=0 && d2 < 0)
		{
			return d1;
		}
		else return -1;
	}
	public static void update(int node, int start, int end, int i, int j, int num)
	{
		if(tree[node].lazy != 0)
		{
			if( (end-start+1) % 2 !=0)
			{
				tree[node].num ^= tree[node].lazy;
			}
			
			if(start != end)
			{
				tree[node*2].lazy ^= tree[node].lazy;
				tree[node*2+1].lazy ^= tree[node].lazy;
			}
			tree[node].lazy = 0;
		}
		
		if(i > end || j < start) return;
		else if(i <= start && end <= j)
		{
			if( (end-start+1) % 2 != 0) tree[node].num ^= num;
			if(start != end)
			{
				tree[node*2].lazy ^= num;
				tree[node*2+1].lazy ^= num;
			}
			return;
		}
		int mid = (start+end) / 2;
		update(node*2, start, mid, i, j, num);
		update(node*2+1, mid+1, end, i, j, num);
		tree[node].num = tree[node*2].num ^ tree[node*2+1].num;
	}
	public static int init(int node, int start, int end)
	{
		int mid = (start + end) / 2;
		if(start == end) return tree[node].num = data[start];
		else return tree[node].num = init(node*2, start, mid) ^ init(node*2+1, mid+1, end);
	}
	static class Node {
		int num, lazy;
		Node(int a, int b) { 
			num=a; lazy=b;
		}
	}
}

/**

5
1 2 3 4 5
1
2 0 4

 */

