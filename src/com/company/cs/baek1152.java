package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek1152 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;
		while(st.hasMoreElements())
		{
			st.nextToken();
			//System.out.println(st.nextToken());
			cnt++;
		}
		System.out.println(cnt);
	}

}
