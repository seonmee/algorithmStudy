package com.algorithm.week22;
import java.util.*;
/*
 * !밀비 급일 
 */
public class Solution_11365 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder ans = new StringBuilder("");
		String line = "";
		
		while(true) {
			line = sc.nextLine();
			if(line.equals("END")) break;
			
			char[] arr = line.toCharArray();
			// 역으로 출력 
			for(int i = line.length()-1; i>=0; i--) {
				ans.append(arr[i]);
			}
			ans.append("\n");
		}
		System.out.println(ans.toString());
	}

}
