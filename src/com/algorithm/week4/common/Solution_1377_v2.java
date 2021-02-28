package com.algorithm.week4.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_1377_v2 {
	static int N;
	static Map A, B;
	static int[] temp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		B = new HashMap<Integer, Integer>(); // 정렬 이전
		temp = new int[N];
		for (int n = 0; n < N; n++) {
			temp[n] = Integer.parseInt(br.readLine());
			B.put(temp[n], n);
		}
		// 로직
		Arrays.sort(temp);
		A = new HashMap<Integer, Integer>(); // 정렬 이후
		for (int n = 0; n < N; n++) {
			A.put(temp[n], n);
		}
		
		int[] idx = new int[N];
		int max = Integer.MIN_VALUE;
		int ans = 0;
		
		for (int n = 0; n < N; n++) {
			idx[n] = (int)B.get(temp[n]) - (int) A.get(temp[n]);
			if (idx[n] >= 0) {
				if (idx[n] >= max) {
					max = idx[n];
					ans = max + 1;
				}
			}
		}
		System.out.println(ans);

	}

}
