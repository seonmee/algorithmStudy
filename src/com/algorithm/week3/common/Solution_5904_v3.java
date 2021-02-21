package com.algorithm.week3.common;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_5904_v3 {
	static int N;
	static char ans = 'o';

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.close();
		// 로직
		dfs(1, 0);
		// 출력
		System.out.println(ans);
	}

	private static void dfs(int cnt, int sum) {
		if (sum > N) {
			find(sum, cnt-1, N);
			return;
		}
		// cnt, moo수열의 총 길이 , moo수열 넘겨주기
		dfs(cnt + 1, sum * 2 + (2 + cnt));

	}

	private static void find(int len, int cnt, int n) {
		int prelen = (len - cnt - 2) / 2;
		if (n <= prelen) {// 처음
			find(prelen, cnt - 1, n);
		} else if (n <= len - prelen) { // 중간 (마지막 지점)
			if (n == prelen + 1)
				ans = 'm';
		} else { // 끝
			find(prelen, cnt - 1, n - prelen - (cnt + 2));
		}
	}

}
