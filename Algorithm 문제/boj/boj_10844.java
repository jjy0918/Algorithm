package boj.y2022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10844
// 쉬운 계단 수
public class boj_0112_10844 {

    private static int dp[][] = new int[101][11];

    private static int dNum = 1000000000;

    private static int N=0;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        for(int i=1;i<10;i++){
            dp[1][i]=1;
        }

        findStairsNum(2);

        int sum=0;

        for(int i=0;i<10;i++){
            sum=(sum+dp[N][i])%dNum;
        }

        System.out.println(sum);

    }

    public static void findStairsNum(int num){
        if(num>N){
            return ;
        }
        for(int i=0;i<10;i++){
            if(i!=0){
                dp[num][i]=dp[num-1][i-1];
            }
            if(i!=9){
                dp[num][i]+=dp[num-1][i+1]%dNum;
            }
            dp[num][i]%=dNum;
        }
        findStairsNum(num+1);
    }

}
