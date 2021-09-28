package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/5427
// 불
public class boj_0928_5427 {

    private static int dy[]={0,0,-1,1};
    private static int dx[]={1,-1,0,0};

    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(bf.readLine());

        for(int t=0;t<tc;t++){

            StringTokenizer st = new StringTokenizer(bf.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            char boards[][] = new char[Y][X];
            int fire[][] = new int[Y][X];
            int visited[][] = new int[Y][X];
            Queue<Pair> q = new LinkedList<>();

            Pair startNode=null;

            for(int i=0;i<Y;i++){
                String s = bf.readLine();
                for(int j=0;j<X;j++){
                    visited[i][j]=Integer.MAX_VALUE;
                    fire[i][j]=Integer.MAX_VALUE;
                    boards[i][j]=s.charAt(j);
                    if(boards[i][j]=='*'){
                        q.add(new Pair(i,j));
                        fire[i][j]=0;
                    }

                    if(boards[i][j]=='@'){
                        startNode = new Pair(i,j);
                        visited[i][j]=0;
                    }
                }
            }

            while(!q.isEmpty()){

                Pair nowPair = q.poll();

                for(int d=0;d<4;d++){

                    int ny = nowPair.y+dy[d];
                    int nx = nowPair.x+dx[d];

                    int cnt = fire[nowPair.y][nowPair.x]+1;

                    if(ny < 0 || nx < 0 || ny >= Y || nx >= X || boards[ny][nx]=='#' || fire[ny][nx] <= cnt){
                        continue;
                    }

                    fire[ny][nx]=cnt;

                    q.add(new Pair(ny,nx));

                }
            }

            q.add(startNode);

            int result=-1;

            while (!q.isEmpty() && result==-1){

                Pair nowPair = q.poll();

                for(int d=0;d<4;d++){

                    int ny = nowPair.y+dy[d];
                    int nx = nowPair.x+dx[d];

                    int cnt = visited[nowPair.y][nowPair.x]+1;

                    if(ny < 0 || nx < 0 || ny >= Y || nx >= X ){
                        result=cnt;
                        break;
                    }

                    if(boards[ny][nx]=='#' || visited[ny][nx] <= cnt || fire[ny][nx] <= cnt){
                        continue;
                    }

                    visited[ny][nx]=cnt;

                    q.add(new Pair(ny,nx));

                }

            }
            if(result==-1){
                System.out.println("IMPOSSIBLE");
            }
            else{
                System.out.println(result);
            }
        }

    }

    static class Pair{
        int y,x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
