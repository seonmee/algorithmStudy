package com.algorithm.week4.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// 반례 찾아보기
public class Solution_1377 {
	static int N;
	static Map A;
	static int[] temp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new HashMap<Integer, Integer>();
		temp = new int[N];
		for (int n = 0; n < N; n++) {
			temp[n] =Integer.parseInt(br.readLine());
			A.put(temp[n],n);
		}
		// 로직
		Arrays.sort(temp);
		int[] ans = new int[N];
		for (int n = 0; n < N; n++) {
			ans[n] = (int) A.get(temp[n]) - n;
			if(ans[n]<=0) {
				// 출력
				System.out.println(temp[n-1]);
				break;
			}
		}
		
	}

}
