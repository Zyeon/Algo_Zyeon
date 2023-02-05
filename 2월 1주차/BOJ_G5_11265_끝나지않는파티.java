package _2월1주차;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/11265
 * @author Zizon_Yonni
 *
 * 문제점 두가지
 * 
 *
 */
public class BOJ_G5_11265_끝나지않는파티 {

	static int N,M; // 파티장, 인간
	static int[][] matrix;	// 파티장
	static int dist[][];
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		dist = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			st= new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				dist[r][c]= Integer.parseInt(st.nextToken());
			}
		}
		
		for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						dist[i][j]=Integer.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
				}
			}
		
		for (int t = 0; t < M; t++) {
			st=new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());		// 서비스요청 파티장 번호
			int B = Integer.parseInt(st.nextToken());		// 다음 파티
			int C = Integer.parseInt(st.nextToken());		// 파티가 열리는데 걸리는 시간
			
			if(dist[A-1][B-1]<=C)
				sb.append("Enjoy other party").append("\n");
			else
				sb.append("Stay here").append("\n");
			
			
		}	
		
		System.out.println(sb);
	}

}
