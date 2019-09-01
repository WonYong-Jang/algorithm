package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 상금 헌터 
 */
public class baek15953 {

	static int[][] data1 = new int[10][3];
	static int[][] data2 = new int[10][3];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		data1[1][1] = 500; data1[1][2] = 1;
		data1[2][1] = 300; data1[2][2] = 2;
		data1[3][1] = 200; data1[3][2] = 3;
		data1[4][1] = 50; data1[4][2] = 4;
		data1[5][1] = 30; data1[5][2] = 5;
		data1[6][1] = 10; data1[6][2] = 6;
		
		data2[1][1] = 512; data2[1][2] = 1;
		data2[2][1] = 256; data2[2][2] = 2;
		data2[3][1] = 128; data2[3][2] = 4;
		data2[4][1] = 64; data2[4][2] = 8;
		data2[5][1] = 32; data2[5][2] = 16;
		
		for(int k=1; k<= testCase; k++)
		{
			int num1 = 0, num2 = 0, a = 1 , b = 1, idx1 = 1, idx2 = 1, ans1=0, ans2 = 0;
			st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			
			while(idx1 <= 6)
			{
				if(num1 <= a && num1 != 0)
				{
					ans1 = data1[idx1][1];
					
					break;
				}
				idx1++;
				a += data1[idx1][2];
			}
			
			while(idx2 <= 5)
			{
				if(num2 <= b && num2 != 0)
				{
					ans2 = data2[idx2][1];
					
					break;
				}
				idx2++;
				b += data2[idx2][2];
			}
			
			int result = (ans1*10000) + (ans2*10000);
			bw.write(result+"\n");
		}
		bw.flush();
	}

}