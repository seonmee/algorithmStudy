package com.algorithm.week14;

import java.util.Scanner;
// 문서 검색
public class Solution_1543 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		String B = sc.nextLine();
		sc.close();
		A = A.replaceAll(B, "0");
		int ans = 0;
		for (int i = 0, size = A.length(); i < size ; i++) {
			if(A.charAt(i)=='0')ans++;
		}
		System.out.println(ans);
		
	}

}
