package com.algorithm.week1.common;

import java.util.Queue;
import java.util.LinkedList;

public class Programmers_기능개발 {
	static Queue<Integer> day = new LinkedList<Integer>();
	static Queue<Integer> ans = new LinkedList<Integer>();

	public static void main(String[] args) {
		Queue<Integer> answer = solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 });
		while (!answer.isEmpty()) {
			System.out.print(answer.poll()+" ");
		}

	}
	
	public static Queue<Integer> solution(int[] progresses, int[] speeds) {
		// 일수 계산
		for (int i = 0; i < speeds.length; i++) {
			int per = 100 - progresses[i];
			if (per % speeds[i] != 0) {
				per = per / speeds[i] + 1;
			} else {
				per = per / speeds[i];
			}
			day.offer(per);
		}
		int cnt = 1;
		int front = day.poll();
		// e.g. 7 > 3 < 9
		//      1
		//          2   1
		while (!day.isEmpty()) {
			// 앞에 일수가 크면
			if (front >= day.peek()) {
				cnt++;
				day.poll();
			} else {
				// 이전 일수 저장
				ans.offer(cnt);
				// front 변경
				cnt = 1;
				front = day.poll();
			}

		}
		ans.offer(cnt);
		return ans;
	}
}
