package com.algorithm.week25;

import java.util.Scanner;

/*
 * N과 M (3)
 * */
public class Solution_15651 {
	static int N,M;
	static int[] ans;
	static StringBuilder sb = new StringBuilder("");
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ans = new int[M];
		nπr(0);
		
		System.out.print(sb.toString());

	}
	private static void nπr(int cnt) {
		if (cnt == M) {
			print();
			return;
		}
		for (int i = 0; i < N; i++) {
			ans[cnt] = i;
			nπr(cnt + 1);
		}

	}
	private static void print() {
		for(int i = 0; i<M ; i++) {
			sb.append(ans[i]+1 + " ");
		}
		sb.append("\n");
	}

}
