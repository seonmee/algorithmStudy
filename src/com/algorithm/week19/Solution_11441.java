package com.algorithm.week19;

import java.io.*;
import java.util.*;
/* 합 구하기
 *  
 * N개의 수 A1, A2, ..., AN이 입력으로 주어진다. 총 M개의 구간 i, j가 주어졌을 때, i번째 수부터 j번째 수까지 합
 * 1 ≤ N ≤ 100,000
 * (-1,000 ≤ Ai ≤ 1,000)
 * 구간의 갯수 1 ≤ M ≤ 100,000
 * 
 * 풀이 :  10,000,000,000 시간 초과 
 *        Prefix Sum 부분합 
 * 
*/ 
public class Solution_11441 {
	static int N, M;
	static int[] pSum;    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pSum = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N ; i++) {
			int num = Integer.parseInt(st.nextToken());
			pSum[i] = pSum[i-1] + num;        // 누적합 계산 
		}
		M = Integer.parseInt(br.readLine());  // 구간수
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());   // 구간 시작지점
			int e = Integer.parseInt(st.nextToken());   // 구간 종료지점 
			System.out.println(pSum[e] - pSum[s-1]);
		}
		
	}

}
