package _1월4주차;

import java.io.*;
import java.util.*;
/**
 * https://www.acmicpc.net/problem/1932
 * @author Zizon_Yonni
 *
 */
public class BOJ_S1_1932_정수삼각형 {
	static int N;
	static int ans;
	
//	static int input [][]= new int[501][501];
//	static int dp[][]=new int[6][6];
	
	static int input [][];
	static int dp[][];
	
	public static void main(String[] args)throws IOException {

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		N = Integer.parseInt(br.readLine());
		
		input = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		
		input[1][1] = Integer.parseInt(br.readLine());
		
		if(N>=2) 
		{
			for (int i = 2; i <= N; i++) {
				st =new StringTokenizer(br.readLine());
				for (int j = 1; j <= i; j++) {
					input[i][j]=Integer.parseInt(st.nextToken());
				}
			}
		}
		
		//System.out.println(Arrays.deepToString(input));
		
		dp[1][1]=input[1][1];
		ans=dp[1][1];
		if(N>=2) 
		{
			for(int i=2;i<=N;i++) 
			{
				for(int j=1;j<=i;j++) 
				{
					dp[i][j]= Integer.max(dp[i-1][j-1],dp[i-1][j])+ input[i][j];
					
					if(i==N) 
					{
						ans=Integer.max(ans, dp[i][j]);
					}
				}
			}
		}
		
		//System.out.println(Arrays.deepToString(dp));

		System.out.println(ans);
		
	}

}
