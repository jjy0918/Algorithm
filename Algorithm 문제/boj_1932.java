package boj.y2022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1932
// 정수 삼각형
public class boj_0113_1932 {

    private static int boards[][] = new int[502][502];
    private static int value[][] = new int[502][502];

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=i;j++){
                boards[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                boards[i][j]+=Integer.max(boards[i-1][j],boards[i-1][j-1]);
            }
        }

        int result=0;

        for(int i=1;i<=N;i++){
            result = Integer.max(result,boards[N][i]);
        }

        System.out.println(result);

    }
}

