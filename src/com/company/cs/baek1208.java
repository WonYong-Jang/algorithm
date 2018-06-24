package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 부분집합의 합 2   
 * 2^40 은 약 1조에 가깝기 때문에 절반으로 나눠서 계산  !( 미완성 )  
 */
public class baek1208 {

	public static int[] arr = new int[41];
	public static int N, S, A, B;
	public static long cnt =0;
	public static ArrayList<Integer> subSet1 = new ArrayList<>();
	public static ArrayList<Integer> subSet2 = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		A = N/2;
		B = N-A;
		subSet(A, B);
		
		Collections.sort(subSet2);
		for(int i=0; i<subSet1.size(); i++) // A+B 에서 나올수 있는경우  
		{
			if(binarySearch(0, subSet2.size()-1, subSet1.get(i))) cnt++;
		}
		
		System.out.println(cnt);
	}
	public static void subSet(int A, int B) {
		int sum =0;
		for(int i=1 ;i< (1<<A) ; i++) // A 에서 나올 수 있는 경우   
		{
			sum =0;
			for(int j=0; j< A; j++)
			{
				if( (i&(1<<j)) > 0) sum +=arr[j];
			}
			if(sum == S) cnt++;
			subSet1.add(sum);
			
		}
		
		for(int i=1; i<(1<< B); i++) // B 에서 나올 수 있는 경우  
		{
			sum=0;
			for(int j=0; j<B; j++)
			{
				if( (i&(1<<j)) >0) sum += arr[A+j];
			}
			if(sum == S) cnt++;
			subSet2.add(sum);
		}
		
	}
	public static boolean binarySearch(int start, int end, int target) {
		if(start >= end) return false;
		
		int mid = (start + end) / 2;
		
		if(subSet2.get(mid) + target == S) 
		{
			int chkLeft = mid, chkRight = mid;
			while(--chkLeft >= 0) {
				if(subSet2.get(chkLeft) + target == S) cnt++;
				else break;
			}
			while(++chkRight <= end) {
				if(subSet2.get(chkRight) + target == S) cnt++;
				else break;
			}
			return true;
		}
		
		if(subSet2.get(mid) > target) return binarySearch(start,mid-1,target);
		else if(subSet2.get(mid) < target) return binarySearch(mid+1,end,target);
		else return false;
	}
}












