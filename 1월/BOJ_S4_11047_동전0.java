package _1월4주차;

import java.io.*;
import java.util.*;

public class BOJ_S4_11047_동전0 {

	static int N; // 동전의 종류
	static int K; // 동전의 합
	static int [] coins;
	
	static int ans ; 	// 동전의 최소개수 
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		coins = new int[N];
		
		for (int i = 0; i < N; i++) {
			coins[i]= Integer.parseInt(br.readLine());
		}
		
		
		for(int i = N-1; i>=0; i--) 
		{
			if(K==0)
				break;

			System.out.println("잉");
			if(K-coins[i]<0)
				continue;
			
			ans+= K/coins[i];
			K= K%coins[i];
			
		}
		
		System.out.println(ans);

	}

}
