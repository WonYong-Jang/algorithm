package com.company.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 점심 식사 시간 
 */
public class swExpert2383 {

	static int N, ans;
	static ArrayList<Node> person = new ArrayList<>();
	static ArrayList<Node> stair = new ArrayList<>(); // 계단 길이 정보 
	static int[][] map = new int[12][12];
	static int[] arr0 = new int[12]; // 0번 계단 가는 경우 
	static int[] arr1 = new int[12]; // 1번 계단 가는 경우 
	static int cnt0, cnt1, dis;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			int temp =0;
			person.clear(); stair.clear(); ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= N; j++)
				{
					temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
					if(temp == 1) { // 사람 인경우 
						person.add(new Node(i,j, 0));
					}
					else if(temp >= 2) { // 께단 
						stair.add(new Node( i, j, map[i][j])); // 길이 정보 0번계단, 1번 계단 
					}
				}
			}
			selectDir();
			bw.write("#"+k+" "+ans+"\n");
		}
		bw.flush();
	}
	public static void selectDir()
	{
		int len = person.size();
		for(int i=0; i< (1<<len) ; i++)
		{
			cnt0=0; cnt1=0; dis=0; 
			for(int j=0; j< len; j++)
			{
				if( (i & (1<<j)) >0 ) // 1번 계단 
				{
					dis = distance(j, 1);
					arr1[cnt1++] = dis;
				}
				else { // 0번 계단 
					dis = distance(j, 0);
					arr0[cnt0++] = dis;
				}
			}
			Arrays.sort(arr0, 0, cnt0);
			Arrays.sort(arr1, 0, cnt1);
			solve();
		}
	}
	public static void solve()
	{
		boolean flag0 = false, flag1 = false;
		int min =0;
		int[] check = new int[2]; // 3명 체크 배열 
		int target0 = -1*(stair.get(0).len+1); 
		int target1 = -1*(stair.get(1).len+1);
		//System.out.println(target0+" "+target1);
		while(true)
		{
			if(flag0 == true && flag1 == true) break;
			flag0 = true; flag1 = true;
			min++;
			for(int i=0; i< cnt0; i++) // 0번 계단 체크 
			{
				if(arr0[i] == target0) continue; // 목표점에 이미 도달해 있는 경우  
				if(arr0[i] == 0) {
					if( check[0] >= 3) continue; // 꽉찬 경우 
					else check[0]++; // 가능 한경우 
				}
				
				if(arr0[i] - 1 == target0) check[0]--;
				arr0[i]--;
				if(arr0[i] != target0) flag0 = false; // 하나라도 목표점에 도달 하지 못했을 경우
			}
			
			for(int i=0; i< cnt1; i++) // 1번 계단 체크 
			{
				if(arr1[i] == target1) continue; // 목표점에 이미 도달해 있는 경우  
				if(arr1[i] == 0) {
					if( check[1] >= 3) continue;
					else check[1]++;  // 가능 한경우 
				}
				
				if(arr1[i] - 1 == target1) check[1]--;
				arr1[i]--;
				
				if(arr1[i] != target1) flag1 = false; // 하나라도 목표점에 도달 하지 못했을 경우
			}
		}
		ans = min(ans, min);
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	public static int distance(int index, int target) // 사람에서 계단까지 거리 구하기 
	{
		int sdx = person.get(index).dx;
		int sdy = person.get(index).dy;
		int edx = stair.get(target).dx;
		int edy = stair.get(target).dy;
		return (sdx > edx ? sdx - edx : edx - sdx ) + ( sdy > edy ? sdy - edy : edy - sdy);
	}
	static class Node {
		int dx, dy, len;
		Node(int x, int y, int z) {
			dx = x; dy = y; len = z; 
		}
	}
}
