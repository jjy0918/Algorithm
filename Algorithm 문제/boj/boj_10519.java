package boj.y2022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10159
// 저울
public class boj_0120_10519 {

    public static int boards[][] = new int[102][102];

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int M = Integer.parseInt(bf.readLine());

        // 초기화
        for(int i=0;i<102;i++){
            for(int j=0;j<102;j++){
                boards[i][j] = 99999999;
            }
        }

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int s = Integer.parseInt(st.nextToken());

            int e = Integer.parseInt(st.nextToken());

            boards[s][e]=1;

        }

        // 플로이드-와샬
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    boards[i][j] = Integer.min(boards[i][k] + boards[k][j],boards[i][j]);
                }
            }
        }

        for(int i=1;i<=N;i++){
            // 자기 자신
            int result = 1;

            // j -> i 로 갈 수 있는지
            for(int j=1;j<=N;j++){
                if(i==j){
                    continue;
                }
                result += boards[j][i] < 99999999 ? 1 : 0 ;
            }

            // i -> j 로 갈 수 있는지
            for(int j=1;j<=N;j++){
                if(i==j){
                    continue;
                }
                result += boards[i][j] < 99999999 ? 1 : 0 ;
            }
            System.out.println(N - result);
        }
    }

}
