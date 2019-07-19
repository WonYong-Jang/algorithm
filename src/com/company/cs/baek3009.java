package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek3009 {

	static Node[] p = new Node[1005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int dx = 0, dy = 0;
		for(int i=1; i<= 3; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			p[i] = new Node(dx, dy);
		}
		int rdx = 0, rdy = 0;
		for(int i=1; i<= 3; i++)
		{
			int xCnt = 0, yCnt = 0;
			for(int j=1; j<= 3; j++)
			{
				if(i == j) continue;
				if(p[i].dx == p[j].dx) xCnt++;
				if(p[i].dy == p[j].dy) yCnt++;
			}
			if(xCnt == 0) rdx = p[i].dx;
			if(yCnt == 0) rdy = p[i].dy;
		}
		System.out.println(rdx + " " + rdy);
	}
	static class Node {
		int dx, dy;
		Node(int a, int b) {
			dx=a; dy=b;
		}
	}
}
