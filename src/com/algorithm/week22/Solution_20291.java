package com.algorithm.week22;
import java.util.*;
import java.io.*;
/*
 * 파일정리 
 * 
 * 파일을 확장자 별로 정리해서 몇 개씩 있는지 알려줘
 * 보기 편하게 확장자들을 사전 순으로 정렬해 줘
 * 
 * */
public class Solution_20291 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> files = new TreeMap<>();
		for(int i = 0; i < N; i++) {
			// split은 정규식으로 구분하기 때문에 메타문자 주의 
			String[] line = br.readLine().split("\\.");
			String key = line[1];
			if(files.containsKey(key))
				files.put(key, files.get(key)+1);
			else
				files.put(key, 1);
		}
		Object[] extension = files.keySet().toArray();
		
		for(int i = 0; i < files.size(); i++) {
			System.out.println(extension[i] + " " + files.get(extension[i]));
		}
	}

}
