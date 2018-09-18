package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 조세퍼드 문제 ( 링크드 리스트 직접 구현 )
 */


public class baek1158_2 {

	static int N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		NodeList list = new NodeList();
		for(int i=1; i<= N; i++)
		{
			list.addLast(i); // 데이터 추가 
		}
		list.connect();
		
		System.out.println(list.remove());
		
		
	}
	static class NodeList { // 링크드 리스트 
		static Node head;
		static Node tail;
		static Node target; // 삭제될 포인터 
		static int size=0;
		
		static class Node {
			int data;
			int visit;
			Node next;
			public Node(int data) {
				this.data = data;
				visit = 0;
			}
		}
		public void addFirst(int data)
		{
			Node newNode = new Node(data);
			
			newNode.next = head;
			head = newNode;
			
			if(newNode.next == null)
			{
				tail = head;
			}
			target = head;
			size++;
		}
		public void addLast(int data)
		{
			if(size ==0 )
			{
				addFirst(data);
			}
			else {
				Node newNode = new Node(data);
				
				tail.next = newNode;
				tail = newNode;
				size++;
			}
		}
		public void connect()
		{
			Node temp = tail;
			temp.next = head;
		}
		public String remove()
		{
			String result = "<";
			while(size > 0)
			{
				int cnt = 0;
				Node temp = target;
				if(temp.visit == 0) cnt++;
				while(cnt != M)
				{
					temp = temp.next;
					if(temp.visit == 0) {
						cnt++;
					}
				}
				temp.visit = 1;
				target = temp;
				size--;
				if(size ==0) result += temp.data+">";
				else result += temp.data+", ";
				
			}
			
			return result;
		}
		public String toString()
		{
			String str = "";
			Node temp = head;
			for(int i=0; i<10; i++)
			{
				str += temp.data +" ";
				temp = temp.next;
			}
			
			str += temp.data +" ";
			return str;
		}
	}
}
