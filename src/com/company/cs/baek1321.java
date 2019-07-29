package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 군인 
 */
public class baek1321 {

	static final int max_node = 500001;
	static int N, K;
	static int[] data = new int[max_node];
	static int[] tree = new int[4*max_node];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		init(1, 1, N);
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		int cmd = 0, dx = 0, dy = 0;
		for(int i=1; i<= K; i++)
		{
			st = new StringTokenizer(br.readLine());
			cmd = Integer.parseInt(st.nextToken());
			dx = Integer.parseInt(st.nextToken());
			if(cmd == 1)
			{
				dy = Integer.parseInt(st.nextToken());
				update(1, 1, N, dx, dy);
			}
			else
			{
				int num = get(1, 1, N, dx);
				bw.write(num+"\n");
			}
		}
		bw.flush();
	}
	public static int get(int node, int start, int end, int target)
	{
		if(start == end) return start;
		int mid = (start + end) / 2;
		if(tree[node*2] >= target)
		{
			return get(node*2, start, mid, target);
		}
		else
		{
			return get(node*2+1, mid+1, end, target - tree[node*2]);
		}
	}
	public static void update(int node, int start, int end, int index ,int num)
	{
		if(index < start || end < index) return;
		tree[node] += num;
		if(start == end) return;
		int mid = (start + end ) / 2;
		update(node*2, start, mid, index, num);
		update(node*2+1, mid+1, end, index, num);
	}
	public static int init(int node, int start, int end)
	{
		int mid = (start + end) / 2;
		if(start == end ) return tree[node] = data[start];
		return tree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
	}
}
