package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/9466
// 텀 프로젝트
public class boj_1002_9466 {


    private static int boards[] = new int[100001];
    private static boolean visited[] = new boolean[100001];
    private static boolean dfsVisited[] = new boolean[100001];
    private static int recNum=-1;
    private static int result=0;

    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(bf.readLine());

        for(int t=0;t<TC;t++){

            int n = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            result=0;
            // boards[i] = j => i->j
            Arrays.fill(boards,0);

            // 해당 노드가 이미 방문했는지 확인
            Arrays.fill(visited,false);

            // dfs 상에서 방문했는지 확인
            Arrays.fill(dfsVisited,false);

            for(int i=1;i<=n;i++){
                boards[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1;i<=n;i++){
                if(visited[i]){
                    continue;
                }

                dfs(i);
            }

            sb.append(n-result);
            sb.append("\n");

        }
        System.out.println(sb);
    }

    public static void dfs(int index){

        if(visited[index]){
            return;
        }

        // 해당 dfs에서 방문했던 경우 => 사이클 발생
        if(dfsVisited[index]){
            recNum=index;
            return;
        }

        dfsVisited[index]=true;

        dfs(boards[index]);

        if(recNum!=-1){
            result++;
            if(recNum==index){
                recNum=-1;
            }
        }
        visited[index]=true;

        dfsVisited[index]=false;


    }
}
