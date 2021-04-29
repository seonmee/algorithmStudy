package com.algorithm.week14;
import java.util.Scanner;
// 문자열
public class Solution_1120 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		int sizeB = B.length(), sizeA = A.length();
		sc.close();
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= sizeB-sizeA; i++) {
			int cnt = 0;
			for (int j = i; j < sizeA+i; j++) {
				if(B.charAt(j)!=A.charAt(j-i)) cnt++;
			}
			ans = Math.min(ans, cnt);
		}
		System.out.println(ans);
	}
}
