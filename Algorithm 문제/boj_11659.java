package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11659
// 구간 합 구하기4
public class boj_0912_11659 {

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int sum[] = new int[N+1];

        st = new StringTokenizer(bf.readLine());

        for(int i=1;i<=N;i++){
            sum[i] = sum[i-1]+Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken()) ;
            int e = Integer.parseInt(st.nextToken());

            sb.append(sum[e] - sum[s-1]).append("\n");
        }

        System.out.println(sb);
    }
}
