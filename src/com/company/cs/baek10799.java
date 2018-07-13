package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 쇠막대기 
 */
public class baek10799 {

	static int result =0, len;
	static Stack<Character> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		len = str.length();
		
		for(int i=0; i< len; i++)
		{
			if(str.charAt(i) == '(') stack.push(str.charAt(i));
			else // ' ) '  닫는 괄호가 나왔을 때 
			{
				stack.pop();
				if(str.charAt(i-1) == '(') // 레이저 모양
				{
					result += stack.size();
				}
				else if(str.charAt(i-1) == ')')
				{
					result++;
				}
			}
		}
		
		System.out.println(result);
	}

}
