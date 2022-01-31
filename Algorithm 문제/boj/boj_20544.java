package program;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_20544 {
	// dp[i] = i번째 바닥인 경우
	// dp[i] = dp[i-3]*3 + dp[i-2]*2 +dp[i-1]
	/*
	0 0 0 0
	0 1 0 0
	0 2 0 0
	0 0 1 0
	0 0 2 0
	0 1 1 0
	0 1 2 0
	0 2 1 0
	dp[i][0] => i번째 땅인데 2가 하나도 없는 경우
	dp[i][1] => i번째 땅인데 2가 하나라도 나온 경우
	dp[i][0] = dp[i-1][0] + dp[i-2][0] + dp[i-3][0]
	dp[i][1] = dp[i-1][1] + dp[i-2][0] + dp[i-2][1]*2 + dp[i-3][0]*2 + dp[i-3][1]*3
	 */
	public static long dp[][] = new long[1002][2];
	public static void main(String[] args) throws IOException{

		System.setIn(new FileInputStream("input.txt"));

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine()) + 1;

		dp[0][0] = 0;
		dp[0][1]= 1;
		dp[1][0] = 1;
		dp[1][1] = 0;
		dp[2][0] = 1;
		dp[2][1] = 0;
		dp[3][0] = 2;
		dp[3][1] = 1;


		for(int i=4;i<=N;i++){
			dp[i][0] = dp[i-1][0] + dp[i-2][0] + dp[i-3][0];
			dp[i][0]%=1000000007;
			dp[i][1] = dp[i-1][1] + dp[i-2][0] + dp[i-2][1]*2 + dp[i-3][0]*2 + dp[i-3][1]*3;
			dp[i][1]%=1000000007;
		}
		System.out.println(dp[N][1]);

	}

}
