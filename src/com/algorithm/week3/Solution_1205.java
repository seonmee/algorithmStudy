package com.algorithm.week3;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_1205 {
	static int N,zok, ans = Integer.MIN_VALUE;
	static ArrayList<Integer> arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num == 0) {
				zok++;
			} else {
				arr.add(num);
			}
		}
		arr.sort(null);
		checkArr();
		System.out.println(ans);
	}

	private static void checkArr() {
		int cnt = 1;
		for (int i = 0; i < arr.size() - 1; i++) {
			int minus = arr.get(i + 1) - arr.get(i);
			if (minus == 1) {
				cnt++;
			} else {
				if (zok!=0 && zok >= minus -1) {
					cnt++;
					for (int j = 0; j < minus-1; j++) {
						zok--;
						cnt++;
					}
				}else {
					ans = Math.max(ans, cnt + zok);			
				}
			}
		}
	}

}
