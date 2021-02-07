package com.algorithm.week2;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon_6588 {
	static int N, num;
	static ArrayList<Integer> odds;

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		while (true) {
			num = sn.nextInt();
			odds = new ArrayList<>();
			// 기저조건
			if (num == 0)
				break;
			for (int i = 2; i <= num; i++) {
				odds.add(i);
			}
			for (int i = 0; i < num - 1; i++) {
				// 0이면 pass
				if (odds.get(i) == 0)
					continue;
				for (int j = 2 * i + 2; j < num - 1; j += i + 2) {
					odds.set(j, 0);
				}
			}
			int front=0;
			for (int j = 1; j < odds.size(); j++) {
				if (odds.contains(num - odds.get(j))) {
					front = odds.get(j);
					break;
				}
			}
			if(front == 0) {
				System.out.println("Goldbach's conjecture is wrong.");
			}else {
				System.out.println(num + " = " + front + " + " + (num - front));	
			}

		}

	}

}
