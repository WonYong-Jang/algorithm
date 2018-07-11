package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
/**
 * 에디터  (링크드 리스트 집접 구현해 보기 !!!, )
 */
public class baek1406 {
	
	static LinkedList<Character> vec = new LinkedList<>();
	static char[][] cmdArr = new char[500001][2];
	static int len, cursor, cmd; // 문자 길이 ,  커서 , 명령  
	static String str;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		str = br.readLine();
		len = str.length();
		setting();
		cursor = len;
		cmd = Integer.parseInt(br.readLine());
		for(int i=0; i< cmd; i++) // cmd input 
		{
			st = new StringTokenizer(br.readLine());
			char temp = st.nextToken().charAt(0);
			cmdArr[i][0] = temp;
			if(temp == 'P') cmdArr[i][1] = st.nextToken().charAt(0);
			
			command(cmdArr[i][0], i);
		}
		for(char c : vec)
		{
			sb.append(c);
		}
		System.out.println(sb);
	}
	public static void command(char cmd, int index)
	{
		if(cmd == 'L')
		{
			if(cursor > 0) cursor--; // 왼쪽으로 한칸 옴김  
		}
		else if(cmd == 'D')
		{
			len = vec.size();
			if(cursor < len) cursor++; // 오른쪽으로 
		}
		else if(cmd == 'B')
		{
			if(cursor > 0) // 맨앞에 있지 않으면 
			{
				cursor--;
				vec.remove(cursor);
			}
		}
		else if(cmd == 'P')
		{
			vec.add(cursor, cmdArr[index][1]);
			cursor++;
		}
	}
	public static void setting()
	{
		for(int i=0; i<len ; i++)
		{
			vec.add(str.charAt(i));
		}
	}
}








