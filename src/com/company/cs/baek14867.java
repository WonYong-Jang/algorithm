package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 물통 
 */
public class baek14867 {

	static int maxDx, maxDy, edx, edy;
	static HashMap<Node, Long> map = new HashMap<>();
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		maxDx = Integer.parseInt(st.nextToken());
		maxDy = Integer.parseInt(st.nextToken());
		edx = Integer.parseInt(st.nextToken());
		edy = Integer.parseInt(st.nextToken());
		
		Node start = new Node(0, 0, 0);
		map.put(start, (long)0);
		
		que.add(start);
		
		
		int count = 0;
		long result = -1;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			count++;
			if(count == 100) break;
			
			if(n.dx == edx && n.dy == edy)
			{
				result = n.cnt;
				break;
			}
			
			long rCnt = n.cnt+1, num =0; 
			int rdx = 0, rdy = 0;
			Node next;
			
			// dx empty
			rdx = 0;
			rdy = n.dy;
			next = new Node(rdx, rdy, rCnt);
			if(map.get(next) != null)
			{
				num = map.get(next); 
				if(rCnt < num) {
					map.put(next, rCnt);
					que.add(next);
				}
				
			}
			else {
				que.add(next);
				map.put(next, rCnt);
			}
			
			// dy empty
			rdx = n.dx;
			rdy = 0;
			next = new Node(rdx, rdy, rCnt);
			if(map.get(next) != null)
			{
				num = map.get(next); 
				if(rCnt < num) {
					map.put(next, rCnt);
					que.add(next);
				}
			}
			else {
				que.add(next);
				map.put(next, rCnt);
			}
			
			// dx fill
			rdx = maxDx;
			rdy = n.dy;
			next = new Node(rdx, rdy, rCnt);
			if(map.get(next) != null)
			{
				num = map.get(next); 
				if(rCnt < num) {
					map.put(next, rCnt);
					que.add(next);
				}
			}
			else {
				que.add(next);
				map.put(next, rCnt);
			}
			// dy fill
			rdx = n.dx;
			rdy = maxDy;
			next = new Node(rdx, rdy, rCnt);
			if(map.get(next) != null)
			{
				num = map.get(next); 
				if(rCnt < num) {
					map.put(next, rCnt);
					que.add(next);
				}
			}
			else {
				que.add(next);
				map.put(next, rCnt);
			}
			
			int tempDx =0, tempDy =0, value = 0;
			// dx -> dy
			tempDx = n.dx; tempDy = n.dy;
			next = new Node(rdx, rdy, rCnt);
			if(tempDx + tempDy <= maxDy)
			{
				next.dx = 0;
				next.dy = tempDx + tempDy;
			}
			else {
				value = obs(tempDy, maxDy);
				next.dx = n.dx - value;
				next.dy = n.dy + value;
			}
			
			if(map.get(next) != null)
			{
				num = map.get(next); 
				if(rCnt < num) {
					map.put(next, rCnt);
					que.add(next);
				}
			}
			else {
				que.add(next);
				map.put(next, rCnt);
			}
			
			// dy -> dx
			tempDx = n.dx; tempDy = n.dy;
			next = new Node(rdx, rdy, rCnt);
			if(tempDx + tempDy <= maxDx)
			{
				next.dx = tempDx + tempDy;
				next.dy = 0;
			}
			else {
				value = obs(tempDx, maxDx);
				next.dx = n.dx + value;
				next.dy = n.dy - value;
			}
			
			if(map.get(next) != null)
			{
				num = map.get(next); 
				if(rCnt < num) {
					map.put(next, rCnt);
					que.add(next);
				}
			}
			else {
				que.add(next);
				map.put(next, rCnt);
			}
			
		}
		System.out.println(result);
	}
	static class Node {
		int dx, dy;
		long cnt;
		Node(int a, int b, long c) {
			dx=a; dy=b; cnt =c;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Node) {
				Node n = (Node)obj;
				if(dx == n.dx && dy == n.dy) return true;
			}
			return false;
		}
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Objects.hash(dx,dy);
		}
	}
	public static int obs(int a, int b) 
	{
		return a > b ? a - b : b - a;
	}
}
