package com.algorithm.week3;

import java.util.Scanner;
// 달란트2 greedy
public class Solution_D5_1265 {
	static int T, N, P;
	static long ans = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			P = sc.nextInt();
			int mok = N / P;
			int rest = N % P;
			ans =1;
			for (int i = 0; i < P - rest; i++) {
				ans *= mok;
			}
			for (int i = 0; i < rest; i++) {
				ans *= (mok+1);
			}
			System.out.printf("#%d %d%n", t, ans);
		}
	}

}
