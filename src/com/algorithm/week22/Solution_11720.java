package com.algorithm.week22;
import java.util.*;
/*
 * 숫자의 합 
 * */
public class Solution_11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String nums = sc.next();
		int ans = 0;
		for(int i = 0; i < N;i++) {
			ans += nums.charAt(i)-'0';
		}
		System.out.print(ans);
		
	}

}
