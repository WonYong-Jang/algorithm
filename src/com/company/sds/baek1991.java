package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 트리 순회 ( preorder, inorder, postorder ) 
 */
public class baek1991 {
 
	static int N;
	static Node[] node = new Node[27]; // 1~ 26
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i< N; i++)
		{
			node[i+1] = new Node((char) ('A'+ i));
		}
		char p, l, r;
		int index;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			p = st.nextToken().charAt(0);
			l = st.nextToken().charAt(0);
			r = st.nextToken().charAt(0);
			
			index = p-'A'+1;
			if(l != '.')
			{
				node[index].parent = p-'A'+1;
				node[index].left = l-'A'+1;
			}
			if(r != '.')
			{
				node[index].parent = p-'A'+1;
				node[index].right = r-'A'+1;
			}
		}
		
		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);
	}
	public static void preorder(int idx)
	{
		System.out.print(node[idx].ch);
		if( node[idx].left != -1) preorder(node[idx].left);
		if( node[idx].right != -1) preorder(node[idx].right);
	}
	public static void inorder(int idx)
	{
		if( node[idx].left != -1) inorder(node[idx].left);
		System.out.print(node[idx].ch);
		if( node[idx].right != -1) inorder(node[idx].right);
	}
	public static void postorder(int idx)
	{
		if( node[idx].left != -1) postorder(node[idx].left);
		if( node[idx].right != -1) postorder(node[idx].right);
		System.out.print(node[idx].ch);
	}
	static class Node {
		char ch;
		int parent, left, right;
		Node(char ch) {
			this.ch = ch; 
			parent = left = right = -1;
		}
	}
}
