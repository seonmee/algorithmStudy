package com.algorithm.week5;

import java.util.Scanner;

// 백준_2007
public class Solution_1924 {
	static int x, y;
	static int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
	static String[] day = {"MON", "TUE", "WED", "THU", "FRI", "SAT","SUN"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		// 로직
		int totDay = 0;
		for (int i = 0; i < x-1; i++) {
			totDay += days[i];
		}
		totDay += (y-1);
		// 출력
		System.out.println(day[totDay%7]);
		

	}

}
