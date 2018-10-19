package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 테트리스 
 */
public class baek3019 {

	static int N, M, ans;
	static int[] data = new int[105];
	static int[][][] map = {
			{{ 0 }, {0,0,0,0} },
			{{ 0, 0} },
			{{ 0, 0, 1}, {1, 0 } },
			{{ 1, 0, 0}, {0, 1 } },
			{{ 0, 0, 0}, {0, 1 }, {1, 0 }, {1, 0, 1 } },
			{{ 0, 0, 0}, {0, 0 }, {0, 1, 1 }, {2, 0 } },
			{{ 0, 0, 0}, {0, 2 }, {1, 1, 0 }, {0, 0 } }
	};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i< N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		setting(M-1);
		System.out.println(ans);
	}
	public static void setting(int M)
	{
		int type = map[M].length;
		int len = 0;
		for(int k=0; k< type; k++)
		{
			len = map[M][k].length;
			for(int i=0; i< N- len + 1; i++)
			{
				int check = 10000, index = i;
				boolean flag = true;
				for(int j=0; j< len; j++)
				{
					if(check != 10000) {
						if(check != (data[index]- map[M][k][j])) {
							flag = false; break;
						}
						index++;
					}
					else if(check == 10000) {
						check = data[index] - map[M][k][j];
						index++;
					}
				}
				if(flag) ans++;
			}
		}
	}
}





