package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Permutation 순열 / 백준 10974번 
 */
public class Permutation {

	static int N;
	static PriorityQueue<Integer> que = new PriorityQueue<>();
	static Stack<Integer> stack = new Stack<>();
	static int[] arr = new int[9]; // index 1 ~ 9 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=1; i<= N; i++)
		{
			arr[i] = i;
		}
		permutation(1);
		while(!que.isEmpty())
		{
			int value = que.poll();
			while(value > 0)
			{
				int temp = value % 10;
				stack.add(temp);
				value /= 10;
			}
			while(!stack.isEmpty())
			{
				System.out.print(stack.pop()+" ");
			}
			System.out.println();
		}
	}
	public static void permutation(int depth) // 순열 
	{
		if(depth == N)
		{
			int temp =0, digit = 1;
			for(int i=N; i >= 1; i--)
			{
				temp += arr[i] * digit;
				digit *= 10;
			}
			que.add(temp);
			return;
		}
		for(int i= depth; i<= N ;i++)
		{
			swap(depth, i);
			permutation(depth+1);
			swap(depth, i);
		}
	}
	public static void swap(int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
