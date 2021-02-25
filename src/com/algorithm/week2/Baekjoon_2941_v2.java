package com.algorithm.week2;

import java.util.Scanner;

public class Baekjoon_2941_v2 {
	static String words;
	static String[] cro = {"c=","c-","dz=","d-","lj","nj","s=","z="};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		words =sc.next();

		for (int i = 0; i < cro.length; i++) {
			words = words.replaceAll(cro[i], "O");
		}
		System.out.println(words.length());
	}

}
