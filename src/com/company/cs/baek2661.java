package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 좋은 수열 
 */
public class baek2661 {

	static String ans;
	static int N;
	static String[] data = new String[4];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		data[1] = "1"; data[2] = "2"; data[3] = "3";
		
		for(int i=1; i<= 3; i++)
		{
			dfs(data[i] , 1);
		}
		
	}
	public static void dfs(String result, int num)
	{
		if(num == N)
		{
			System.out.println(result);
			System.exit(0);
			return;
		}
		
		for(int i=1; i<=3; i++)
		{
			if(isPromising(result, data[i]))
			{
				dfs(result + data[i], num + 1);
			}
		}
	}
	public static boolean isPromising(String result, String target)
	{
		int sdx, edx, sdy, edy;
		String check = result + target;
		int len = check.length();
		
		edy = len;
		sdy = edx = len-1;
		sdx = len - 2;
		for(int i= 0; i < len/2; i++)
		{
			if(check.substring(sdx,edx).equals(check.substring(sdy,edy))) {
				return false;
			}
			sdy--; edx--; 
			sdx -= 2;
		}
		
		
		return true;
	}
}









