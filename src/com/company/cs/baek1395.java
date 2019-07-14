package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 스위치 
 */
public class baek1395 {

	static final int max_node = 100001;
	static int N, M;
	static Node[] tree = new Node[4*max_node];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=1; i < N * 4; i++)
		{
			tree[i] = new Node(0,0);
		}
		int cmd = 0, dx = 0, dy = 0;
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			cmd = Integer.parseInt(st.nextToken());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			if(cmd == 0) // 스위치 반전 
			{
				update(1, 1, N, dx, dy);
			}
			else // 갯수 세기 
			{
				int result = sum(1, 1, N, dx, dy);
				bw.write(result+"\n");
			}
		}
		bw.flush();
	}
	public static int sum(int node, int start, int end, int i, int j)
	{
		if(tree[node].lazy != 0 )
		{
			tree[node].num = (end-start+1) - tree[node].num;
			if(start != end)
			{
				tree[node*2].lazy = (tree[node*2].lazy + 1) % 2;
				tree[node*2+1].lazy = (tree[node*2+1].lazy + 1) % 2;
			}
			tree[node].lazy = 0;
		}
		
		if(i > end || j < start) return 0;
		else if(i <= start && end <= j)
		{
			return tree[node].num;
		}
		int mid = (start + end) / 2;
		return sum(node*2, start, mid, i, j) + sum(node*2+1, mid+1, end, i, j);
	}
	public static void update(int node, int start, int end, int i, int j)
	{
		if(tree[node].lazy != 0 )
		{
			tree[node].num = (end-start+1) - tree[node].num;
			if(start != end)
			{
				tree[node*2].lazy = (tree[node*2].lazy + 1) % 2;
				tree[node*2+1].lazy = (tree[node*2+1].lazy + 1) % 2;
			}
			tree[node].lazy = 0;
		}
		
		if(i > end || j < start) return;
		else if(i <= start && end <= j)
		{
			tree[node].num = (end-start+1) - tree[node].num;
			if(start != end)
			{
				tree[node*2].lazy = (tree[node*2].lazy + 1) % 2;
				tree[node*2+1].lazy = (tree[node*2+1].lazy + 1) % 2;
			}
			return;
		}
		int mid = (start + end) / 2;
		update(node*2, start, mid, i, j);
		update(node*2+1, mid+1, end, i, j);
		tree[node].num = tree[node*2].num + tree[node*2+1].num;
	}
	static class Node {
		int num, lazy;
		Node(int a, int b) {
			num=a; lazy=b;
		}
	}
}
