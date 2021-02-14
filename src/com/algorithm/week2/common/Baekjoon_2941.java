package com.algorithm.week2.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2941 {
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine().trim();
		int length = st.length();

		for (int i = 0; i < length; i++) {

			char front = st.charAt(i);
			switch (front) {
			case 'c':
				if (i < length - 1) {
					if (st.charAt(i + 1) == '=' || st.charAt(i + 1) == '-') {
						i++;
					}
				}
				break;
			case 'd':
				if (i < length - 1) {
					if (st.charAt(i + 1) == '-') {
						i++;
					}
				}
				if (i < length - 2) {
					if (st.charAt(i + 1) == 'z' && st.charAt(i + 2) == '=') {
						i += 2;
					}
				}
				break;
			case 'l':
			case 'n':
				if (i < length - 1) {
					if (st.charAt(i + 1) == 'j') {
						i++;
					}
				}
				break;
			case 's':
			case 'z':
				if (i < length - 1) {
					if (st.charAt(i + 1) == '=') {
						i++;
					}
				}
				break;
			default:
				break;
			}
			ans++;
		}
		System.out.println(ans);

	}

}
