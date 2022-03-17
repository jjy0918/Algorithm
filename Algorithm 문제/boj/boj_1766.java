package boj.y2022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_0317_1766 {

    public static List<Integer> nextIndex[] = new ArrayList[32001];
    public static int cnt[] = new int[32001];

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=1;i<=N;i++) {
            nextIndex[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nextIndex[a].add(b);
            cnt[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1;i<=N;i++) {
            if(cnt[i] == 0) {
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {
            int n = pq.poll();
            sb.append(n);
            sb.append(" ");

            nextIndex[n].forEach(it -> {
                cnt[it]--;
                if(cnt[it]==0){
                    pq.add(it);
                }
            });
        }

        System.out.println(sb);

    }
}
