package com.algorithm.week21;

import java.util.*;
/*
 * 카드2
 */
public class Solution_2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <=N ; i++) {
			queue.offer(i);
		}
		while(queue.size()!=1) {
			queue.poll();  // 버림 
			queue.offer(queue.poll()); // 뒤로 이동 
		}
		System.out.print(queue.poll());
	}

}
