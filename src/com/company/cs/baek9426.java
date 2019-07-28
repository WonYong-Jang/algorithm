package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 중앙값 (세그먼트 트리 )
 */
public class baek9426 {

	static final int max_node = 66000;
	static int N, K, e, middle;
	static int[] data = new int[250005];
	static int[] tree = new int[4*max_node];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int num = 0;
		e = 65535; middle = (K+1)/2;
		long sum = 0;
		int count=1;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			data[i] = num;
			set(1, 0, e, num, 1);
			
			if(tree[1] >= K)
			{
				int result = get(1, 0, e, middle);
				sum += (long)result;
				set(1, 0, e, data[count], -1); // 지우기 
				count++;
			}	
		}
		bw.write(sum+"\n");
		bw.flush();
	}
	public static void set(int node, int start, int end, int index, int value)
	{
		if(index < start || end < index) return;
		tree[node]+= value;
		if(start == end) return;
		int mid = (start + end) / 2;
		set(node*2, start, mid, index, value);
		set(node*2+1, mid+1, end, index, value);
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
	
}

/**
22 7
4
3
9
5
3
6
0
2
8
4
7
9
3
8
5
7
5
9
8
3
1
1 
 */





