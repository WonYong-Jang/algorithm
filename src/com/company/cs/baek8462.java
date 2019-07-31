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
 * 부분 배열의 힘 
 */
public class baek8462 {

	static int N, K, sqrtN;
	static int[] data = new int[100005];
	static Node[] q = new Node[100005];
	static long[] cnt = new long[1000005];
	static long[] result = new long[1000005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sqrtN = (int)Math.sqrt(N);
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		int dx = 0, dy = 0;
		for(int i=1; i<= K; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			q[i] = new Node(dx, dy, i);
		}
		Arrays.sort(q, 1, K+1, new mySort());
		int start = q[1].left;
		int end = q[1].right;
		long sum = 0;
		for(int i= start; i<= end; i++)
		{
			sum -= (cnt[data[i]]*cnt[data[i]]*data[i]);
			cnt[data[i]]++;
			sum += (cnt[data[i]]*cnt[data[i]]*data[i]);
		}
		result[q[1].index] = sum;
		
		for(int i = 2; i<= K; i++)
		{
			int curStart = q[i].left;
			int curEnd = q[i].right;
			while(curStart < start) {
				start--;
				sum -= cnt[data[start]]*cnt[data[start]]*data[start];
				cnt[data[start]]++;
				sum += cnt[data[start]]*cnt[data[start]]*data[start];
			}
			while(curStart > start) {
				sum -= cnt[data[start]]*cnt[data[start]]*data[start];
				cnt[data[start]]--;
				sum += cnt[data[start]]*cnt[data[start]]*data[start];
				start++;
			}
			while(curEnd < end) {
				sum -= cnt[data[end]]*cnt[data[end]]*data[end];
				cnt[data[end]]--;
				sum += cnt[data[end]]*cnt[data[end]]*data[end];
				end--;
			}
			while(curEnd > end) {
				end++;
				sum -= cnt[data[end]]*cnt[data[end]]*data[end];
				cnt[data[end]]++;
				sum += cnt[data[end]]*cnt[data[end]]*data[end];
			}
			result[q[i].index] = sum;
		}
		
		for(int i=1; i<= K; i++)
		{
			bw.write(result[i]+"\n");
		}
		bw.flush();
	}
	static class mySort implements Comparator<Node> {
		@Override
		public int compare(Node a, Node b) {
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
	static class Node {
		int left, right, index;
		Node(int a, int b, int c) {
			left = a; right = b; index = c;
		}
	}
}
