package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baek14413 {

	static final int max_value = 500001;
	static int N, Q, sqrtN;
	static Node[] data = new Node[max_value];
	static Node[] temp = new Node[max_value];
	static int[] result = new int[max_value]; // 같은 수 갯수 저장 배열 
	static Point[] q = new Point[max_value];
	static int[] ans = new int[max_value];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		sqrtN = (int)Math.sqrt(N);
		
		int dx = 0, dy = 0;
		for(int i=1; i<= N; i++)
		{
			dx = Integer.parseInt(st.nextToken());
			data[i] = new Node(dx, 1);
			temp[i] = new Node(dx, i);
		}
		for(int i=1; i<= Q; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			q[i] = new Point(dx,dy, i);
		}
		Arrays.sort(temp, 1, N+1, new mySort());
		Arrays.sort(q, 1, Q+1, new mosSort());
		int index = 1;
		data[temp[1].index].index = 1;
		for(int i=2; i<= N; i++) // 압축 
		{
			if(temp[i].num != temp[i-1].num)
			{
				data[temp[i].index].index = ++index;
			}
			else data[temp[i].index].index = index;
		}
		
		int cnt = 0;
		int start = q[1].left;
		int end = q[1].right;
		for(int i= start; i<= end; i++) // 처음 쿼리 직접 구하기 
		{
			if( result[data[i].index] == 2) // 이전에 2 였으면 카운트 감소  
			{
				cnt--;
			}
			result[data[i].index]++;
			if( result[data[i].index] == 2)
			{
				cnt++;
			}	
		}
		ans[q[1].index] = cnt;
		for(int i=2; i<= Q; i++)
		{
			int curStart = q[i].left;
			int curEnd = q[i].right;
			
			while(start < curStart) {
				if(result[data[start].index] == 2) cnt--;
				result[data[start].index]--;
				if(result[data[start].index] == 2) cnt++;
				start++;
			}
			while(start > curStart) {
				start--;
				if(result[data[start].index] == 2) cnt--;
				result[data[start].index]++;
				if(result[data[start].index] == 2) cnt++;
			}
			while(end < curEnd) {
				end++;
				if(result[data[end].index] == 2) cnt--;
				result[data[end].index]++;
				if(result[data[end].index] == 2) cnt++;
			}
			while(end > curEnd) {
				if(result[data[end].index] == 2) cnt--;
				result[data[end].index]--;
				if(result[data[end].index] == 2) cnt++;
				end--;
			}
			ans[q[i].index] = cnt;
		}
		for(int i=1; i<= Q; i++)
		{
			bw.write(ans[i]+"\n");
		}
		bw.flush();
	}
	static class mosSort implements Comparator<Point> {
		@Override
		public int compare(Point a, Point b) {
			int aa = a.left/sqrtN;
			int bb = b.left/sqrtN;
			if(aa < bb) return -1;
			else if(aa > bb) return 1;
			else
			{
				if(a.right < b.right) return -1;
				else if(a.right > b.right) return 1;
				else return 0;
			}
		}
	}
	static class mySort implements Comparator<Node> {
		@Override
		public int compare(Node a, Node b) {
			if(a.num < b.num) return -1;
			else if(a.num > b.num) return 1;
			else return 0;
		}
	}
	static class Point {
		int left, right, index;
		Point(int a, int b, int c) {
			left=a; right=b; index = c;
		}
	}
	static class Node {
		int num, index;
		Node(int a, int b) {
			num = a; index = b;
		}
	}
}
