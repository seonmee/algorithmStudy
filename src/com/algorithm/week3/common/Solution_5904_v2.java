package com.algorithm.week3.common;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_5904_v2 {
	static int N;
	static ArrayList<Integer> m;
	static char ans = 'o';
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.close();
		m = new ArrayList<>();
		dfs(1, 0);
		System.out.println(ans);
	}

	private static void dfs(int cnt, int sum) {
		if (sum > N) {
			for (Integer mIndex : m) {
				if (mIndex==N) {
					ans = 'm';
				}
			}
			return;
		}
		m.add(1+sum);
		for (int i = 0, size = m.size(); i < size-1; i++) {
			m.add(m.get(i)+sum+cnt+2);
		}
		dfs(cnt + 1, sum * 2 + (2 + cnt));

	}

}
