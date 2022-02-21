package boj.y2022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/2294
// 동전 2
public class boj_0223_2294 {

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> coins = new ArrayList<>();

        int cnt[] = new int[10001];

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<N;i++){
            int c = Integer.parseInt(bf.readLine());
            if( c > 10000){
                continue;
            }
            q.add(c);
            cnt[c] = 1;
            coins.add(c);
        }

        int result = -1;

        while(!q.isEmpty() && result == -1){
            int nowIndex = q.poll();

            for(int i=0;i<coins.size();i++){
                int nextIndex = nowIndex + coins.get(i);

                if(nextIndex>10000 || cnt[nextIndex] != 0){
                    continue;
                }

                cnt[nextIndex] = cnt[nowIndex]+1;

                if(nextIndex == K){
                    result = cnt[nextIndex];
                    break;
                }
                q.add(nextIndex);
            }

        }

        System.out.println(result);

    }
}
