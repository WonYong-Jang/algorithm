package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 합이 0인 네 정수 
 */
public class baek7453 {

	static final int max_node = 4001*4002;
	static int N, left, right;
	static long result;
	static int[][] data = new int[4005][5];
	static int[] A = new int[max_node];
	static int[] B = new int[max_node];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= 4; j++)
			{
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result = 0;
		int index = 1;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				A[index] = data[i][1] + data[j][2];
				B[index] = data[i][3] + data[j][4];
				index++;
			}
		}
		Arrays.sort(A, 1, index);
		Arrays.sort(B, 1, index);
		left = 1; right = index-1;
		N = index -1;
		
		int sum = 0, temp =0;
		int cntA=0, cntB =0;
		while(left <= N && right >= 1)
		{
			sum = A[left] + B[right];
			if(sum == 0 )
			{
				cntA=0; cntB =0;
				temp = A[left];
				while(left <= N && temp == A[left]) {
					left++;
					cntA++;
				}
				
				temp = B[right];
				while(right >= 1 && temp == B[right]) {
					right--;
					cntB++;
				}
				
				result += (long)cntA*cntB;
			}
			else if( sum > 0) {
				temp = B[right];
				while(right >= 1 && temp == B[right]) right--;
			}
			else if( sum < 0) {
				temp = A[left];
				while(left <= N && temp == A[left]) left++;
			}
		}
		System.out.println(result);
	}
	
}
