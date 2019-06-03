package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 정사각형 
 */
public class baek1485 {

	static long[][] point = new long[5][2];
	static long[] data = new long[7];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			long dx = 0, dy = 0;
			
			for(int i = 1; i <= 4; i++)
			{
				st = new StringTokenizer(br.readLine());
				dx = Long.parseLong(st.nextToken());
				dy = Long.parseLong(st.nextToken());
				point[i][0] = dx; point[i][1] = dy;
			}
			int index =0;
			for(int i=1; i< 4; i++)
			{
				for(int j= i+1; j<=4; j++)
				{
					long tmp = (point[i][0]-point[j][0])*(point[i][0]-point[j][0]) + (point[i][1]-point[j][1])*(point[i][1]-point[j][1]);
					data[index++] = tmp;
				}
			}
			
			Arrays.sort(data,0,6);
			
			if(data[0] == data[1] && data[1] == data[2] && data[2] == data[3]
					&& data[4] == data[5]) bw.write(1+"\n");
			else bw.write(0+"\n");
		}
		bw.flush();
	}
	
}


