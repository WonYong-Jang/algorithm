package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 점심 식사 시간 
 */
public class swExpert2383 {

	static int N;
	static int[][] map = new int[12][12];
	static ArrayList<Person> person = new ArrayList<>();
	static ArrayList<Stair> stair = new ArrayList<>(); // 각각 0, 1번 계단  
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		int temp =0;
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			person.clear(); stair.clear(); // 초기화 
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= N; j++)
				{
					temp = Integer.parseInt(st.nextToken());
					if(temp == 1) { // 사람 인경우 
						person.add(new Person(i, j, 0, 0));
					}
					else if(temp > 1) { // 계단 위치 정보 
						stair.add(new Stair(i, j, map[i][j]));
					}
				}
			}
			selectDir(); // 사람마다 2개의 계단 중 갈수 있는 계단 선택 
		}
	}
	public static void selectDir() 
	{
		int len = person.size();
		
		for(int i=0; i < (1 << len) ; i++) // 비트 마스킹으로 부분집합 경우의 수 
		{
			for(int j=0; j< len ; j++)
			{
				if( (i & (1<<j)) > 0 ) { // 1번 계단 선택 
					person.get(j).dir = 1;
					person.get(j).dis = distance(j, 1);
				}
				else { // 0 번 계단 선택 
					person.get(j).dir = 0;
					person.get(j).dis = distance(j, 0);
				}
			}
			solve(); // 사람마다 갈 계단 방향이 정해졌으므로 시간 계산 
		}
	}
	public static void solve()
	{
		int len = person.size();
		int[] check = new int[2]; // 각 계단 별 내려가고 있는 인원 체크 3명
		ArrayList<Person> wait = new ArrayList<>(); // 계단 내려갈 인원 
		int min = 0;
		while(len > 0)
		{
			min++; // 시간 증가 
			for(int i=0; i< len; i++)
			{
				if(person.get(i).dis == min) // 계단 도착 한 경우 !
				{
					int dir = person.get(i).dir;
					person.get(i).dis = stair.get(dir).len;
					wait.add(person.get(i)); // 
					person.remove(i);
				}
			}
		}
	}
	public static int distance(int index, int target) // 계단 까지 거리 구하기 
	{
		int sdx = person.get(index).dx;
		int sdy = person.get(index).dy;
		int edx = stair.get(target).dx;
		int edy = stair.get(target).dy;
		return (sdx > edx ? sdx - edx : edx - sdx ) + (sdy > edy ? sdy - edy : edy - sdy);
	}
	static class Person {
		int dx, dy, dir, dis;
		Person(int a, int b, int c, int d) {
			dx = a; dy = b; dir = c; dis =d;
		}
	}
	static class Stair {
		int dx, dy, len;
		Stair(int x, int y, int z) {
			dx = x; dy = y; len = z;
		}
	}
}
