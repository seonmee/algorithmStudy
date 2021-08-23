package com.algorithm.week30;
import java.io.*;
import java.util.*;
/*
 * 스티커 
 * 
 * */
public class Solution_9465 {
	static int T, n;
	static int[][] dp, cost; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			n = Integer.parseInt(br.readLine());
			
			cost = new int[2][n+1];
			dp = new int[2][n+1];
			
			// 입력
			for(int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 1; k <= n;k++) {
					cost[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = cost[0][1];
			dp[1][1] = cost[1][1];
			
			for(int j = 2; j <= n;j++) {
				dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + cost[0][j];
				dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + cost[1][j];
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n]));
			
			
			
		}
		
		
	}

}
