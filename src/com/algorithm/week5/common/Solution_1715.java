package com.algorithm.week5.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// 카드 정렬
public class Solution_1715 {
	static int N;
	static Queue<Long> cards;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 오름차순 정렬
		cards = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			cards.offer(Long.parseLong(br.readLine()));
		}
		// 로직
		// e.g. 10 20 30 40
		// 30 (10 + 20)  30  40
		// 40 60 (30 + 30)
		// 100 (40 + 60)
		long ans = 0, sum = 0;
		while (cards.size() != 1) {
			sum = cards.poll() + cards.poll();
			ans+=sum;
			cards.offer(sum);
		}
		// 출력
		System.out.println(ans);
	}
}
