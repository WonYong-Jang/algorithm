package com.company.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek15954 {

	static int N, K;
	static double[] data = new double[505];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Double.parseDouble(st.nextToken());
		}
		
		double result = Double.MAX_VALUE;
		
		for(int i= K; i<= N; i++)
		{
			int start = 1, end = i;
			
			while(end <= N)
			{
				double m = average(start, end);
				double tmp = cal(start, end, m);
				result = min(result, tmp);
				
				start++;
				end++;
			}
		}
		
		System.out.println(result);
	}
	public static double cal(int start, int end, double avg)
	{
		double sum = 0;
		for(int i= start; i<= end; i++)
		{
			sum += (data[i]-avg)*(data[i]-avg);
		}
		sum = sum / (double)(end - start + 1);
		
		return Math.sqrt(sum);
	}
	public static double average(int start, int end)
	{
		double sum = 0;
		for(int i=start; i<= end; i++)
		{
			sum += data[i];
		}
		sum = sum / (double)(end-start+1);
		return sum;
	}
	public static double min(double a, double b) { return a > b ? b : a; }
}


