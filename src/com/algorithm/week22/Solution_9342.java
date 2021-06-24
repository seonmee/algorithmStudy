package com.algorithm.week22;
import java.io.*;
/*
 * 영색체 
 * 
 * 문자열은 {A, B, C, D, E, F} 중 0개 또는 1개로 시작해야 한다.
 * 그 다음에는 A가 하나 또는 그 이상 있어야 한다.
 * 그 다음에는 F가 하나 또는 그 이상 있어야 한다.
 * 그 다음에는 C가 하나 또는 그 이상 있어야 한다.
 * 그 다음에는 {A, B, C, D, E, F} 중 0개 또는 1개가 있으며, 더 이상의 문자는 없어야 한다.
 * */

public class Solution_9342 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		String regex = "^[A-E]?A+F+C+[A-E]?$";
		String ans = "";
		
		for(int t = 0; t < T; t++) {
			String word = br.readLine();
			ans = word.matches(regex)?"Infected!":"Good";
			System.out.println(ans);
		}
	}

}
