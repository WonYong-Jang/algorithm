package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 가장 긴 증가하는 부분 수열 3
 */
public class baek12738 {

	static final int max_node = 1000005;
	static int N, s, e, size;
	static int[] tree = new int[4*max_node];
	static ArrayList<Node> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		s = 1;
		size = 0;
		while(N > s) s *= 2; 
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			int num = Integer.parseInt(st.nextToken());
			arr.add(new Node(num, i));
		}
		Collections.sort(arr,new mySort());
		for(Node cur : arr)
		{
			int maxCnt = query(1,cur.idx);
			update(cur.idx, maxCnt+1);
			size = max(size, maxCnt+1);
		}
		System.out.println(size);
	}
	public static void update(int idx, int num)
	{
		int cur = s + idx - 1;
		while(cur > 0)
		{
			if(tree[cur] < num)
			{
				tree[cur] = num;
				cur /= 2;
			}
			else break;
		}
	}
	public static int query(int start, int end)
	{
		int ret = 0;
		int sdx = s + start - 1;
		int edx = s + end - 1;
		
		while(sdx <= edx)
		{
			if(sdx % 2 == 1)
			{
				if(ret < tree[sdx])
				{
					ret = tree[sdx];
				}
			}
			sdx = (sdx + 1) / 2;
			
			if(edx % 2 == 0)
			{
				if(ret < tree[edx])
				{
					ret = tree[edx];
				}
			}
			edx = (edx -1) / 2;
		}
		
		return ret;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	static class mySort implements Comparator<Node> {
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
