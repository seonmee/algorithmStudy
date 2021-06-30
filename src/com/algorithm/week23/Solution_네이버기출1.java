package com.algorithm.week23;
/*
 * 1 <= N <= 500
 * 
 * */
public class Solution_네이버기출1 {
	
	public static void main(String[] args) {
		int N = 499;
		System.out.println(solution(N));
	}

	private static int solution(int num) {
		int ans = 0;
		int sum = 0;
		// 1) 각 자리수의 합 
		while(num!=0) {
			sum += num%10;
			num = num/10;
		}
		// 2) 곱하기 2 
		sum *= 2;
		
		// 3) 자리수가 가장 작은것이 최솟값 : 9로 나누기 
		int nineCnt = sum / 9;
		int first = sum % 9;
		
		ans = first * (int)Math.pow(10, nineCnt);
		for(int i = 0; i < nineCnt; i++) {
			ans += 9 *  (int)Math.pow(10, i);
		}
		return ans;
	}

}
