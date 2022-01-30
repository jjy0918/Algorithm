package boj.y2022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2573
// 빙산
public class boj_0116_2573 {

    public static int boards[][] = new int[301][301];

    public static int N, M;

    public static int dy[] = new int[]{1,-1,0,0};
    public static int dx[] = new int[]{0,0,1,-1};

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        int result=0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                boards[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            if(isSeperated()){
                break;
            }
            if(seperate()){
                result=0;
                break;
            }
            result++;
        }

        System.out.println(result);

    }

    public static boolean seperate(){

        int result[][] = new int[301][301];

        boolean isFinish=true;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(boards[i][j]>0){
                    continue;
                }

                for(int d=0;d<4;d++){
                    int ny = i+dy[d];
                    int nx = j+dx[d];

                    if(ny < 0 || nx < 0 || ny >= N || nx >= M ){
                        continue;
                    }

                    result[ny][nx]--;

                }

            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                boards[i][j]+=result[i][j];
                if(boards[i][j]>=0){
                    isFinish=false;
                }
            }
        }
        return isFinish;
    }

    public static boolean isSeperated(){
        boolean check[][] = new boolean[301][301];

        int cnt=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(check[i][j] || boards[i][j]<=0){
                    continue;
                }

                check[i][j]=true;
                cnt++;

                Queue<Node> q = new LinkedList<>();
                q.add(new Node(i,j));

                while(!q.isEmpty()){
                    Node nowNode = q.poll();

                    for(int d=0;d<4;d++){
                        int ny = nowNode.y+dy[d];
                        int nx = nowNode.x+dx[d];

                        if(ny < 0 || nx < 0 || ny >= N || nx >= M ){
                            continue;
                        }

                        if(check[ny][nx] || boards[ny][nx]<=0){
                            continue;
                        }

                        check[ny][nx]=true;
                        q.add(new Node(ny,nx));

                    }

                }

            }
        }

        return cnt >= 2;

    }

    public static class Node{
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
