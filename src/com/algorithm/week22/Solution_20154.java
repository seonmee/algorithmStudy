package com.algorithm.week22;
import java.util.*;
/*
 * 이 구역의 승자는 누구야?!
 * */
public class Solution_20154 {
	static int[] numbers = {3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1}; 
	static Queue<Integer> score;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		score = new LinkedList<>();
		String line  = sc.nextLine();
		for(int i = 0, size = line.length(); i < size ; i++) {
			score.offer(numbers[line.charAt(i)-'A']);
		}
		
		while(score.size()!=1) {
			int one = score.poll();
			int two = score.poll();
			score.offer((one+two)%10);
		}
		System.out.println(score.poll()%2==1?"I'm a winner!": "You're the winner?");
	}

}
