package com.algorithm.week13.common;

import java.util.Scanner;
// 고층빌딩
public class Solution_1328 {
	static final int MOD = 1000000007;
	public static void main(String[] args) {
		int N, L, R;
		long[][][] dp;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		sc.close();
		
		dp = new long[101][101][101];
		
		dp[1][1][1] = 1; // N, L, R 이 1인 경우
		dp[2][2][1] = dp[2][1][2] = 1;
		for (int n = 3; n <= N; n++) {
			for (int l = 1; l <= L; l++) {
				for (int r = 1; r <= R; r++) {
					dp[n][l][r] += dp[n-1][l-1][r] % MOD;
					dp[n][l][r] += dp[n-1][l][r-1] % MOD;
					dp[n][l][r] += (dp[n-1][l][r] * (n-2)) % MOD;
				}
			}
		}
		System.out.println(dp[N][L][R]%MOD);
	}

}
