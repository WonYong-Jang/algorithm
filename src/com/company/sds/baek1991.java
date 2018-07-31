package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 트리 순회 ( preorder, inorder, postorder ) 수정 할 것 
 */
public class baek1991 {

	static Character[] tree = new Character[27]; // 1 ~ 26
	
	static int[] visited = new int[27]; // 전부 
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= 26; i++) // init
		{
			tree[i] = '.';
		}
		
		int index =1;
		char root, left, right;
		tree[1] = 'A'; // 루트 노드 설정 
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			root = st.nextToken().charAt(0);
			left = st.nextToken().charAt(0);
			right = st.nextToken().charAt(0);
			for(int j=1; j<= 26; j++)
			{
				if(tree[j] == root) 
				{
					if(j*2 <= 26) tree[j*2] = left;
					if(j*2+1 <= 26) tree[j*2+1] = right;
					break;
				}
			}
		}
		for(int i=1; i<= 26; i++)
		{
			System.out.print(tree[i]+" ");
		}
		System.out.println();
		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);
	}
	public static void preorder(int index) // 전위 순회 
	{
		if(tree[index].equals('.')) return;
		else 
		{
			System.out.print(tree[index]);
			if(index*2 <= 26) preorder(index*2);
			if(index*2+1 <= 26) preorder(index*2+1);
		}
	}
	public static void inorder(int index) // 중위 순회  
	{
		if(tree[index].equals('.')) return;
		else 
		{
			if(index*2 <= 26) inorder(index*2);
			System.out.print(tree[index]);
			if(index*2+1 <= 26) inorder(index*2+1);
		}
	}
	public static void postorder(int index) // 후위 순회  
	{
		if(tree[index].equals('.')) return;
		else 
		{
			if(index*2 <= 26) postorder(index*2);
			if(index*2+1 <= 26) postorder(index*2+1);
			System.out.print(tree[index]);
		}
	}
}
