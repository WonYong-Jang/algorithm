package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
/**
 * 정렬  
 */
public class baek10825 {
	
	static int N;
	static ArrayList<Node> arr = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		String name;
		int kor, eng, math;
		for(int i=0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			name = st.nextToken();
			kor = Integer.parseInt(st.nextToken());
			eng = Integer.parseInt(st.nextToken());
			math = Integer.parseInt(st.nextToken());
			arr.add(new Node(name,kor,eng,math));
		}
		Collections.sort(arr, new Mysort());
		for(int i=0; i< arr.size(); i++)
		{
			System.out.println(arr.get(i).name);
		}
	}
	// 국어 점수 내림 차순 
	// 국어 점수 같으면 영어 점수 오름 차순 
	// 국어 점수 영어 점수 같으면 수학점수 내림 차순 
	// 모든 점수들이 같으면 이름 오름 차순 
	public static class Mysort implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			if(o1.kor > o2.kor) return -1; // 국어 점수 내림 차순  
			else if(o1.kor < o2.kor) return 1;
			else { // 국어 점수 같으면 
				if(o1.eng > o2.eng) return 1;
				else if(o1.eng < o2.eng) return -1;
				else { // 국어 점수 영어 점수 같으면 
					if(o1.math > o2.math) return -1;
					else if(o1.math < o2.math) return 1;
					else { // 모든 점수가 같으면 이름 오름 차순 ! 
						return o1.name.compareTo(o2.name); // String 비교 
						// o1 - o2 해줘서 결과 값이 -1 나오게 되면 o1 를 앞으로 보내게 되서
						// 오름 차순 
					}
				}
			}
		}
		// 1 : 뒤로 보냄 , -1 : 앞으로 보냄 
		// => o1 기준으로 o2 보다 커서 (o1 > o2) 1을 리턴해주게 되면 큰 값을 뒤로 보낸다는 의미 의미로 오름 차순
		//o1 과 o2를 비교 (o1 > o2 ) 해서 또한 -1 을 리턴해주게 된다는 것은 큰 값을 앞으로 보낸다는 의미 이므로 내림 차순!
	}
	static class Node{
		int kor, eng, math;// 국영수 
		String name; // 이름 
		Node(String a, int b, int c, int d) {
			name =a; kor=b; eng =c; math =d;
		}
	}
}
