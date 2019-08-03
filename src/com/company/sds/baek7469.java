package com.company.sds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * K번째 수 
 */
public class baek7469 {

	static final int max_value = 100005;
	static int N, K;
	static int[] data = new int[max_value];
	static ArrayList<Integer>[] tree = new ArrayList[4*max_value];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= N*4; i++)
		{
			tree[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
			update(1, 1, N, i, data[i]);
		}
		
		for(int i=1; i<= N*4; i++)
		{
			Collections.sort(tree[i]);
		}
		
		int left = 0, right = 0, k = 0;
		for(int i=1; i<= K; i++)
		{
			st = new StringTokenizer(br.readLine());
			left = Integer.parseInt(st.nextToken());
			right = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			int l = -(int)1e9;
			int r = (int)1e9;
			int mid = 0;
			
			while(l <= r)
			{
				mid = (l + r) / 2;
				
				if(get(1, 1, N, left, right, mid) < k) {
					l = mid + 1;
				}
				else {
					r = mid - 1;
				}
			}
			bw.write(l+"\n");
		}
		bw.flush();
	}
	public static int get(int node, int start, int end, int i, int j, int target)
	{
		int mid = (start + end) / 2;
		if(end < i || j < start) return 0;
		else if(i <= start && end <= j) {
			return upper_bound(node, target);
		}
		else return get(node*2, start, mid, i, j, target) + get(node*2+1, mid+1, end, i, j, target);
	}
	public static int upper_bound(int index, int target)
	{
		int mid = 0, s = 0, e = tree[index].size();
		
		while(s < e)
		{
			mid = (s + e) / 2;
			if(tree[index].get(mid) <= target) {
				s = mid + 1;
			}
			else {
				e = mid;
			}
		}
		return e;
	}
	public static void update(int node, int start, int end, int index, int num)
	{
		if(index < start || end < index) return;
		tree[node].add(num);
		if(start == end) return;
		int mid = ( start + end ) / 2;
		update(node*2, start, mid, index, num);
		update(node*2+1, mid+1, end, index, num);
	}
}

/*
7 3
1 5 2 6 3 7 4
2 5 3
4 4 1
1 7 3

7 1
1 5 2 6 3 7 4
2 5 3
 */
