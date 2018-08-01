package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 에라토스테네스의 체 ( 효율적인 소수 구하기 ) 
 */
public class baek2960 {

	static int N, K;
	static int[] map = new int[1005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i=2; i<= N; i++)
		{
			map[i] = i;
		}
		int index = 0;
		for(int i=2; i <= N; i++)
		{
			if(map[i] == 0) continue; // 거른 값들 
			int prime = i;
			index++; // 소수 값 카우트 
			if(index == K) {
				System.out.println(map[i]);
				break;
			}
			for(int j= i; j<= N; j += i)
			{
				if(map[j] ==0 ) continue;
				if(map[j] != prime )
				{
					index++;
					if(index == K) {
						System.out.println(map[j]);
						break;
					}
					map[j] = 0;
				}
			}
		}
		
	}

}
