package com.company.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 치킨 배달 
 */
public class baek15685 {

	static int N, M, len, ans;
	static int[][] map = new int[55][55];
	static ArrayList<Node> home = new ArrayList<>();
	static ArrayList<Node> chicken = new ArrayList<>();
	static ArrayList<Node> sel = new ArrayList<>(); // M 만큼 선택된 치킨 
	static int[] check = new int[15]; // 0 ~ 12  치킨 선택 확인 배열 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int temp =0;
		ans = Integer.MAX_VALUE;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= N; j++)
			{
				temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp == 1) home.add(new Node(i,j));
				else if(temp == 2) chicken.add(new Node(i,j));
			}
		}
		len = chicken.size(); // 전체 치킨집 사이즈 
		
		for(int i = 0; i< len; i++)
		{
			check[i] = 1;
			solve(i, 1);
			check[i] = 0;
		}
		System.out.println(ans);
	}
	public static void solve(int index ,int depth)
	{
		if(depth == M)
		{
			calculate();
			return;
		}
		for(int i = index + 1; i< len; i++)
		{
			if(check[i] == 1) continue;
			check[i] = 1;
			solve(i, depth+1);
			check[i] = 0;
		}
	}
	public static void calculate()
	{
		sel.clear();
		int sum =0, value = 0;
		for(int i=0; i<len; i++)
		{
			if(check[i] == 1) sel.add(chicken.get(i));
		}
		
		for(int i=0; i< home.size(); i++)
		{
			value = Integer.MAX_VALUE;
			for(int j=0; j< M; j++)
			{
				int temp = dis(i,j); // 치킨 까지 가장 거리 작은 값 
				value = min(temp, value);
			}
			sum += value; // 전체 합 
		}
		ans = min(ans, sum);
	}
	public static int dis(int i, int j) // 집에서 치킨까지 거리 구하기 a -> b 
	{
		int sdx = home.get(i).dx;
		int sdy = home.get(i).dy;
		int edx = sel.get(j).dx;
		int edy = sel.get(j).dy;
		return ( sdx > edx ? sdx - edx : edx - sdx ) + ( sdy > edy ? sdy - edy : edy - sdy ) ;
	}
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}
	static class Node {
		int dx, dy;
		Node(int x, int y) {
			dx = x; dy = y;
		}
	}
}
