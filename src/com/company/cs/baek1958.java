package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * LCS3 
 */
public class baek1958 {

	static String s, t, u;
	static int sLen, tLen, uLen;
	static int[][][] L = new int[105][105][105];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		t = br.readLine();
		u = br.readLine();
		sLen = s.length();
		tLen = t.length();
		uLen = u.length();
	
		for(int i=1; i<= sLen; i++)
		{
			for(int j=1; j<= tLen; j++)
			{
				for(int k=1; k<= uLen; k++)
				{
					if(s.charAt(i-1) == t.charAt(j-1) && t.charAt(j-1) == u.charAt(k-1))
					{
						L[i][j][k] = L[i-1][j-1][k-1] + 1;
					}
					else {
						L[i][j][k] = max(L[i-1][j][k], max(L[i][j-1][k],L[i][j][k-1]));
					}
				}
			}
		}
		System.out.println(L[sLen][tLen][uLen]);
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}
