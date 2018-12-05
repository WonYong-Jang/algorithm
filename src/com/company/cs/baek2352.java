package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 반도체 설계 
 */
public class baek2352 {

	static int N, start, size;
	static final int max_node = 40005;
	static int[] tree = new int[4*max_node];
	static ArrayList<Node> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		start = 1; size =0;
		while(N > start) start *=2;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			int num = Integer.parseInt(st.nextToken());
			arr.add(new Node(num, i));
		}
		
		Collections.sort(arr,new mySort());
		
		for(Node cur : arr)
		{
			int maxCnt = query(1, cur.idx);
			update(cur.idx, maxCnt+1);
			size = max(size, maxCnt+1);
		}
		System.out.println(size);
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
		int s = start + sdx - 1;
		int e = start + edx - 1;
		int ret = 0;
		
		while(s <= e)
		{
			if(s % 2 == 1)
			{
				if(ret < tree[s]) {
					ret = tree[s];
				}
			}
			s = (s + 1) / 2;
			
			if(e % 2 == 0)
			{
				if(ret < tree[e]) {
					ret = tree[e];
				}
			}
			e = (e - 1) / 2;
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
		Node(int a, int b) {
			num=a; idx=b;
		}
	}
}




