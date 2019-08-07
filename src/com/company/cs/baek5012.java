package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 불만 정렬 (세그먼트 트리 )
 */
public class baek5012 {

	static final int max_value = 100001;
	static int N, K;
	static int[] tree = new int[4*max_value];
	static int[] left = new int[max_value];
	static int[] right = new int[max_value];
	static long result;
	static int[] data = new int[max_value];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		result = 0;
		st = new StringTokenizer(br.readLine());
		int num = 0, sum = 0;
		for(int i=1; i<= N; i++)
		{
			num = Integer.parseInt(st.nextToken());
			data[i] = num;
			sum = get(1, 1, N, num+1, N);
			left[i] = sum;
			update(1, 1, N, num);
		}
		
		for(int i=1; i<= N*4; i++)
		{
			tree[i] = 0;
		}
		
		for(int i=N; i >= 1; i--)
		{
			num = data[i];
			sum = get(1, 1, N, 1, num-1);
			right[i] = sum;
			update(1, 1, N, num);
		}
		
		for(int i=2; i< N; i++)
		{
			long tmp = (long)left[i]*(long)right[i];
			result += tmp;
		}
		bw.write(result+"\n");
		bw.flush();
	}
	public static int get(int node, int start, int end, int i, int j)
	{
		int mid = (start + end) >> 1;
		if(end < i || j < start) return 0;
		else if(i <= start && end <= j) return tree[node];
		else return get(node*2, start, mid, i, j) + get(node*2+1, mid+1, end, i, j);
	}
	public static void update(int node, int start, int end, int index)
	{
		if(index < start || end < index) return;
		tree[node] += 1;
		if(start == end) return;
		int mid = (start + end) >> 1;
		update(node*2, start, mid, index);
		update(node*2+1, mid+1, end, index);
	}
}
