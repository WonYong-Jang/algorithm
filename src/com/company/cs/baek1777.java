package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baek1777 {

	static final int max_value = 100000;
	static int N;
	static int[] tree = new int[4*max_value+5];
	static int[] data = new int[max_value+5];
	static int[] result = new int[max_value+5];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		init(1, 1, N);
		
		for(int i=N; i >= 1; i--)
		{
			int target = data[i] + 1;
			int point = get(1, 1, N, target);
			result[point] = i;
			update(1, 1, N, point, -1);
		}
		
		for(int i=N; i>=1; i--)
		{
			bw.write(result[i]+" ");
		}
		bw.write("\n");
		bw.flush();
	}
	public static int get(int node, int start, int end, int target)
	{
		if(start == end) return start;
		int mid = (start + end) / 2;
		if(tree[node*2] >= target) {
			return get(node*2, start, mid, target);
		}
		else {
			return get(node*2+1, mid+1, end, target - tree[node*2]);
		}
	}
	public static void update(int node, int start, int end, int index, int num)
	{
		if(index < start || end < index) return;
		tree[node] += num;
		if(start == end) return;
		int mid = (start + end) / 2;
		update(node*2, start, mid, index, num);
		update(node*2+1, mid+1, end, index ,num);
	}
	public static int init(int node, int start, int end)
	{
		int mid = (start + end) / 2;
		if(start == end) return tree[node] = 1;
		else return tree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
	}
}



