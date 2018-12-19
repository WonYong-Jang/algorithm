package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 닉네임에 갓 붙이기 
 */
public class baek13163 {

	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int num = 0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			num = 0;
			bw.write("god");
			while(st.hasMoreTokens())
			{
				if(num == 0 ) 
				{
					num++;
					st.nextToken();
					continue;
				}
				else 
				{
					bw.write(st.nextToken());
					num++;
				}
			}
			bw.write("\n");
		}
		bw.flush();
	}
}