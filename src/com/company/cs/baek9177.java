package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baek9177 {

	static int N, len1, len2, len3;
	static String str1, str2, str3;
	static int[][] dp = new int[205][205];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int k=1; k<= N; k++)
		{
			st = new StringTokenizer(br.readLine());
			str1 = st.nextToken();
			str2 = st.nextToken();
			str3 = st.nextToken();
			len1 = str1.length();
			len2 = str2.length();
			len3 = str3.length();
			
			for(int i=0; i<= len1; i++)
				for(int j=0; j <= len2; j++)
					dp[i][j] = -1;
			
			int result = solve(0, 0, ' ');
			
			if(result == 1) bw.write("Data set "+k+": yes\n");
			else bw.write("Data set "+k+": no\n");
		}
		bw.flush();
	}
	public static int solve(int left, int right, char target)
	{
		int pos = left + right;
		
		if(pos > 0 && str3.charAt(pos-1) != target ) return 0;
		else if(pos == len3)
		{
			if(str3.charAt(pos-1) == target) return 1;
			else return 0;
		}
		else if(dp[left][right] != -1) return dp[left][right];
		else
		{
			int num = 0;
			if(left < len1) num = max(num, solve(left+1, right, str1.charAt(left)));
			if(right < len2) num = max(num, solve(left, right+1, str2.charAt(right)));
			
			return dp[left][right] = num;
		}
	}
	public static int max(int a, int b) { return a > b ? a: b; }
}







