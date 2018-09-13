package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 기차가 어둠을 헤치고 은하수를 
 */
public class baek15787 {

	static int N, M, maxValue;
	static int[] train = new int[100005];
	static HashSet<Integer> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maxValue = 1 << 20;
		
		int num = 0, cmd = 0 , target =0, temp=0;
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			cmd = Integer.parseInt(st.nextToken());
			if(cmd == 1) {
				num = Integer.parseInt(st.nextToken());
				target = Integer.parseInt(st.nextToken());
				train[num] |= 1 << (target-1); // 해당 자리 확인 
			}
			else if(cmd == 2) {
				num = Integer.parseInt(st.nextToken());
				target = Integer.parseInt(st.nextToken());
				temp = 1 << (target-1);
				if ( (train[num] & temp )  > 0 ) { // 자리에 탑승한 인원 확인되면 
					train[num] ^= temp; // xor 조건 이용해서 승객 내리게 하기 같으면 0을 출력하므로 
				}
				
			}
			else if(cmd == 3) { // << 연산자 
				num = Integer.parseInt(st.nextToken());
				temp = train[num] << 1;
				if(temp >= maxValue) {
					temp -= maxValue;
				}
				train[num] = temp;
			}
			else { // >> 연산자 
				num = Integer.parseInt(st.nextToken());
				train[num] = train[num] >> 1;
			}
		}
		for(int i=1; i<= N; i++)
		{
			set.add(train[i]);
		}
		System.out.println(set.size());
	}

}
