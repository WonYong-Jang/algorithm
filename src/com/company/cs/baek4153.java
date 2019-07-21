package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 직각 삼각형 
 */
public class baek4153 {

	static int[] d = new int[3];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			d[0] = Integer.parseInt(st.nextToken());
			d[1] = Integer.parseInt(st.nextToken());
			d[2] = Integer.parseInt(st.nextToken());
			
			if(d[0] == 0 && d[1] == 0 && d[2] ==0) break;
			
			Arrays.sort(d, 0, 3);
			
			if( (d[0]*d[0]) + (d[1]*d[1]) == (d[2]*d[2]) )
			{
				bw.write("right\n");
			}
			else bw.write("wrong\n");
		}
		bw.flush();
	}

}
