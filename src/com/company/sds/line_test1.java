package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class line_test1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 20000; // 현재 잔액 
		boolean flag = false;
		while(st.hasMoreTokens())
		{
			int target = Integer.parseInt(st.nextToken());
			
			if(target < 4 || target > 178) { // 범위 넘어 가게 되면 
				System.out.println(sum);
				break;
			}
			if(target < 40) { // 40 보다 작을 경우 기본요금만 냄 
				if(sum - 720 < 0) {
					System.out.println(sum);
					break;
				}
				sum -= 720;
			}
			else { // 40 보다 클 경우 
				if(sum - 720 < 0) {
					System.out.println(sum);
					break;
				}
				target -= 40;
				sum -= 720;
				while(target > 0)
				{
					if(sum - 80 < 0) {
						System.out.println(sum);
						flag =true;
						break;
					}
					sum -= 80;
					target -= 8;
				}
			}
			if(flag) break;
		}
		System.out.println(sum);
	}

}
