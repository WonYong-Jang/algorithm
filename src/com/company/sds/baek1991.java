package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 트리 순회 ( preorder, inorder, postorder ) 
 */
public class baek1991 {

	static Character[] tree = new Character[27]; // 1 ~ 26 
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int index =1;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=3; j++) // 입력 다시 ! 
			{
				tree[index++] = st.nextToken().charAt(0);
			}
		}
		//for(int i=1; i<=)
		//preorder(1);
	}
	public static void preorder(int index)
	{
		if(tree[index].equals('.')) return;
		else 
		{
			System.out.print(tree[index]+" "+index);
			if(index*2 <= 26) preorder(index*2);
			if(index*2+1 <= 26) preorder(index*2+1);
		}
	}
}
