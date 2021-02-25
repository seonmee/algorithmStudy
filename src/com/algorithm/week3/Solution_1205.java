package com.algorithm.week3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// 정올_조커
public class Solution_1205 {
	static int N, jok;
	static ArrayList<Integer> cards;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력
		N = sc.nextInt();
		cards = new ArrayList<>();
		int num = 0;
		for (int i = 0; i < N; i++) {
			num = sc.nextInt();
			if (num == 0)
				jok++;
			else
				cards.add(num);
		}
		// 로직
		// 오름차순 정렬
		cards.sort((Integer o1, Integer o2)-> {
				return o1-o2;
		});
		int ans = 0;
		for (int i = 0; i < cards.size(); i++) {
			int len = 1;
			for (int j = i; j < cards.size()-1; j++) {
				// 연속적인 숫자가 아닌 경우
				if(cards.get(j) + 1 != cards.get(j+1)) {
					if(jok!=0) { // 조커가 있으면
						jok--;
						len++;
					}else
						break;
				}else {
					len++;
				}
			}
			ans = Math.max(len, ans);
		}
		// 출력
		System.out.println(ans);

	}

}
