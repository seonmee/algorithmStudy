package com.algorithm.week3.common;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_5904 {
	static int N;
	static char ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dfs(1, 0, "");
		System.out.println(ans);
	}

	private static void dfs(int cnt, int sum, String moo) {
		if (sum > N) {
			ans =moo.charAt(N-1);
			return;
		}
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < cnt+1; i++) {
			sb.append("o");
		}
		dfs(cnt + 1, sum * 2 + (2 + cnt), moo + "m" + sb.toString() + moo);

	}

}
