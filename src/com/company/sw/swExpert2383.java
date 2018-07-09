package com.company.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 점심 식사 시간  
 *
 */
public class swExpert2383 {

	static int N, lenPerson, result;
	static int[][] map = new int[11][11]; // 전체 맵 
	static ArrayList<Person> person = new ArrayList<>(); // 사람 정보   
	static ArrayList<Node> node = new ArrayList<>(); // 계단 정보 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		int temp =0;
		for(int k=1; k<= testCase; k++)
		{
			N = Integer.parseInt(br.readLine());
			init();
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= N; j++)
				{
					temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
					if(temp == 1) person.add(new Person(i,j,0,0));
					else if(temp >= 2) node.add(new Node(i,j));
				}
			}
			lenPerson = person.size();
			for(int i=0; i< lenPerson; i++)
			{
				for(int j=0 ; j<2; j++)
				{
					dfs(i,j);
				}
			}
			System.out.println(result);
		}
	}
	public static void dfs(int index, int target) { // 해당 사람이 1, 2 계단중 선택  
		
		setting(index, target); // 해당 사람이 몇번 계단으로 갈지 셋 팅  
		
		if(index == lenPerson-1) {
			solve();
			return;
		}
		for(int i=index+1 ; i< lenPerson; i++)
		{
			for(int j=0 ; j<2; j++)
			{
				dfs(i,j);
			}
		}
	}
	public static void solve() 
	{
		Queue<Person> que = new LinkedList<>();
		que.addAll(person);
		int curMin =0;
		int[] stairs = new int[2]; // 1번 2번 계단 중 하나  
		System.out.println("start ! ");
		while(!que.isEmpty()) 
		{
			Person p = que.poll();
			int curDis = p.curDis;
			int curFloor = p.curFloor;
			int target = p.target; //1, 2 번 계단 중 하나   
			int targetDis = p.targetDis;
			int targetFloor = map[node.get(target).dx][node.get(target).dy];
			System.out.println(curDis+" "+targetDis+" "+curFloor+" "+target+" // ("+p.dx+" "+p.dy+") ");
			curMin = Math.max(curMin, curDis);
			if(target == -1) continue; // 무사히 계단을 빠져 나간 경우  
			
			if(curDis < targetDis) { // 계단 입구 까지 도착 하지 않은 경우  
				que.add(new Person(p.dx,p.dy,curDis+1, curFloor, targetDis, target));
			}
			else if(curDis >= target && curFloor < targetFloor) // 계단 입구 까지 도착 한경우 ==> 내려가고 있거나 대기 중이거나
			{
				if(stairs[target] <= 3) { // 내려 갈수 있는 경우 
					stairs[target]++;
					que.add(new Person(p.dx,p.dy,curDis+1, curFloor+1, targetDis, target));
				}
				else { // 대기 해야 하는 경우 
					que.add(new Person(p.dx,p.dy,curDis+1, curFloor, targetDis, target));
				}
			}
			else if(curDis >= target && curFloor == targetFloor) // 계단 도착 한 경우
			{
				que.add(new Person(p.dx,p.dy,curDis+1, curFloor, targetDis, -1));
				stairs[target]--;
			}
		}
		result = Math.min(result, curMin);
	}
	public static void setting(int index, int target) 
	{
		Person p = person.get(index);
		Node n = node.get(target);
		person.get(index).targetDis = Math.abs(p.dx- n.dx) + Math.abs(p.dy-n.dy); // 거리 계산 
		person.get(index).target = target; // 1 번 인지 2번 계단인지 
	}
	public static void init() {
		result = Integer.MAX_VALUE;
		person.clear();
		node.clear();
	}
	static class Person {
		int dx, dy, curDis, curFloor, targetDis, target; // 목표계단입구까지 거리, 계단 내려가고 있을때 현재 층 수
		Person(int a, int b, int c, int d) {
			dx =a; dy =b; curDis =c; curFloor =d;
		}
		Person(int a, int b, int c, int d, int e, int f) {
			dx =a; dy =b; curDis =c; curFloor =d; targetDis=e; target=f;
		}
	}
	static class Node {
		int dx, dy;
		Node(int x, int y) {
			dx=x; dy=y;
		}
	}
}
