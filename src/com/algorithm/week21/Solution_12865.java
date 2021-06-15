package com.algorithm.week21;

import java.util.*;

/*
 * 평범한 배낭 
 * */
public class Solution_12865 {
	static int N, K;
	static int[] W,V;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();    // 물품 수 
		K = sc.nextInt();    // 버틸 수 있는 무게 
		W = new int[N+1];
		V = new int[N+1];
		dp = new int[N+1][K+1];
		for(int i = 1; i <= N ; i++) {
			W[i] = sc.nextInt();   // 무게 
			V[i] = sc.nextInt();   // 가치 
		}
		
		for(int i = 1; i <= N ; i++) {
			for(int j = 1; j <= K; j++ ) {
				// i번째 무게를 더 담을 수 없는 경우 
				if(W[i] > j) {
					dp[i][j] = dp[i - 1][j];
				}
				// i번째 무게를 더 담을 수 있는 경우 
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
				}
			}	
		}
		
		System.out.println(dp[N][K]);
		 
	}

}
