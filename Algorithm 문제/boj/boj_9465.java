package boj.y2022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/9465
// 스티커
public class boj_0218_9465 {

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());

        while(t-->0){
            int N = Integer.parseInt(bf.readLine());
            int boards[][] = new int[2][N];
            int check[][] = new int[3][N]; // 0 선택, 1선택, 2=> 둘 다 선택 안함.

            int result = 0;

            for(int i=0;i<2;i++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++){
                    boards[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            check[0][0]=boards[0][0];
            check[1][0]=boards[1][0];
            for(int x=1;x<N;x++){

                check[0][x] = Integer.max(check[1][x-1], check[2][x-1]) + boards[0][x];

                check[1][x] = Integer.max(check[0][x-1], check[2][x-1]) + boards[1][x];

                check[2][x] = Integer.max(check[0][x-1], check[1][x-1]);
                check[2][x] = Integer.max(check[2][x], check[2][x-1]);

            }
            for(int x=0;x<3;x++){
                result = Integer.max(result, check[x][N-1]);
            }

            System.out.println(result);
        }
    }
}
