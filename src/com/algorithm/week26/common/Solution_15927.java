package com.algorithm.week26.common;
import java.util.*;
/*
 * 회문은 회문이 아니야! 
 * */
public class Solution_15927 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		int start = 0;
		int end = line.length()-1;
		
		
		//  palndrom인지 확인 
		boolean flag = true;
		// 같은 문자로만 이루어져 있는 지 확인 
		int num = line.charAt(start)-'0';
		boolean check = true;
		
		while(start<end) {
			if(line.charAt(start)==line.charAt(end)) {
				start++;
				end--;
				if(num!=line.charAt(end)-'0') check = false;
			}else {
				// 아닌 경우 
				flag = false;
				break;
			}
		}
		if(!flag) {
			System.out.println(line.length());
		}else {
			if(check)System.out.println(-1);
			else System.out.println(line.length()-1);
		}
		
	}

}
