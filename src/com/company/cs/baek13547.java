package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/** 
 * 수열과 쿼리  ( 모스 알고리즘 ) 
 */
public class baek13547 {

	static int sqrtN;
	static int N, K;
	static int[] result = new int[100005];
	static int[] data = new int[100005];
	static int[] number = new int[1000005];
	static ArrayList<Node> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		sqrtN = (int)Math.sqrt(N);
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		int dx = 0, dy = 0;
		for(int i=0; i< K; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			arr.add(new Node(dx, dy, i));
		}
		Collections.sort(arr, new mySort());
		int start = arr.get(0).start;
		int end = arr.get(0).end;
		int cnt = 0;
		for(int i=start; i<= end; i++)
		{
			if(number[data[i]] == 0) cnt++;
			number[data[i]]++;
		}
		result[arr.get(0).index] = cnt;
		
		for(int i = 1; i < K; i++)
		{
			while(arr.get(i).start > start ) {
				if(--number[data[start]] == 0) cnt--;
				start++;
			}
			while(arr.get(i).start < start) {
				start--;
				if(number[data[start]]++ == 0) cnt++;
			}
			while(arr.get(i).end > end) {
				end++;
				if(number[data[end]]++ == 0) cnt++;
			}
			while(arr.get(i).end < end) {
				if(--number[data[end]] == 0) cnt--;
				end--;
			}
			
			result[arr.get(i).index] = cnt;
		}
		
		for(int i=0; i< K; i++)
		{		
			bw.write(result[i]+"\n");
		}
		bw.flush();
	}
	static class mySort implements Comparator<Node> {
		@Override
		public int compare(Node a, Node b) {
			int aa = a.start/sqrtN;
			int bb = b.start/sqrtN;
			if(aa < bb) return -1;
			else if(aa > bb) return 1;
			else 
			{
				if(a.end < b.end) return -1;
				else if(a.end > b.end) return 1;
				else return 0;
			}
		}
	}
	static class Node {
		int start, end, index;
		Node(int a, int b, int c) { 
			start=a; end=b; index =c;
		}
	}
}
