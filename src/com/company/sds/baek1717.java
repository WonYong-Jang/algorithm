package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 집합의 표현 ( union , find 개념 !! ) ( Disjoint - set)
 */
public class baek1717 {

	static int[] parent = new int[1000001]; // 해당 노드의 부모노드를 설정해놔서 집합을 만든다  
	static int N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int a,b,c;
		for(int i=0; i<= N; i++)
		{
			parent[i] = i;
		}
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(a ==0) { // 합집합 
				union(b,c);
			}
			else { // 1 이면 
				if(find(b) == find(c)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
	// 합집합 / 단, 각 집합에서 대표하는 값을 하나로만 설정해두고 해당 집합의 값을 찾았을때 모두 대표하는 값을 가르키게 설정 !
	public static void union(int a, int b)
	{
		int ap = find(a);  // a , b 각각 대표하는 값을 찾는다  
		int bp = find(b);
		parent[ap] = bp; // 대표값을 하나로 맞춰서 설정하는 과정 parent[bp] = ap 도 가능 
	}
	public static int find(int a)
	{
		if(parent[a] == a) return a;
		else return parent[a] = find(parent[a]); 
		// 중요 : 시간을 줄여주기 위해 찾게 되는 find 대표값을 지나온 값에 넣어주면서 리턴하게 되면
		// 추후에 다시 find 검색할때 여러 노드를 거치지 않고 바로 대표값으로 이동할수 있어 시간을 줄일수 있음 
	}
}
