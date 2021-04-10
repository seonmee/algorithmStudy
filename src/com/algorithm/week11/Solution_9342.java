package com.algorithm.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_9342 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String regex = "^[A-F]?A+F+C+[A-F]?$";
		
		for(int i=0;i<N;i++) {
			String word = br.readLine();
			if(word.matches(regex)) {
				System.out.println("Infected!");
			}else {
				System.out.println("Good");
			}
		}
	}

}
