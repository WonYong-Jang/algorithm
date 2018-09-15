package com.company.sds;


import java.util.Comparator;
import java.util.PriorityQueue;


class kakao_rates {
	
	static PriorityQueue<Node> que = new PriorityQueue<>(new mySort());
	static int[] data = new int[501]; // 스테이지 마다 갯수 
	static double[] rates = new double[501]; // 스테이지 마다 갯수 
	public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int len = stages.length; // 전체 총합 
        int value = len;
        for(int i=1; i<= len; i++)
        {
        	int temp = stages[i-1];
        	if(temp >= 1 && temp <= N) {
        		data[temp]++;
        	}
        }
        for(int i = 1; i<= N; i++) // 1 스테이지 부터 계산 
        {
        	rates[i] = (double)data[i] / (double)value;
        	value -= data[i];
        	que.add(new Node(i,rates[i]));
        }
        
        int index =0;
        
        while(!que.isEmpty())
        {
        	Node n = que.poll();
        	answer[index] = n.stage;
        	index++;
        }
        
        return answer;
    }
	static class Node {
		int stage;
		double rate;
		Node(int x, double y) {
			stage = x; rate = y;
		}
	}
	static class mySort implements Comparator<Node>
	{

		@Override
		public int compare(Node a, Node b) {
			// TODO Auto-generated method stub
			if(a.rate < b.rate) return 1;
			else if(a.rate > b.rate) return -1;
			else {
				if(a.stage < b.stage) return -1;
				else if(a.stage > b.stage) return 1;
				else return 0;
			}
		}
		
	}
}