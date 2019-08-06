package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 라운드 로빈 ( 세그먼트 트리 ) 
 */
public class baek12016 {

	static final int max_value = 100001;
	static int N;
	static long[] tree = new long[4*max_value + 5];
	static long[] result = new long[max_value];
	static Node[] data = new Node[max_value];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long num =0;
		int index = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			num = (long)Integer.parseInt(st.nextToken());
			data[i] = new Node(num, i);
		}
		Arrays.sort(data, 1, N+1, new mySort());
		
		init(1, 1, N);
		long sum = 0;
		for(int i=1; i<= N; i++)
		{
			num = data[i].num;
			index = data[i].index;
			long ans = get(1, 1, N, 1, index)*num + get(1, 1, N, index+1, N)*(num-1) + sum;
			result[index] = ans;
			sum += num;
			update(1, 1, N, index);
		}
		
		for(int i=1; i<= N; i++)
		{
			bw.write(result[i]+"\n");
		}
		bw.flush();
	}
	public static long get(int node, int start, int end, int i, int j)
	{
		int mid = (start + end) >> 1;
		if(end < i || j < start) return 0;
		else if(i<= start && end <= j) return tree[node];
		else return get(node*2, start, mid, i, j) + get(node*2+1, mid+1, end, i, j);
	}
	public static void update(int node, int start, int end, int index)
	{
		if(index < start || end < index) return;
		if(start == end) {
			tree[node] = 0;
			return;
		}
		int mid = (start + end) >> 1;
		update(node*2, start, mid, index);
		update(node*2+1, mid+1, end, index);
		tree[node] = tree[node*2] + tree[node*2+1];
	}
	public static long init(int node, int start, int end)
	{
		int mid = (start + end) >> 1;
		if(start == end) return tree[node] = 1;
		else return tree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
	}
	static class mySort implements Comparator<Node> {
		@Override
		public int compare(Node a, Node b) {
			if(a.num < b.num) return -1;
			else if(a.num > b.num) return 1;
			else {
				if(a.index < b.index) return -1;
				else if(a.index > b.index) return 1;
				else return 0;
			}
		}
	}
	static class Node {
		long num;
		int index;
		Node(long a, int b) {
			num = a; index = b;
		}
	}
}