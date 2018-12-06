package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 전깃줄 2 
 */
public class baek2568 {

	static int N, start, result;
	static final int max_node = 500005;
	static ArrayList<Node> arr = new ArrayList<>();
	static int[] tree = new int[4*max_node];
	static int[] dp = new int[max_node];
	static Deque<Integer> que = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		start = 1; result = 0;
		int chk = 0;
		
		int dx = 0, dy = 0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			arr.add(new Node(dy,dx));
			chk = max(chk, dx);
		}
		
		while(chk > start) start *= 2;
		Collections.sort(arr, new mySort());
		
		for(Node cur : arr)
		{
			int cnt = query(1, cur.idx);
			update(cur.idx, cnt+1);
			result = max(result, cnt+1);
			dp[cur.idx] = cnt+1;
		}
		bw.write( (N-result) +"\n");
		int size = result;
		for(int i = chk; i > 0; i--)
		{
			if(dp[i] == 0) continue;
			if(dp[i] == size) {
				size--;
				continue;
			}
			que.addLast(i);
		}
		while(!que.isEmpty())
		{
			int num = que.pollLast();
			bw.write(num+"\n");
		}
		bw.flush();
	}
	public static void update(int idx, int num)
	{
		int s = start + idx - 1;
		
		while(s > 0)
		{
			if(tree[s] < num)
			{
				tree[s] = num;
				s /= 2;
			}
			else break;
		}
	}
	public static int query(int sdx, int edx)
	{
		int ret = 0;
		int s = start + sdx - 1;
		int e = start + edx - 1;
		
		while(s <= e)
		{
			if(s % 2 == 1)
			{
				if( ret < tree[s])
				{
					ret = tree[s];
				}
			}
			
			if(e % 2 == 0)
			{
				if( ret < tree[e])
				{
					ret = tree[e];
				}
			}
			
			s = (s+1) / 2;
			e = (e-1) / 2;
		}
		return ret;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	static class mySort implements Comparator<Node>{
		@Override
		public int compare(Node a, Node b) {
			// TODO Auto-generated method stub
			if(a.num < b.num) return -1;
			else if(a.num > b.num) return 1;
			else {
				if(a.idx > b.idx) return -1;
				else if(a.idx < b.idx) return 1;
				else return 0;
			}
		}
	}
	static class Node {
		int num, idx;
		Node(int a, int b){
			num=a; idx=b;
		}
	}
}
