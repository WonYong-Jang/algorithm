package com.company.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 큰 수 만들기
 */

public class sds_bigint {

	static ArrayList<Long> arr = new ArrayList<>();
	static ArrayList<Integer> opArr = new ArrayList<>();
	static ArrayList<Long> inputArr = new ArrayList<>();
	static Map<Integer, Long> map;

	static int[] op = new int[2];
	static int[] visited;
	static int N; // 입력 갯수
	static long result; // 가장 큰 수,

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for (int k = 1; k <= testCase; k++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			// BigInteger big = new BigInteger("0");
			int plus = Integer.parseInt(st.nextToken());
			int minus = Integer.parseInt(st.nextToken());
			visited = new int[N - 1];
			map = new HashMap<Integer, Long>();
			op[0] = plus;
			op[1] = minus; // set input number
			arr.clear();
			opArr.clear(); // 해당 값의 우선순위를 정해서 +, - 연산 중 선택
			inputArr.clear();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				long tmp = Long.parseLong(st.nextToken());
				inputArr.add(tmp);
				arr.add(tmp);
				if (i > 0)
					map.put(i, tmp); // map input
			}

			result = inputArr.get(0); // 첫번째 값 기억
			// big = big.add(BigInteger.valueOf(result));
			inputArr.remove(0); // 첫번째 값 제외

			Iterator<Integer> it = sds_bigint.sortByValue(map).iterator();
			
			while(it.hasNext()){
	            int temp =  (Integer) it.next();
	           // System.out.println(temp + " = " + map.get(temp));
	            if(op[1] >0) {
	            	result -= map.get(temp);
	            	op[1]--;
	            }
	            else {
	            	result += map.get(temp);
	            }
	        }
			
			
			
			System.out.println("#" + k + " " + result);
		}
	}
	public static List<Integer> sortByValue(final Map<Integer, Long> map) {
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(map.keySet());
		Collections.sort(list, new Comparator<Object>() {
			@SuppressWarnings("unchecked")
			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);
				return ((Comparable<Object>) v1).compareTo(v2);
			}
		});
		//Collections.reverse(list); // 주석시 오름차순
		return list;
	}
}
