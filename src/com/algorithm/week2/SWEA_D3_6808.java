package com.algorithm.week2;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_D3_6808 {
	static int T, winA, same;
	static ArrayList<Integer> a;
	static ArrayList<Integer> b, b2;
	static boolean[] devide, isVisited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		a = new ArrayList<>();
		b = new ArrayList<>();
		devide = new boolean[19]; // 0은 더미
		isVisited = new boolean[10]; // 0은 더미
		for (int t = 1; t <= T; t++) {
			for (int i = 0; i < 9; i++) {
				devide[sc.nextInt()] = true;
			}
			for (int i = 1; i <= 18; i++) {
				if (devide[i]) {
					a.add(i);
				} else {
					b.add(i);
				}
			}
			b2 = new ArrayList<>();
			dfs(0);
			System.out.printf("#%d %d %d%n",t,winA, 362880-winA-same);
		}
	}

	private static void dfs(int cnt) {
		if (cnt == 9) {
			int totA = 0, totB = 0;
			for (int i = 0; i < 9; i++) {
				if (a.get(i) > b2.get(i)) {
					totA += a.get(i) + b2.get(i);
				} else {
					totB += a.get(i) + b2.get(i);
				}
			}
			if(totA>totB) {
				winA++;
			}else if(totA == totB) {
				same++;
			}
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (isVisited[i])
				continue;
			isVisited[i] = true;
			b2.add(b.get(i-1));
			dfs(cnt + 1);
			isVisited[i] = false;
		}

	}

}
