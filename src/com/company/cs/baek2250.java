package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 트리의 높이와 너비 
 */
public class baek2250 {

	static int N, cnt, result, levelResult;
	static Node[] data = new Node[100005];
	static int[] order = new int[100005];
	static Queue<Integer> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		cnt = 1; result =0; levelResult =0;
		int num=0, dx=0, dy=0;
		int root =0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			if(i == 1) root = num;
			data[num] = new Node(num);
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			data[num].left = dx;
			data[num].right = dy;
		}
		
		inorder(root);
		
		levelOrder(root); // 레벨 순회 
		System.out.println(levelResult + " " + result);
	}
	public static void levelOrder(int num)
	{
		que.add(num);
		int level = 0;
		while(!que.isEmpty())
		{
			int len = que.size();
			level++;
			int start = 10005, end = -1;
			
			for(int i=1; i<= len; i++)
			{
				int n = que.poll();
				
				start = min(start, order[n]);
				end = max(end, order[n]);
				
				if(i == len) 
				{
					if(result < end - start + 1)
					{
						result = end - start + 1;
						levelResult = level;
					}
				}
				
				if(data[n].left != -1) que.add(data[n].left);
				
				if(data[n].right != -1) que.add(data[n].right);
			}
		}
	}
	public static void inorder(int cur) // 중위 연산 
	{
		if(data[cur].index != -1)
		{
			if(data[cur].left != -1) inorder(data[cur].left);
			order[data[cur].index] = cnt++;
			if(data[cur].right != -1) inorder(data[cur].right);
		}
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	static class Node {
		int index;
		int left, right;
		Node(int a) {
			index = a;
			
		}
	}
}
/**
3
1 2 -1
2 3 -1
3 -1 -1
 */


