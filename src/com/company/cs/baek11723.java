package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 집합 
 */
public class baek11723 {

	static final int max_num = (1 << 20) - 1;
	static int N, target;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		target = 0;
		String cmd = "";
		int num = 0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			if(cmd.equals("add"))
			{
				num = Integer.parseInt(st.nextToken());
				target |= 1 << num-1;
			}
			else if(cmd.equals("check"))
			{
				num = Integer.parseInt(st.nextToken());
				num = 1 << num-1;
				if( (target & num) > 0) bw.write("1\n");
				else bw.write("0\n");
			}
			else if(cmd.equals("remove"))
			{
				num = Integer.parseInt(st.nextToken());
				num = 1 << num-1;
				target ^= num;
			}
			else if(cmd.equals("toggle"))
			{
				num = Integer.parseInt(st.nextToken());
				num = 1 << num-1;
				
				if((target & num) > 0) {
					
					target &= ~num;
				}
				else target |= num;
			}
			else if(cmd.equals("empty"))
			{
				target = 0;
			}
			else if(cmd.equals("all"))
			{
				target = max_num;
			}
		}
		bw.flush();
	}
}
