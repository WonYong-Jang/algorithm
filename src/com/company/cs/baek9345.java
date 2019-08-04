package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 디지털 비디오 디스크 
 */
public class baek9345 {

	static final int max_value = 100001;
	static int N, K, start, end;
	static int[] maxTree = new int[4*max_value+5];
	static int[] minTree = new int[4*max_value+5];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			start = 1;
			while(N > start ) start *= 2;
			end = start + N - 1;
			
			for(int i=1; i<= N*4; i++)
			{
				maxTree[i] = 0;
				minTree[i] = max_value;
			}
			
			int index = 1;
			for(int i = start ; i <= end; i++)
			{
				maxTree[i] = index;
				minTree[i] = index;
				index++;
			}
			
			for(int i= end/2; i>=1; i--)
			{
				maxTree[i] = max(maxTree[i*2], maxTree[i*2+1]);
				minTree[i] = min(minTree[i*2], minTree[i*2+1]);
			}
			
			K = Integer.parseInt(st.nextToken());
			int cmd = 0, dx = 0, dy = 0;
			for(int i=1; i<= K; i++)
			{
				st = new StringTokenizer(br.readLine());
				cmd = Integer.parseInt(st.nextToken());
				dx = Integer.parseInt(st.nextToken())+1;
				dy = Integer.parseInt(st.nextToken())+1;
				if(cmd == 1)
				{
					int left = getMin(dx, dy);
					int right = getMax(dx, dy);
					if(left == dx && right == dy) bw.write("YES\n");
					else bw.write("NO\n");
				}
				else
				{
					maxUpdate(dx,dy);
					minUpdate(dx,dy);
					
					
				}
			}
		}
		bw.flush();
	}
	public static void maxUpdate(int sdx, int edx)
	{
		int dx = sdx + start - 1;
		int dy = edx + start - 1;
		int numDx = maxTree[dx];
		int numDy = maxTree[dy];
		
		maxTree[dx] = numDy;
		
		while(dx > 1)
		{
			dx/=2;
			maxTree[dx] = max(maxTree[dx*2] , maxTree[dx*2+1]);
		}
		maxTree[dy] = numDx;
		
		while(dy > 1)
		{
			dy/=2;
			maxTree[dy] = max(maxTree[dy*2] , maxTree[dy*2+1]);
		}
		
	}
	public static void minUpdate(int sdx, int edx)
	{
		int dx = sdx + start - 1;
		int dy = edx + start - 1;
		int numDx = minTree[dx];
		int numDy = minTree[dy];
		
		minTree[dx] = numDy;
		
		while(dx > 1)
		{
			dx/=2;
			minTree[dx] = min(minTree[dx*2] , minTree[dx*2+1]);
		}
		minTree[dy] = numDx;
		
		while(dy > 1)
		{
			dy/=2;
			minTree[dy] = min(minTree[dy*2] , minTree[dy*2+1]);
		}
		
	}
	public static int getMax(int sdx, int edx)
	{
		int result = 0;
		int dx = sdx + start - 1;
		int dy = edx + start - 1;
		while(dx <= dy)
		{
			if(dx % 2 != 0) result = max(result, maxTree[dx]);
			if(dy % 2 == 0) result = max(result, maxTree[dy]);
			
			dx = (dx + 1) / 2;
			dy = (dy - 1) / 2;
		}
		
		return result;
	}
	public static int getMin(int sdx, int edx)
	{
		int result = max_value;
		int dx = sdx + start - 1;
		int dy = edx + start - 1;
		while(dx <= dy)
		{
			if(dx % 2 != 0) result = min(result, minTree[dx]);
			if(dy % 2 == 0) result = min(result, minTree[dy]);
			
			dx = (dx + 1) / 2;
			dy = (dy - 1) / 2;
		}
		
		return result;
	}
	public static int max(int a, int b) { return a > b ? a : b; }
	public static int min(int a, int b) { return a > b ? b : a; }
}


/**
1
5 5
0 1 2
0 2 3
0 1 3
1 0 1
1 0 2 
*/
