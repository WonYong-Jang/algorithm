package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] dp = new int[100005];
	static int[] data = new int[100005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String str = "";
		while((str = br.readLine())!= null)
		{
			N = Integer.parseInt(str.trim());
       		st = new StringTokenizer(br.readLine().trim());
			for(int i=1; i<= N; i++)
			{
				data[i] = Integer.parseInt(st.nextToken());
				dp[i] = 0;
			}
			
			dp[1] = 0;
			int size = 0;
			for(int i=1; i<= N; i++)
			{
				if(dp[size] < data[i]) {
					dp[++size] = data[i];  
				}
				else {
					int idx = lower_bound(1,size+1, data[i]);
					dp[idx] = data[i];
				}
			}
			bw.write(size+"\n");
		}
		bw.flush();
	}
	public static int lower_bound(int s, int e, int target)
	{
		int mid = 0;
		
		while(s < e)
		{
			mid = (s + e) / 2;
			if(dp[mid] < target) {
				s = mid + 1;
			}
			else {
				e = mid;
			}
		}
		return e;
	}
	public static int max(int a, int b) { return a > b ? a : b ;}
}