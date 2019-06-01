package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 쿼드 트리 
 */
public class baek1992 {

	static int N;
	static char[][] data = new char[100][100];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		String str = "";
		for(int i=1; i<= N; i++)
		{
			str = br.readLine();
			for(int j=1; j<= N; j++)
			{
				data[i][j] = str.charAt(j-1);
			}
		}
		
		System.out.println(solve(N, N, N));
		
	}
	public static String solve(int dx, int dy, int len)
	{
		int mid = len / 2;
		
		if(len == 1) return Character.toString(data[dx][dy]);
		
		String num1 = solve(dx-mid, dy-mid, mid);
		String num2 = solve(dx-mid, dy, mid);
		String num3 = solve(dx, dy-mid, mid);
		String num4 = solve(dx, dy, mid);
		
		if(num1.equals("0")  && num2.equals("0") && num3.equals("0") && num4.equals("0")) return "0";
		else if(num1.equals("1") && num2.equals("1") && num3.equals("1") && num4.equals("1")) return "1";
		else 
		{
			String result = "(";
			result += num1;
			result += num2;
			result += num3;
			result += num4;
			result += ")";
			return result;
		}
		
	}
}







