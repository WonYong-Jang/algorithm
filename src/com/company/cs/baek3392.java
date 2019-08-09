package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 화성지도 
 */
public class baek3392 {

	static int N, len;
	static final int max_value = 300001;
	static int[] tree = new int[4*max_value];
	static int[] cnt = new int[4*max_value];
	static Node[] line = new Node[max_value];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		len = 0;
		int dx1 = 0 , dy1 = 0, dx2 = 0, dy2 = 0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx1 = Integer.parseInt(st.nextToken());
			dy1 = Integer.parseInt(st.nextToken());
			dx2 = Integer.parseInt(st.nextToken());
			dy2 = Integer.parseInt(st.nextToken());
			line[++len] = new Node(dx1, dy1, dy2-1, 1);
			line[++len] = new Node(dx2, dy1, dy2-1, 2);
		}
		Arrays.sort(line ,1, len+1, new mySort());
		
		int dxLen = 0, result = 0, flag = 0;
		for(int i=1; i<= len; i++)
		{
			if(i != 1)
			{
				dxLen = line[i].dx - line[i-1].dx;
			}
			result += (dxLen*tree[1]);
			flag = line[i].flag;
			if(flag == 1){
				update(1, 0, max_value-1, line[i].dy1, line[i].dy2, 1);
			}
			else {
				update(1, 0, max_value-1, line[i].dy1, line[i].dy2, -1);
			}
		}
		bw.write(result+"\n");
		bw.flush();
	}
	public static void update(int node, int start, int end, int i, int j, int num)
	{
		if(end < i || j < start) return;
		else if(i <= start && end <= j) {
			cnt[node] += num;
		}
		else
		{
			int mid = ( start + end ) >> 1;
			update(node*2, start, mid, i, j, num);
			update(node*2+1, mid+1, end, i, j, num);
		}
		
		if(cnt[node] > 0) {
			tree[node] = (end-start+1);
		}
		else {
			if(start == end) tree[node] = 0;
			else 
			{
				tree[node] = tree[node*2] + tree[node*2+1];
			}
		}
	}
	static class mySort implements Comparator<Node> {
		@Override
		public int compare(Node a, Node b) {
			if(a.dx < b.dx) return -1;
			else if(a.dx > b.dx) return 1;
			else return 0;
		}
	}
	static class Node {
		int dx, dy1, dy2, flag;
		Node(int a, int b, int c, int d) {
			dx = a; dy1 = b; dy2 = c; flag = d;
		}
	}
}
