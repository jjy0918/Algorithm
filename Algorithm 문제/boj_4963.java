package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/4963
// 섬의 개수
public class boj_0921_4963 {

    private static int dy[]={-1,-1,0,1,1,1,0,-1};
    private static int dx[]={0,1,1,1,0,-1,-1,-1};


    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int w,h;

        StringTokenizer st = new StringTokenizer(bf.readLine());

        w=Integer.parseInt(st.nextToken());
        h=Integer.parseInt(st.nextToken());

        while(w!=0){

            int boards[][] = new int[h][w];

            for(int y=0;y<h;y++){
                st = new StringTokenizer(bf.readLine());
                for(int x=0;x<w;x++){
                    boards[y][x]=Integer.parseInt(st.nextToken());
                }
            }

            boolean visited[][] = new boolean[h][w];

            int result=0;

            for(int y=0;y<h;y++){
                for(int x=0;x<w;x++){
                    if(visited[y][x] || boards[y][x]==0){
                        continue;
                    }
                    bfs(y,x,boards,visited,h,w);
                    result++;
                }
            }

            st = new StringTokenizer(bf.readLine());

            w=Integer.parseInt(st.nextToken());
            h=Integer.parseInt(st.nextToken());

            System.out.println(result);

        }


    }

    public static void bfs(int y,int x, int boards[][], boolean visited[][],int h,int w){
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(y,x));
        visited[y][x]=true;

        while(!q.isEmpty()){
            pair nowPair = q.poll();

            for(int d=0;d<8;d++){

                int ny = nowPair.y+dy[d];
                int nx = nowPair.x+dx[d];

                if(ny < 0 || nx < 0 || ny >= h || nx >= w || boards[ny][nx]==0 || visited[ny][nx]){
                    continue;
                }
                visited[ny][nx]=true;
                q.add(new pair(ny,nx));

            }


        }
    }

    public static class pair{
        int y,x;

        public pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
