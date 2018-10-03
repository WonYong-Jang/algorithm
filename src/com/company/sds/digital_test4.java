package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 3 개 숫자 조합 
 */
public class digital_test4 {

	static int[] visit = new int[21];
	static char[] output = new char[21];
	static ArrayList<Character> data = new ArrayList<>();
	static HashSet<String> set = new HashSet<>();
	static int target, len;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		data.clear();
		while(st.hasMoreTokens())
		{
			int temp = Integer.parseInt(st.nextToken());
			char value = convertFrom(temp);
			data.add(value);
		}
		
		st = new StringTokenizer(br.readLine());
		target = Integer.parseInt(st.nextToken());
		len = data.size();
		Collections.sort(data); // 정렬  
		
		for(int i=0; i< len; i++)
		{
			visit[i] = 1;
			dfs(i, 1);
			visit[i] = 0;
		}
		
		if(set.size() == 0 ) System.out.println("NO");
		else
		{
			ArrayList<String> list = new ArrayList<>(set);
			Collections.sort(list);
			for(String next : list)
			{
				for(int i =0 ; i<3; i++)
				{
					System.out.print(convertTo(next.charAt(i)) + " ");
				}
				System.out.println();
			}
		}
	}
	public static void dfs(int idx, int depth)
	{
		output[depth] = data.get(idx); 
		if(depth == 3)
		{
			int sum = 0;
			for(int i=1; i<= 3 ; i++)
			{
				sum += convertTo(output[i]); // 다 더해보기 
			}
			if(sum == target) // 조건 만족하면 
			{
				String tmp = "";
				for(int i=1; i<=3; i++)
				{
					tmp += output[i];
				}
				set.add(tmp);
			}
		}
		
		for(int i=idx+1; i< len; i++)
		{
			//if(visit[i] == 1) continue;
			visit[i] = 1;
			dfs(i, depth+1);
			visit[i] = 0;
		}
	}
	public static char convertFrom(int num) // 10 진수 에서 20 진수 
	{
		char result = (char)(num + '0');
		if(num >= 0 && num <= 9) return result;
		else // 10 이상 
		{
			int temp = num - 10;
			return (char)(temp + 'A');
		}
	}
	public static int convertTo(char str)
	{
		int result =0;
		
		if(str >= '0' && str <= '9') return str - '0';
		else {
			result = str - 'A' + 10;
			return result;
		}
	}
}






