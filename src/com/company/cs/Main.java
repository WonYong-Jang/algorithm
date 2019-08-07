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

	static final int max_value = 100000;
	static int N, K, middle, result;
	static int[] tree = new int[4*max_value+5];
	static Node[] data = new Node[max_value+5];
	static Node[] dp = new Node[max_value+5];
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
			K = Integer.parseInt(st.nextToken());
			middle = (K >> 1) + 1;
			result = 0;
			for(int i=1; i<= N*4; i++) tree[i] = 0;
			
			st = new StringTokenizer(br.readLine());
			int num = 0;
			for(int i=1; i<= N; i++)
			{
				num = Integer.parseInt(st.nextToken());
				data[i] = new Node(num, i);
				dp[i] = new Node(num, i);
			}
			Arrays.sort(dp, 1, N+1, new mySort());
			
			for(int i=1; i<= N; i++)
			{
				data[dp[i].index].size = i;
			}
			
			for(int i=1; i<= K; i++)
			{
				update(1, 1, N, data[i].size, 1);
			}
			int mVal = get(1, 1, N, middle);
			
			result = max(result, dp[mVal].num);
			
			int start = 1, end = K+1;
			while(end <= N)
			{
				update(1, 1, N, data[start].size, -1);
				update(1, 1, N, data[end].size, 1);
				mVal = get(1, 1, N, middle);
				result = max(result, dp[mVal].num);
				
				start++;
				end++;
			}
			bw.write("#"+k+" "+result+"\n");
		}
		bw.flush();
	}
	public static int get(int node, int start, int end, int target)
	{
		if(start == end) return start;
		int mid = (start + end) >> 1;
		if(tree[node*2] >= target) {
			return get(node*2, start, mid, target);
		}
		else {
			return get(node*2+1, mid+1, end, target-tree[node*2]);
		}
	}
	public static void update(int node, int start, int end, int index, int num)
	{
		if(index < start || end < index) return;
		tree[node] += num;
		if(start == end) return;
		int mid = (start + end) >> 1;
		update(node*2, start, mid, index, num);
		update(node*2+1, mid+1, end, index, num);
	}
	static class mySort implements Comparator<Node> {
		@Override
		public int compare(Node a, Node b) {
			if(a.num < b.num) return -1;
			else if(a.num > b.num) return 1;
			else
			{
				if(a.index < b.index) return -1;
				else if(a.index > b.index) return 1;
				else return 0;
			}
		}
	}
	static class Node {
		int num, index, size;
		Node(int a, int b) {
			num = a; index = b;
			size = 0;
		}
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}