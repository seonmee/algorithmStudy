package com.algorithm.week22;
import java.util.*;
/*
 * 복호화
 * */
public class Solution_9046 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Character, Integer> alpha = new HashMap<>();
		ArrayList<Character> keys = new ArrayList<>();
		int T = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i<T; i++) {
			String line = sc.nextLine();
			alpha.clear();
			keys.clear();
			// 1. 알파벳 갯수 저장 : Map< 알파벳, 갯수 >
			for(int j =0, length = line.length(); j < length; j++) {
				char key = line.charAt(j);
				if(key==' ')continue;
				if(alpha.containsKey(key)) alpha.put(key, alpha.get(key)+1);
				else {
					alpha.put(key, 1);
					keys.add(key);
				}
			}
			char ans = ' ';
			int max = 0;
			for(Character k : keys) {
				if(alpha.get(k)>max) {
					max = alpha.get(k);
					ans = k;
				}
			}
			// 2. 최대값의 빈도수 체크
			int flag = 0;
			for(Character k : keys) {
				if(alpha.get(k)==max) {
					flag++;
				}
			}
			System.out.println(flag==1?ans:"?");
		}
	}

}
