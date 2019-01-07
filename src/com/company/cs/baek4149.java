package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 셀프 넘버  
 */
public class baek4149 {

	static final int max_node = 10000;
	static int[] data = new int[max_node+1];
	static boolean[] self = new boolean[max_node+1];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = 0, sum = 0;
		for(int i= 1; i<= max_node; i++)
		{
			num = i;
			sum =0;
			while(num > 0)
			{
				sum = sum + (num % 10);
				num /= 10;
			}
			sum += i;
			if(sum > max_node) continue;
			self[sum] = true;
		}
		
		for(int i=1; i<= max_node; i++)
		{
			if(!self[i]) bw.write(i+"\n");
		}
		bw.flush();
	}
}




