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
					if(temp == 1) person.add(new Person(i, j, 0, 0, 0));
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
			System.out.println("#"+k+" "+ result);
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
		int[] stairs = new int[2]; // 1, 2 번 계단 
		que.addAll(person);
		int curMin =0;
		//System.out.println(">>>>>>>>>>>>>>>>>>>>>");
		while(!que.isEmpty()) 
		{
			Person p = que.poll();
			int curDis = p.curDis; // 계단 입구까지 남은 거리
			int curFloor = p.curFloor;
			int target = p.target; //1, 2 번 계단 중 하나   
			int targetDis = p.targetDis;
			int targetFloor = map[node.get(target).dx][node.get(target).dy]; // 계단 층수 
			int flag = p.flag; // 1 : 계단 입구 도착 , 2 : 계단 내려가는 중 ! 
			curMin = Math.max(curMin, curDis);
			//System.out.println(curDis+" "+curFloor+" "+flag);
			if(flag ==2 ) // 계단 을 내려가고 있는 중 ! 
			{
				if(curFloor <= targetFloor) que.add(new Person(p.dx, p.dy, curDis+1, curFloor+1, targetFloor, target,flag));
				else stairs[target]--;
			}
			else if(flag == 1) // 계단 입구 도착 !  
			{
				if(stairs[target] < 3) { // 내려 갈수 있는 상태 
					que.add(new Person(p.dx, p.dy, curDis+1, 2, targetFloor, target, 2));
				}
				else { // 3명이 모두 차있는 상태  
					que.add(new Person(p.dx, p.dy, curDis+1, 1, targetFloor, target, flag));
				}
			}
			else {
				if(curDis < targetDis) {
					que.add(new Person(p.dx, p.dy, curDis+1, 0, targetDis, target, flag));
				}
				else {
					que.add(new Person(p.dx, p.dy, curDis+1, 0, targetDis, target, 1));
				}
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
	static class Person { // 사람 
		int dx, dy, curDis,curFloor, targetDis, target, flag; // 목표계단입구까지 거리, 계단 내려가고 있을때 현재 층 수 
		Person(int a, int b, int c, int d, int e) {
			dx =a; dy =b; curDis =c; curFloor=d; flag =e;
		}
		Person(int a, int b, int c, int d, int e, int f,int g) {
			dx =a; dy =b; curDis =c; curFloor=d; targetDis=e; target=f; flag=g;
		}
	}
	static class Node { // 계단  
		int dx, dy;
		Node(int x, int y) {
			dx=x; dy=y;
		}
	}
}
