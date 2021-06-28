package com.algorithm.week23;
import java.util.*;
public class Solution_17413 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] alpha = sc.nextLine().toCharArray();
		Stack<Character> word = new Stack<>();
		
		boolean flag = false; // 괄호가 열렸는지 체크 
		for(int i = 0, size = alpha.length; i<size;i++) {
			if(alpha[i]=='<') {
				while(!word.isEmpty()) {
					System.out.print(word.pop());
				}
				System.out.print(alpha[i]);
				flag = true;
			}else if(alpha[i]=='>') {
				System.out.print(alpha[i]);
				flag = false;
			}
			else if(flag) {
				System.out.print(alpha[i]);
			}else {
				if(alpha[i]==' ') {
					while(!word.isEmpty()) {
						System.out.print(word.pop());
					}
					System.out.print(alpha[i]);
				}
				else word.add(alpha[i]);
			}
		}
		while(!word.isEmpty()) {
			System.out.print(word.pop());
		}
	}

}
