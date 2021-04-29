package com.algorithm.week14;

import java.util.Scanner;

// 백대열
public class Solution_14490 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.nextLine().split(":");
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);
		// 유클리드 호제
		int gcd;
		if(a>b) gcd = gcd(a,b);
		else gcd = gcd(b,a);
		System.out.println(a/gcd + ":" +b/gcd);
	}

	private static int gcd(int a, int b) {
		if(b==0) return a;
		return gcd(b, a%b);
	}

}
