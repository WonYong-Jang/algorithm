package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

/**
 * OX퀴즈 
 */
public class baek8958 {

	static int N, len;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		String str = "";
		int sum = 0, multi = 0;
		for(int i=1; i<= N; i++)
		{
			sum = 0; multi = 0;
			str = br.readLine();
			len = str.length();
			char target = ' ';
			for(int j=0; j< len; j++)
			{
				target = str.charAt(j);
				if(target == 'O')
				{
					multi++;
					sum += multi;
				}
				else 
				{
					multi = 0;
				}
			}
			bw.write(sum+"\n");
		}
		bw.flush();
	}

}
