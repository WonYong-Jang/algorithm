package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 내리갈굼 2 
 */
public class baek14268 {

	static final int max_value = 100002;
	static int N, M, ret;
	static ArrayList<Integer>[] adj = new ArrayList[100005];
	static int[] visit = new int[max_value];
	static Tree[] tree = new Tree[4*max_value];
	static Node[] tmp = new Node[max_value];
	static Node[] data = new Node[max_value];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ret = 0;
		for(int i=1; i<= N*4; i++) tree[i] = new Tree(0,0);
		for(int i=1; i<= N; i++) {
			adj[i] = new ArrayList<>();
			tmp[i] = new Node(0,0);
			data[i] = new Node(0,0);
		}
		
		st = new StringTokenizer(br.readLine());
		int num = 0, dx = 0, dy = 0;
		for(int i=1; i<= N; i++)
		{
			num = Integer.parseInt(st.nextToken());
			if(i != 1)
			{
				adj[num].add(i);
			}
		}
		dfs(1);
		
		int target =0, child = 0;
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			if(dx == 1)
			{
				num = Integer.parseInt(st.nextToken());
				target = tmp[dy].index;
				child = data[target].child;
				update(1, 1, N, target - child, target, num);
			}
			else		
			{
				target = tmp[dy].index;
				
				int result = sum(1, 1, N, target);
				bw.write(result+"\n");
			}
		}
		bw.flush();
	}
	public static void update(int node, int start, int end, int i, int j, int num)
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
		else if( i <= start && end <= j)
		{
			tree[node].num += (end-start+1)*num;
			if(start != end)
			{
				tree[node*2].lazy += num;
				tree[node*2+1].lazy += num;
			}
			return;
		}
		int mid = (start + end) >> 1;
		update(node*2, start, mid, i, j, num);
		update(node*2+1, mid+1, end, i, j, num);
		tree[node].num = tree[node*2].num + tree[node*2+1].num;
	}
	public static int sum(int node, int start, int end, int index)
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
		if(index < start || end < index) return 0;
		else if(index <= start && end <= index) return tree[node].num;
		int mid = (start + end) >> 1;
		return sum(node*2, start, mid, index) + sum(node*2+1, mid+1, end, index);
	}
	public static int dfs(int cur)
	{
		visit[cur] = 1;
		int child = 0;
		for(int next : adj[cur])
		{
			if(visit[next] == 1) continue;
			child += dfs(next);
		}
		
		tmp[cur].index = ++ret;
		data[ret].child = child;
		
		return child + 1;
	}
	static class Node {
		int index, child;
		Node(int a, int b) {
			index = a; child = b;
		}
	}
	static class Tree {
		int num, lazy;
		Tree(int a, int b) {
			num = a; lazy = b;
		}
	}
}
