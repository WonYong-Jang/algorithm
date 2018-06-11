package com.company.cs;

import java.util.Scanner;
/**
 *에라토스테네스 접근   알고리즘 이용  //1978번 소수 인지아닌지 판
 *
 
public class baek1978 {
	
	public static int N, count=0; 
	
	public static int isPrime(int value) { // 소수 판별 함수  
		if(value <= 1) return 0; // 1 이하수 소수 아님  
		
		for(int i=2; i * i <= value ; i++) // 루트 n 까지만 나누어서 떨어지면 소수가 아니다 
		{
			if(value % i ==0) return 0; //나누어 떨어지는 수 소수 아님  
		}
		return 1; //참  
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		int value =0;
		for(int k=0 ; k< N; k++ )
		{
			value = scanner.nextInt();
			
			int result = isPrime(value);
			
			if(result == 1) count++;
		}
		System.out.println(count);
	}
}
*/

/**
 *에라토스테네스 체 알고리즘 이용  //1929번 M 이상 N이하 소수를 출력 
 *
 */
public class baek1978 {
	
	public static int N;
	public static int[] arr = new int[1000001];
	public static int start, end;
	public static void isPrime() { // 소수 판별 함수  
		for(int i =2; i * i<= end; i++) {
			if( arr[i] == 0 ) continue;
			for(int j = i+i; j<= end; j+=i) {
				arr[j] =0;
			}
		}
	}
	public static void init() {
		for(int i = 2; i<=end; i++) {
			arr[i] =i;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		start = scanner.nextInt();
		end = scanner.nextInt();
		
		init();
		isPrime();
		
		for(int i=start;i<=end; i++) {
			if(arr[i] != 0) System.out.println(arr[i]);
		}
	}
}
