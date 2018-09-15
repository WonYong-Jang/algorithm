package com.company.sds;

import java.util.Comparator;
import java.util.PriorityQueue;

class kakao_binarytree {
	static PriorityQueue<Node> que = new PriorityQueue<>(new mySort());
	static Node[] tree = null;
	static final int max = 1000005*4;
	static int[][] answer = new int[2][];
	static int[] arr1 = null;
	static int[] arr2 = null;
	static int cnt1 =0, cnt2 =0;
    public int[][] solution(int[][] nodeinfo) {
        int len = nodeinfo.length;
        arr1 = new int[len];
        arr2 = new int[len];
       
        for(int i=0; i<len; i++)
        {
        	int dx =0, dy=0, index =0;
        	for(int j=0; j<2; j++)
        	{
        		if(index ==0) {
        			dx = nodeinfo[i][j];
        			index++;
        		}
        		else {
        			dy = nodeinfo[i][j];
        		}	
        	}
        	que.add(new Node(dx, dy, i+1));
        }
       
        tree = new Node[max];
        int idx =1;
        while(!que.isEmpty())
        {
        	Node n = que.poll();
        	int parent = idx / 2;
        	
        	if(parent ==0) {
        		tree[idx] = n; idx++;
        	}
        	else {
        		insert(n, 1);
        	}
        	
        }
        preorder(1);
        postorder(1);
        answer[0] = arr1;
        answer[1] = arr2;
        
        return answer;
    }
    public static void insert(Node n,int idx)
    {
    	if( tree[idx] == null) {
    		tree[idx] = n;
    	}
    	if(tree[idx].dy > n.dy && tree[idx].dx > n.dx && idx*2 < max) insert(n,idx*2);
    	else if(tree[idx].dy > n.dy && tree[idx].dx < n.dx && idx*2 < max) insert(n,idx*2 + 1);
    }
    public static void preorder(int idx)
    {
    	if(tree[idx] == null) return;
    	
    	arr1[cnt1++] = tree[idx].index;
    	if(idx*2 < max) preorder(idx*2);
    	if(idx*2 < max) preorder(idx*2 + 1);
    }
    public static void postorder(int idx)
    {
    	if(tree[idx] == null) return;
    	
    	if(idx*2 < max) postorder(idx*2);
    	if(idx*2 < max) postorder(idx*2 + 1);
    	arr2[cnt2++] = tree[idx].index;
    }
    static class mySort implements Comparator<Node>{
		@Override
		public int compare(Node a, Node b) {
			// TODO Auto-generated method stub
			if(a.dy < b.dy) return 1;
			else if(a.dy > b.dy) return -1;
			else {
				if(a.dx < b.dx) return -1;
				else if(a.dx > b.dx) return 1;
				else return 0;
			}
		}
    }
	static class Node{
		int dx, dy, index;
		Node(int x, int y, int z) {
			dx = x; dy =y; index =z;
		}
	}
}