package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 최대, 최소 
 */
public class baek10818 {

	static final int max_node = 1000005;
	static int N, start, end;
	static int[] max_tree = new int[4*max_node];
	static int[] min_tree = new int[4*max_node];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		start = 1;
		while(N > start)
		{
			start *= 2;
		}
		end = start + N -1;
		
		st = new StringTokenizer(br.readLine());
		int num = 0;
		for(int i=start; i<= end; i++)
		{
			num = Integer.parseInt(st.nextToken());
			max_tree[i] = num;
			min_tree[i] = num;
		}
		int left = 0, right =0;
		for(int i = end/2; i >= 1; i--)
		{
			left = max_tree[i*2] == 0 ? -1*max_node : max_tree[i*2];
			right = max_tree[i*2+1] == 0 ? -1*max_node : max_tree[i*2+1];
			max_tree[i] = max(left, right);
			
			left = min_tree[i*2] == 0 ? max_node : min_tree[i*2];
			right = min_tree[i*2+1] == 0 ? max_node : min_tree[i*2+1];
			min_tree[i] = min(left, right);
		}
		
		System.out.println(min_tree[1]+" "+max_tree[1]);
		
	}
	public static int max(int a, int b) { return a > b ? a : b; }
	public static int min(int a, int b) { return a > b ? b : a; }
}















