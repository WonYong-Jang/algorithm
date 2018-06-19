package com.company.etc;
/**
 * 쉬프트 연산자 기본 개념 연습  // 달이 차오른다 가자 문제 까지 풀기 ! 
 */
public class Shift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number =1; // 0000 0001
		System.out.println("원래 숫자 : "+ number); // 1 출력  
		
		number = number << 1; // 0000 0010
		System.out.println("왼쪽으로 1칸 쉬프트 : "+ number);// 2 출력  
		
		number = number << 2; // 0000 1000
		System.out.println("왼쪽으로 2칸 쉬프트 : "+ number);// 8 출력  
		
		number = number >> 1; // 0000 0100
		System.out.println("오른쪽으로 1칸 쉬프트 : "+ number);// 4출력  	
	}
}