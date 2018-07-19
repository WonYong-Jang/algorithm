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
					if(temp == 1) person.add(new Person(i, j, 0, 0, 0, 0));
					else if(temp >= 2) node.add(new Node(i, j));
				}
			}
			/*
			lenPerson = person.size();
			for(int i=0; i< lenPerson; i++)
			{
				for(int j=0 ; j<2; j++)
				{
					dfs(i,j);
				}
			}*/
			person.clear();
			person.add(new Person(1,3,0,3,0,0));
			person.add(new Person(1,4,0,2,0,0));
			person.add(new Person(2,3,0,2,0,0));
			person.add(new Person(3,4,0,2,0,0));
			
			person.add(new Person(4,2,0,2,1,0));
			person.add(new Person(5,1,0,2,1,0));
			solve();
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
		int[] exit = new int[2]; // 1, 2 번 계단 
		que.addAll(person);
		int curMin =0;
		int exitNum =0;
		System.out.println(">>>>>>>>>>>>>>>>>>>>>");
		while(!que.isEmpty()) 
		{
			Person p = que.poll();
			curMin = Math.max(curMin, p.min);
			System.out.println("( "+p.dx+", "+p.dy+" ) / " +p.curDis + " -> "+p.targetDis +" / 시간 : "+p.min);
			if(p.dx == -1) { // 계단으로 내려가는 중 ! 
				if(p.curDis < p.targetDis) {
					System.out.println("계단 내려가는 중 ! ");
					que.add(new Person(-1,p.dy,p.curDis+1,p.targetDis,p.type,p.min+1));
				}
				if(p.curDis == p.targetDis) {
					System.out.println("계단 내려가는 것 완료  ! ");
					exit[p.type]--;
					continue;
				}
				
			}
			else { // 계단으로 진입 중 
				if(p.curDis < p.targetDis) { // 계단으로 이동 중 
					System.out.println("계단까지 이동 중   ! ");
					que.add(new Person(p.dx, p.dy, p.curDis+1, p.targetDis, p.type, p.min+1));
				}
				else if(p.curDis == p.targetDis) { // 계단 도착 
					if(exit[p.type] < 3) {
						System.out.println("계단입구 도착    ! ");
						que.add(new Person(-1, p.dy, 0, map[node.get(p.type).dx][node.get(p.type).dy], p.type, p.min+1));
						exit[p.type]++;
					}
					else { // 계단 3명 이하 일때까지 대기 
						System.out.println(" 꽉차서 대  기   ! ");
						que.add(new Person(p.dx, p.dy, p.curDis, p.targetDis, p.type, p.min+1));
					}
				}
			}
		}
		result = Math.min(result, curMin);
	}
	public static void setting(int index, int type) 
	{
		Person p = person.get(index);
		Node n = node.get(type);
		person.get(index).targetDis = Math.abs(p.dx- n.dx) + Math.abs(p.dy-n.dy); // 거리 계산 
		person.get(index).type = type; // 1 번 인지 2번 계단인지
	}
	public static void init() {
		result = Integer.MAX_VALUE;
		person.clear();
		node.clear();
	}
	static class Person { // 사람 
		int dx, dy, curDis, targetDis, type, min;  // 현재 거리, 목표 거리, 계단 종류 
		Person(int a, int b, int c, int d, int e, int f) {
			dx =a; dy =b; curDis =c; targetDis =d; type = e; min =f;
		}
	}
	static class Node { // 계단  
		int dx, dy;
		Node(int x, int y) {
			dx=x; dy=y;
		}
	}
}
