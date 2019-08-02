package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 수열과 쿼리 6
 */
public class baek13548 {

	static int N, K, sqrtN;
	static Node[] q = new Node[100005];
	static int[] result = new int[100005];
	static int[] ans = new int[100005];
	static int[] data = new int[100005];
	static HashSet<Integer> set = new HashSet<>();
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
		int dx =0, dy =0;
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
		int maxCnt = 0, maxAns = 0;
		
		for(int i=start; i<= end; i++)
		{
			result[data[i]]++;
			if(result[data[i]] > maxAns)
			{
				maxAns = result[data[i]];
				maxCnt = 1;
			}
			else if(result[data[i]] == maxAns) 
			{
				maxCnt++;
			}
		}
		if(maxAns == 0) maxAns += 1;
		ans[q[1].index] = maxAns;
		
		for(int i=2; i<= K; i++)
		{
			int curStart = q[i].left;
			int curEnd = q[i].right;
			
			while(curStart < start) {
				start--;
				result[data[start]]++;
				if(result[data[start]] > maxAns) {
					maxAns = result[data[start]];
					maxCnt=1;
				}
				else if(result[data[start]] == maxAns) {
					maxCnt++;
				}
			}
			while(curStart > start) {
				if(result[data[start]] == maxAns) {
					maxCnt--;
				}
				result[data[start]]--;
				if(maxCnt == 0) {
					maxCnt = 1;
					maxAns = result[data[start]]; 
				}
				start++;
			}
			while(curEnd < end) {
				if(result[data[end]] == maxAns) {
					maxCnt--;
				}
				result[data[end]]--;
				if(maxCnt ==0) {
					maxCnt = 1;
					maxAns = result[data[end]];
				}
				end--;
			}
			while(curEnd > end) { 
				end++;
				result[data[end]]++;
				if(result[data[end]] > maxAns) {
					maxAns = result[data[end]];
					maxCnt = 1;
				}
				else if(result[data[end]] == maxAns) {
					maxCnt++;
				}
			}
			
			if(maxAns == 0) maxAns += 1;
			ans[q[i].index] = maxAns;
		}
		for(int i=1; i<= N; i++)
		{
			System.out.print(result[i]+" ");
		}
		System.out.println();
		
		for(int i=1; i<= K; i++)
		{
			bw.write(ans[i]+"\n");
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
			left=a; right=b; index=c;
		}
	}
}


/**
7
1 2 2 2 4 4 4
3
1 3
5 6
5 7
 */
