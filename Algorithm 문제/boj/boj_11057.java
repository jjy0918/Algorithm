package boj.y2022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
// https://www.acmicpc.net/problem/11057
// 오르막 수
public class boj_0222_11057 {

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int boards[][] = new int[1001][11];

        int result = 0;

        for(int i=0;i<10;i++){
            boards[1][i] = 1;
        }

        for(int i=2;i<=N;i++){
            boards[i][0] = boards[i-1][0];
            for(int j=1;j<10;j++){
                boards[i][j] = (boards[i-1][j] + boards[i][j-1]) % 10007;
            }
        }

        for(int i=0;i<10;i++){
            result = (result + boards[N][i]) % 10007;
        }

        System.out.println(result);
    }
}
