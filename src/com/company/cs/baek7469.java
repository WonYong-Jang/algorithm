package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * k 번째 수 
 */
public class baek7469 {

	static int N, M;
	static Node[] data = new Node[100001];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= N; i++) data[i] = new Node(0,0);
		
		st = new StringTokenizer(br.readLine());
		int num = 0;
		for(int i=1; i<= N; i++)
		{
			num = Integer.parseInt(st.nextToken());
			data[i].num = num;
			data[i].idx = i;
		}
		Arrays.sort(data, 1, N+1, new mySort());
		
		int start =0, end =0, K =0;
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			search(start, end, K);
		}
	}
	public static void search(int s, int e, int tCnt)
	{
		int count = 0;
		for(int i=1; i<= N; i++)
		{
			if(data[i].idx >= s && data[i].idx <= e) count++;
			
			if(count == tCnt) {
				System.out.println(data[i].num);
				return;
			}
		}
	}
	static class mySort implements Comparator<Node>
	{
		@Override
		public int compare(Node a, Node b) {
			// TODO Auto-generated method stub
			if(a.num < b.num) return -1;
			else if(a.num > b.num) return 1;
			else return 0;
		}	
	}
	static class Node {
		int num, idx;
		Node(int a, int b) {
			num=a; idx =b;
		}
	}
}
