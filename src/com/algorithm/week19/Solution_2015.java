package com.algorithm.week19;

import java.io.*;
import java.util.*;
/*
 * 수들의 합 4
 * 
 * */
public class Solution_2015 {
	static int N, K;
	static int[] pSum;
	static Map<Integer, Integer> map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());    // 베열 크기 
		pSum = new int[N+1];
		K = Integer.parseInt(st.nextToken());    // 비교 대상 
		
		map = new HashMap<>();
		map.put(0, 1);
		
		st = new StringTokenizer(br.readLine());
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			// 1) 누적합 
			pSum[i] = pSum[i-1] + num;
			// 2) 
			ans += map.getOrDefault(pSum[i]-K,0);
			
			map.put(pSum[i], map.getOrDefault(pSum[i], 0) + 1);
			
		}
		
		System.out.print(ans);

	}

}
