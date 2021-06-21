package com.algorithm.week22;
import java.util.*;
/*
 * 세로읽기 
 * */
public class Solution_10798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    char[][] alpha = new char[5][15];
		
	    for(int r = 0; r<5 ; r++) {
	    	String line =  sc.nextLine();
	    	for(int c =0; c<line.length() ; c++) {
	    		alpha[r][c] = line.charAt(c);
	    	}
	    }
	    StringBuilder ans = new StringBuilder("");
	    for(int c = 0; c<15 ; c++) {
	    	for(int r =0; r<5; r++) {
	    		if(alpha[r][c]!='\0') ans.append(alpha[r][c]);
	    	}
	    }
	    System.out.println(ans.toString());
	}

}
