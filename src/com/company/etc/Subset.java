package com.company.etc;
/**
 * 부분집합 구하기 (비트 연산자이용) 
 * 중요 : 1 << N   ===> 2^n    따라서 부분집합의 전체 갯수  
 */
public class Subset {
	
	public static int[] arr = {1,2,3};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = arr.length; // 배열 전체 길이  
		for(int i=0; i< (1 << N); i++) // 0 ~ 7 
		{
			for(int j=0; j < N; j++)
			{
				if( ( i&(1<<j) ) != 0 )
				{
					System.out.print(arr[j]+" ");
				}
			}
			System.out.println();
		}
	}
}
