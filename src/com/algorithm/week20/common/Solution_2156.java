package com.algorithm.week20.common;

import java.io.*;
/*
 *  포도주 시식
 * */
public class Solution_2156 {
	static int N, ans;
	static int[] wine, dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		wine = new int[N+1];
		dp = new int[N+1];
		for(int i = 1; i <= N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = wine[1];
		if(N>1) {
			dp[2] = wine[1] + wine[2]; 
		}
		
		for(int i = 3 ; i <=N; i++ ) {
			// 1) n-1 번째를 마신 경우 : n-2 번째를 마실 수 x
			// 2) n-1 번째를 마시지 않은 경우 
			dp[i] = Math.max(dp[i-3] + wine[i-1] + wine[i], dp[i-2] + wine[i]);
			// 1) n 번째를 마신 경우
			// 2) n 번째를 마시지 않은 경우 
			// e.g. 9 8 1 >>  
			// n 이 2인 경우(wine[2[ = 1)  
			// 마신 경우 8 + 1 = 9 < 안마신 경우 9 + 8 = 17
			dp[i] = Math.max(dp[i], dp[i-1]);
		}
		System.out.print(dp[N]);
	}
	
}
