package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class baek14954 {

	static int N;
	static HashSet<Integer> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int sum = 0;
		set.add(N);
		while(true)
		{
			sum = 0;
			while(N > 0)
			{
				sum += (N%10) * (N%10);
				N/=10;
			}
			if(sum == 1) {
				System.out.println("HAPPY");
				break;
			}
			else if(set.contains(sum)) {
				System.out.println("UNHAPPY");
				break;
			}
			else {
				N = sum;
				set.add(sum);
			}
		}
		
	}

}




