package com.algorithm.week1.common;

import java.util.Queue;
import java.util.LinkedList;

public class Programmers_기능개발_v2 {
	static Queue<Integer> days = new LinkedList<Integer>();
	static Queue<Integer> ans = new LinkedList<Integer>();

	public static void main(String[] args) {
		Queue<Integer> answer = solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 });
		while (!answer.isEmpty()) {
			System.out.print(answer.poll()+" ");
		}

	}
	
	public static Queue<Integer> solution(int[] progresses, int[] speeds) {
		
		for (int i = 0; i < speeds.length; i++) {
			// 일수 계산
			int day = (int)Math.ceil((double)(100 - progresses[i])/speeds[i]);
			
			if(!days.isEmpty()&&day>days.peek()) {
				ans.offer(days.size());
				days.clear();
			}
			days.offer(day);
		}
		
		ans.offer(days.size());
		return ans;
	}
}
