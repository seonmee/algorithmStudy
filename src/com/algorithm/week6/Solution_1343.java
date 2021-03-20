package com.algorithm.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 백준 폴리오미노
public class Solution_1343 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String board = br.readLine(); // 문자열
		board = board.replaceAll("XXXX", "AAAA");
		board = board.replaceAll("XX", "BB");
		if (board.contains("X")) {
			System.out.println(-1);
		} else {
			System.out.println(board);
		}

	}

}
