package _1월4주차;

import java.io.*;
import java.util.*;
/**
 * https://www.acmicpc.net/problem/10808
 * @author Zizon_Yonni
 *
 */
public class BOJ_B4_10808_알파벳개수 {

	static String input;
	static int [] alpha = new int[26];
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		input = br.readLine();
		int length = input.length();
		
		for(int i =0; i<length;i++)
		{
			int c = (int)input.charAt(i)-97;
			
			alpha[c]++;
					
		}
		
		for(int i =0; i<26;i++) 
		{
			sb.append(alpha[i]).append(" ");
		}
		
		System.out.println(sb);
	}

}

/*
 * 이전에 풀었던 문제
 * 메모리 12812KB -> 11504KB
 * 시간 108ms -> 76ms
 * 
 * 시간&메모리 줄어든 이유
 * 문자열 붙이기의 올바른 사용. 
 * 이전코드도 StringBuilder를 사용했으나
 * 문자열 만드는 부분에서 append().append()로 체이닝 하는것이 아니라
 * append(" " +" " )로 해서 손실이 있었음
 */
