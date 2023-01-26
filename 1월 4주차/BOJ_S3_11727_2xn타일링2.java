package _1월4주차;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11727
 * @author Zizon_Yonni
 *
 */

public class BOJ_S3_11727_2xn타일링2 {

	static int N;
	static int dp[] ;
	static int ans;
	
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[1001];
		
		dp[0]=0;
		dp[1] =1;
		dp[2] =3;
		
		for(int i=3; i<N+1; i++) 
		{
			dp[i]= (2*dp[i-2]+dp[i-1])%10007;
		}
		
		System.out.println(dp[N]);
		
//		ans = dp(N);
//		
//		System.out.println(dp(N)%10007);
		
	}
	
	// 재귀 -> 시간초과
	/*
	public static int dp(int n) 
	{
		if(n==1)
			return 1;
		if(n==2)
			return 3;
		
		return 2*dp(n-2)+dp(n-1);
	}
*/
}
/*
 * 점화식 세웠으면 메모이제이션으로 실행한다.
 * 재귀 -> 시간초과
 * 
 * 메모이제이션 : 메모리를 더 할당하는 대신 시간을 줄여줌
 */

/*
 * dp = new int[1001]; 는 통과되고
 * dp = new int[N+1]; 은 왜 ArrayIndexOfOutOfBounds
 */
