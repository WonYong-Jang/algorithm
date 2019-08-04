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
 * 터보소트 
 */
public class baek3006 {

	static final int max_value = 100001;
	static int N;
	static int[] tree = new int[4*max_value + 5];
	static Node[] data = new Node[max_value];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int num = 0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			data[i] = new Node(num, i);
		}
		Arrays.sort(data, 1, N+1, new mySort());
		init(1, 1, N);
		
		int s =1, e = N;
		
		int target = 0, result = 0;
		for(int i=1; i<= N; i++)
		{
			if(i % 2 != 0)
			{
				target = data[s].index;
				result = get(1, 1, N, 1, target -1);
				update(1, 1, N, target);
				s++;
			}
			else
			{
				target = data[e].index;
				result = get(1, 1, N, target+1, N);
				update(1, 1, N, target);
				e--;
			}
			bw.write(result+"\n");
		}
		bw.flush();
	}
	public static void update(int node, int start, int end, int index)
	{
		if(index < start || end < index) return;
		tree[node] -= 1;
		if(start == end) return;
		int mid = (start + end) / 2;
		update(node*2, start, mid, index);
		update(node*2+1, mid+1, end, index);
	}
	public static int get(int node, int start, int end, int i, int j)
	{
		int mid = (start + end) / 2;
		if(end < i || j < start) return 0;
		else if(i <= start && end <= j) return tree[node];
		else return get(node*2, start, mid, i, j) + get(node*2+1, mid+1, end, i, j);
	}
	public static int init(int node, int start, int end)
	{
		int mid = (start + end) / 2;
		if(start == end) return tree[node] = 1;
		else return tree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
	}
	static class mySort implements Comparator<Node> {
		@Override
		public int compare(Node a, Node b) {
			if(a.num < b.num) return -1;
			else if(a.num > b.num) return 1;
			else return 0;
		}
	}
	static class Node {
		int num, index;
		Node(int a, int b) { 
			num = a; index = b;
		}
	}
}




