package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * CCW
 */
public class baek11758 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int dx = 0, dy =0;
		Node[] point = new Node[3];
		for(int i=0; i < 3; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			point[i] = new Node(dx,dy);
		}
		System.out.println(ccw(point[0], point[1], point[2]));
	}
	public static int ccw(Node a, Node b, Node c)
	{
		int op = ((a.dx*b.dy) + (b.dx*c.dy) + (c.dx*a.dy)) - ((a.dy*b.dx) + (b.dy*c.dx) + (c.dy*a.dx));
		if(op > 0) return 1;
		else if(op < 0) return -1;
		else return 0;
	}
	static class Node {
		int dx, dy;
		Node(int a, int b) { 
			dx=a; dy=b;
		}
	}
}
