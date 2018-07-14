package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 네 수 
 */
public class baek10824 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str1 = st.nextToken();
		String str2 = st.nextToken();
		String str3 = st.nextToken();
		String str4 = st.nextToken();
		long num1 = Long.parseLong(str1+str2);
		long num2 = Long.parseLong(str3+str4);
		System.out.println(num1+num2);
	}

}
