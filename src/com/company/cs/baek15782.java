package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Calculate! 2
 */
public class baek15782 {

	static final int max_value = 100001;
	static int N, M, ret;
	static ArrayList<Integer>[] adj = new ArrayList[100005];
	static Tree[] tree = new Tree[4 * max_value];
	static int[] visit = new int[max_value+5];
	static Node[] tmp = new Node[max_value+5];
	static Node[] data = new Node[max_value+5];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ret = 0;
		for(int i=1; i<= N; i++)
		{
			adj[i] = new ArrayList<>();
		}
		for(int i=1; i<= N*4; i++) tree[i] = new Tree(0,0);
		
		int dx = 0, dy = 0, num = 0, cmd = 0;
		for(int i=1; i<= N-1; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			adj[dx].add(dy);
			adj[dy].add(dx);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			num = Integer.parseInt(st.nextToken());
			tmp[i] = new Node(num);
			data[i] = new Node(0);
		}
		
		dfs(1);
		init(1, 1, N);
		int result = 0, target = 0, child = 0;
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			cmd = Integer.parseInt(st.nextToken());
			dx = Integer.parseInt(st.nextToken());
			if(cmd == 1)
			{
				target = tmp[dx].index;
				child = tmp[dx].child;
				result = sum(1, 1, N, target - child, target);
				bw.write(result+"\n");
			}
			else
			{
				num = Integer.parseInt(st.nextToken());
				target = tmp[dx].index;
				child = tmp[dx].child;
				update(1, 1, N, target-child, target, num);
			}
		}
		bw.flush();
	}
	public static int sum(int node, int start, int end, int i, int j)
	{
		if(tree[node].lazy != 0)
		{
			if( (end-start+1) % 2 != 0) tree[node].num ^= tree[node].lazy;
			if(start != end)
			{
				tree[node*2].lazy ^= tree[node].lazy;
				tree[node*2+1].lazy ^= tree[node].lazy;
			}
			tree[node].lazy = 0;
		}
		
		if(end < i || j < start) return 0;
		else if(i <= start && end <= j )
		{
			return tree[node].num;
		}
		int mid = (start + end) >> 1;
		return sum(node*2, start, mid, i, j) ^ sum(node*2+1, mid+1, end, i, j);
	}
	public static void update(int node, int start, int end, int i, int j, int num)
	{
		if(tree[node].lazy != 0)
		{
			if( (end-start+1) % 2 != 0) tree[node].num ^= tree[node].lazy;
			if(start != end)
			{
				tree[node*2].lazy ^= tree[node].lazy;
				tree[node*2+1].lazy ^= tree[node].lazy;
			}
			tree[node].lazy = 0;
		}
		
		if(end < i || j < start) return;
		else if(i <= start && end <= j)
		{
			if( (end-start+1) % 2 != 0 ) tree[node].num ^= num;
			if(start != end)
			{
				tree[node*2].lazy ^= num;
				tree[node*2+1].lazy ^= num;
			}
			return;
		}
		int mid = (start + end) >> 1;
		update(node*2, start, mid, i, j, num);
		update(node*2+1, mid+1, end, i, j, num);
		tree[node].num = tree[node*2].num ^ tree[node*2+1].num;
	}
	public static int init(int node, int start, int end)
	{
		int mid = (start + end) >> 1;
		if(start == end) return tree[node].num = data[start].cost;
		else return tree[node].num = init(node*2, start, mid) ^ init(node*2+1, mid+1, end);
	}
	static int dfs(int cur)
	{
		int child = 0;
		visit[cur] = 1;
		for(int next : adj[cur])
		{
			if(visit[next] == 1) continue;
			child += dfs(next);
		}
		
		tmp[cur].child = child;
		tmp[cur].index = ++ret;
		data[ret].child = child;
		data[ret].index = ret;
		data[ret].cost = tmp[cur].cost;
		
		return child + 1;
	}
	static class Node {
		int index, cost, child;
		Node(int a) { 
			cost = a;
		}
	}
	static class Tree {
		int num, lazy;
		Tree(int a, int b) {
			num = a; lazy = b;
		}
	}
}


