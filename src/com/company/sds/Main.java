package com.company.sds;

import java.io.*;
import java.util.*;
public class Main {
    static final int MAX = 1000000000;
    static final int RMAX = 40000; // 31622.77661^2 > 1000000000
    static final int NMAX = 1000;
    static final long MOD = 1000000000L;

    static boolean isPrime[] = new boolean[RMAX];
    static int prime[] = new int[RMAX], pcnt;
    static int pfA[] = new int[RMAX], pfB[] = new int[RMAX];
    static int lastA[] = new int[NMAX], lastB[] = new int[NMAX], lastA_cnt, lastB_cnt;
    static int N,M;
    static int min(int a, int b){return (a<b)?a:b;}
    static long ans;
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 에라토스테네스의 체 
        isPrime[0]=isPrime[1]=false;
        for(int i=2;i<RMAX;i++)isPrime[i]=true;

        lastA_cnt=lastB_cnt=pcnt=0;
        for(int i=2;i<RMAX;i++) 
        {
            if(isPrime[i])
            {
                prime[pcnt++]=i;
                for(int j=i+i;j<RMAX;j+=i) isPrime[j]=false;
            }
        }

        // 소수인자 배열 초기화 
        for(int p=0;p<pcnt;p++)pfA[p]=pfB[p]=0;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0,num;i<N;i++)
        {
            num = Integer.parseInt(st.nextToken());
            // N개의 수를 입력받으며 소인수 분해 
            for(int p=0;p<pcnt&&prime[p]<=num;p++)
            {
                while(num%prime[p]==0){
                    pfA[p]++;
                    num/=prime[p];
                }
            }
            // 나머지 수가 1보다 크다면 미리 구해놓은 소수보다 큰 소수이므로 따로 저장 
            if(num>1) lastA[lastA_cnt++]=num;
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0,num;i<M;i++)
        {
            num = Integer.parseInt(st.nextToken());
            // M개의 수를 입력받으며 소인수 분해 
            for(int p=0;p<pcnt&&prime[p]<=num;p++)
            {
                while(num%prime[p]==0){
                    pfB[p]++;
                    num/=prime[p];
                }
            }
            // 나머지 수가 1보다 크다면 미리 구해놓은 소수보다 큰 소수이므로 따로 저장 
            if(num>1) lastB[lastB_cnt++]=num;
        }

        // 소인수 분해 후 남은 큰 소수들의 데이터를 크기순으로 정렬
        Arrays.sort(lastA,0,lastA_cnt);
        Arrays.sort(lastB,0,lastB_cnt);

        ans=1;
        int flg=0; // 1000000000 보다 크면 1 작으면 0 

        // 소인수분해 정보를 이용하여 공통 인자를 찾고 최대공약수 구하기 
        for(int p=0,cnt;p<pcnt;p++)
        {
            cnt=min(pfA[p],pfB[p]); // 같은 인수에서 적은 차수를 곱함 
            while(cnt-->0) 
            {
                ans=ans*(long)prime[p];
                if(ans>MOD) {ans%=MOD; flg=1;}
            }
        }

        // 인수가 큰 소수인 경우 두 수에 모두 포함된 인수만 최대공약수에 곱함
        // 2 point 기법을 활용 
        int idxA=0, idxB=0;
        while(idxA<lastA_cnt && idxB<lastB_cnt)
        {
            if(lastA[idxA] == lastB[idxB]){
                ans=ans*(long)lastA[idxA];
                if(ans>MOD){ans%=MOD; flg=1;}
                idxA++;idxB++;
            }
            else if(lastA[idxA] < lastB[idxB]) idxA++;
            else idxB++;
        }
        int num = 1000012028;
        if(flg==1) System.out.printf("%09d",ans);
        else System.out.printf("%d",ans);
        
        System.out.printf("%09d",num);
    }
}
