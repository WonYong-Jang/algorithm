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
import java.util.StringTokenizer;

public class Main {

	static final int max_value = 300000;
	static int N ,K;
	static int[] tree = new int[max_value*4+5];
	static Node[] data = new Node[max_value+5];
	static Point[] q = new Point[max_value+5];
	static int[] ans = new int[max_value+5];
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
			
			for(int i=1; i<= N*4; i++) tree[i] = 0;
			
			st = new StringTokenizer(br.readLine());
			int left = 0, right = 0, num = 0;
			for(int i=1; i<= N; i++)
			{
				num = Integer.parseInt(st.nextToken());
				data[i] = new Node(num, i);
				ans[i] = 0;
			}
			for(int i=1; i<= K; i++)
			{
				st = new StringTokenizer(br.readLine());
				left = Integer.parseInt(st.nextToken());
				right = Integer.parseInt(st.nextToken());
				num = Integer.parseInt(st.nextToken());
				q[i] = new Point(left, right, num, i);
			}
			Arrays.sort(data, 1, N+1, new dSort());
			Arrays.sort(q, 1, K+1, new qSort());
			
			
			
			int index = 0, end = N+1;
			for(int i=1; i<= K; i++)
			{
				index = lower_bound(1, N+1, q[i].height);
				
				for(int j = index; j < end; j++)
				{
					update(1, 1, N, data[j].index, 1);
				}
				int result = get(1, 1, N, q[i].left, q[i].right);
				
				end = index;
				
				ans[q[i].index] = result;
			}
			bw.write("#"+k+" ");
			for(int i=1; i<= K; i++)
			{
				bw.write(ans[i]+" ");
			}
			bw.write("\n");
		}
		 bw.flush();
	}
	public static int get(int node, int start, int end, int i, int j)
	{
		int mid = (start + end) / 2;
		if(end < i || j < start) return 0;
		else if(i<= start && end <= j) return tree[node];
		else return get(node*2, start, mid, i, j) + get(node*2+1, mid+1, end, i, j);
	}
	public static void update(int node, int start, int end, int index, int num)
	{
		if(index < start || end < index) return;
		tree[node] += num;
		if(start == end) return;
		int mid = (start + end) / 2;
		update(node*2, start, mid, index, num);
		update(node*2+1, mid+1, end, index, num);
	}
	public static int lower_bound(int s, int e, int target)
	{
		int mid = 0;
		
		while(s < e)
		{
			mid = (s + e) / 2;
			if(data[mid].height <= target) {
				s = mid + 1;
			}
			else {
				e = mid;
			}
		}
		return e;
	}
	static class qSort implements Comparator<Point> {
		@Override
		public int compare(Point a, Point b) {
			if(a.height < b.height) return 1;
			else if(a.height > b.height) return -1;
			else return 0;
		}
	}
	static class dSort implements Comparator<Node> {
		@Override
		public int compare(Node a, Node b) {
			if(a.height < b.height) return -1;
			else if(a.height > b.height ) return 1;
			else return 0;
		}
	}
	static class Point {
		int left, right, height, index;
		Point(int a, int b, int c, int d) {
			left = a; right = b; height = c; index = d;
		}
	}
	static class Node {
		int height, index;
		Node(int a, int b) {
			height = a; index = b; 
		}
	}
}


