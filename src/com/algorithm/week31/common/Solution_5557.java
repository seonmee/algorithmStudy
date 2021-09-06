package com.algorithm.week31.common;
import java.util.*;
import java.io.*;
/*
 * 1학년 
 * 
 * */
public class Solution_5557 {

	static int N;
	static int[] num;
	static long[][] result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];   // 연산 결과의 수가 담기는 배열 
		result = new long[N-1][21];  // 중간에 나오는 수가 모두 0 이상 20 이하
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		// input 
		// 11
		// 8 3 2 4 8 7 2 4 0 8 8
		
		// result[0][8] : 0번 연산 했을 때 결과 값이 8인 경우의 수  1개 
		result[0][num[0]] = 1;
		
		solve();
		
		System.out.println(result[N-2][num[N-1]]);
		
	}
	
	private static void solve() {
		for(int i = 1; i < N-1 ; i++) {
			for(int j = 0; j < 21; j++) {
				if(result[i-1][j]!=0) {  // i-1번 계산했을 때 결과 값이 존재하면 
					if(j-num[i]>=0) result[i][j-num[i]] += result[i-1][j];
					if(j+num[i]<=20) result[i][j+num[i]] += result[i-1][j];
					
				}
			}
		}
	}

}
