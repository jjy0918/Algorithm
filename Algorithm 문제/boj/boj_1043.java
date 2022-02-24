package boj.y2022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1043
// 거짓말
public class boj_0224_1043 {

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean truePerson[] = new boolean[51];
        st = new StringTokenizer(bf.readLine());
        int TPN = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<TPN;i++){
            int n = Integer.parseInt(st.nextToken());
            q.add(n);
        }

        Set<Integer> party[] = new HashSet[M];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine());

            int p = Integer.parseInt(st.nextToken());
            party[i] = new HashSet<>();
            for(int j=0;j<p;j++){
                int n = Integer.parseInt(st.nextToken());
                party[i].add(n);
            }
        }

        while (!q.isEmpty()){
            int n = q.poll();
            if(truePerson[n]){
                continue;
            }
            truePerson[n] = true;

            for(int i=0;i<M;i++){
                if(party[i].contains(n)){
                    for(int p : party[i]){
                        if(truePerson[p]){
                            continue;
                        }
                        q.add(p);
                    }
                }
            }
        }

        int result = 0;
        for(int i=0;i<M;i++){
            boolean isRealParty = true;
            for(int p : party[i]){
                if(truePerson[p]){
                    isRealParty = false;
                    break;
                }
            }
            if(isRealParty){
                result++;
            }
        }
        System.out.println(result);

    }
}
