package com.algorithm.week22;
import java.util.*;
/*
 * 경고 
 * hh:mm:ss
 * */
public class Solution_3029 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] current = sc.nextLine().split(":");
		String[] throwTime = sc.nextLine().split(":");
		StringBuilder ans = new StringBuilder("");
		
		int throwHour = Integer.parseInt(throwTime[0]);
		int currentHour = Integer.parseInt(current[0]);
	
		int throwMinute = Integer.parseInt(throwTime[1]);
		int currentMinute = Integer.parseInt(current[1]);
		
		int throwSecond = Integer.parseInt(throwTime[2]);
		int currentSecond = Integer.parseInt(current[2]);
		
		if(throwSecond < currentSecond) {
			throwSecond += 60;
			throwMinute--;
		}
		if(throwMinute < currentMinute) {
			throwMinute += 60;
			throwHour--;
		}
		if(throwHour < currentHour) throwHour += 24;

		
		int h = throwHour - currentHour;
		int m = throwMinute - currentMinute;
		int s = throwSecond - currentSecond;
		
		if(h==0 && m==0 && s==0) System.out.println("24:00:00");
		else System.out.format("%02d:%02d:%02d", h, m ,s);
		
//		if(h<10) ans.append("0");
//		ans.append(h).append(":");
//		if(m<10) ans.append("0");
//		ans.append(m).append(":");
//		if(s<10) ans.append("0");
//		ans.append(s);
//		
//		System.out.println(ans.toString());
		
	}

}
