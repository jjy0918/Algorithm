package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/13023
// ABCDE
public class boj_1003_13023 {
    public static List<Integer> arr[] = new ArrayList[2001];
    public static boolean visited[] = new boolean[2001];
    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N, M;

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<2001;i++){
            arr[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            int a,b;
            st = new StringTokenizer(bf.readLine());
            a= Integer.parseInt(st.nextToken());
            b= Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for(int i=0;i<N;i++){
            visited[i]=true;
            if(check(i,1)){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);

    }

    public static boolean check(int index,int cnt){

        if(cnt==5){
            return true;
        }

        for(int nextIndex : arr[index]){
            if(visited[nextIndex]){
                continue;
            }
            visited[index]=true;
            if(check(nextIndex,cnt+1)){
                return true;
            }
            visited[index]=false;
        }

        return false;
    }
}
