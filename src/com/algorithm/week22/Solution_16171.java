package com.algorithm.week22;
import java.util.*;
/*
 * 나는 친구가 적다 (Small) 
 * */
public class Solution_16171 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String text = sc.nextLine();
		String pattern = sc.nextLine();
		
		// 1) 숫자 제거 
		text = text.replaceAll("[0-9]", "");
		
		int lenText = text.length();
		int lenPattern = pattern.length();
		
		boolean flag = false;
		for(int i = 0; i <= lenText - lenPattern; i++) {
			// 동일한 패턴이 존재하는 경우 
			if(text.substring(i, i+lenPattern).equals(pattern))flag = true;
		}
		
		System.out.print(flag? 1: 0);
		
	}

}
