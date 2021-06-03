package com.algorithm.week19;

import java.util.*;

/*
 * 소수의 연속
 * 
 * 하나 이상의 연속된 소수의 합으로 나타낼 수 있는 자연수들
 * 
 * */
public class Solution_1644 {
	static int N;
	static boolean[] check;
	static ArrayList<Integer> prime;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		check = new boolean[N+1];
		prime = new ArrayList<>();
		// 1) 소수 구하기 : 에라토스 
		check[0] = check[1] = true;
		for(int i = 2 ; i <= N ; i++) {
			// 소수 이면 
			if(!check[i]) {
				prime.add(i);
				// 소수의 배수는 소수가 x
				for(int j = i + i; j <=N; j+=i) {
					check[j] = true;
				}
			}
		}
		// 2) 연속된 합으로 가능한 경우의 수
		int start = 0, end = 0, sum = 0, ans = 0;
		int size = prime.size();
		while(true) {
			if(sum>=N) {
				if(sum==N)ans++;
				sum -= prime.get(start);
				start++;
				
			}else {
				if(end==size) break;
				sum += prime.get(end);
				end++;
			}
		}
		System.out.print(ans);

	}

}
