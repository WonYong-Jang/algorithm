package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 괄호의 값 
 */
public class baek2504 {

	static int result, len, mul;
	static Stack<Character> st = new Stack<>();
	static char[] arr = new char[40];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result =0; len =0; mul = 1;
		String str = br.readLine();
		len = str.length();
		for(int i=1; i<= len; i++)
		{
			arr[i] = str.charAt(i-1);
		}
		
		for(int i=1; i<= len; i++)
		{
			if(arr[i] == '(') {
				st.push(arr[i]);
				mul *= 2;
			}
			else if(arr[i] == '[') {
				st.push(arr[i]);
				mul *= 3;
			}
			else if(arr[i] == ')') {
				if(arr[i-1] == '(') result += mul;
				if(st.isEmpty()) {
					System.out.println(0); return;
				}
				if(st.peek() == '(') st.pop();
				mul /= 2;
			}
			else if(arr[i] == ']') {
				if(arr[i-1] == '[') result += mul;
				if(st.isEmpty()) {
					System.out.println(0); return;
				}
				if(st.peek() =='[') st.pop();
				mul /= 3;
			}
		}
		System.out.println(st.isEmpty() ? result : 0);
	}
}





