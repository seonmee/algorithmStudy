package com.algorithm.week12;

import java.util.TreeSet;

public class Solution_N으로표현3 {
	static int sN;
	static TreeSet<Integer>[] arr; 
	public static void main(String[] args) {
		int N = 5;
		int number = 12;
		System.out.println(solution(N,number));
	}
	
	public static int solution(int N, int number) {
        sN = N;
		arr = new TreeSet[9];
        for (int i = 1; i <=8 ; i++) {
			findnum(i);
			if(arr[i].contains(number)) {
				return i;
			}
		}
        return -1;
    }

	private static TreeSet<Integer> findnum(int n) {
		if(arr[n]!=null && !arr[n].isEmpty()) return arr[n]; // 이미 계산 된 경우
		TreeSet<Integer> result = new TreeSet<>(); // 계산된 결과
		
		// 1. 연속된 값 e.g. 55, 555
		int num = 0;
		for (int i = 0; i < n; i++) {
			num = num * 10 + sN;
		}
		result.add(num);
		
		// 2. 사칙 연산  dp[n] = dp[i] + dp[n-i]
		// e.g. 4 = 1 + 3
		//        = 2 + 2 
		//        = 3 + 1
		for (int i = 1; i < n; i++) {
			int j = n-i; 
			TreeSet<Integer> front = findnum(i);
			TreeSet<Integer> back = findnum(j);
			for (Integer f : front) {
				for (Integer b : back) {
					result.add(f+b);
					result.add(f-b);
					result.add(f*b);
					if(b!=0)result.add(f/b);
				}
			}
		}
		
		return arr[n] = result;	
	}

}
