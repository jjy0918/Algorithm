package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1405
// 미친 로봇
public class boj_0912_1405 {

    final static int E=0,W=1,S=2,N=3;

    static int notSimple=0;
    static double simple=0;

    static int dy[]={0,0,1,-1};
    static int dx[]={1,-1,0,0};

    static boolean visited[][] = new boolean[100][100];

    static double direction[] = new double[4];



    static void dfs(int y,int x, int cnt,boolean isNotSimple, double result){

        if(visited[y][x]){
            simple+=result;
            return;
        }

        if(cnt==0){
            return;
        }

        visited[y][x]=true;

        for(int d=0;d<4;d++){

            int ny = y+dy[d];
            int nx = x+dx[d];

            dfs(ny,nx,cnt-1,isNotSimple,result*direction[d]);

        }

        visited[y][x]=false;
    }



    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int cnt= Integer.parseInt(st.nextToken());
        direction[E] = Double.parseDouble(st.nextToken()) / 100.0;
        direction[W] = Double.parseDouble(st.nextToken()) / 100.0;
        direction[S] = Double.parseDouble(st.nextToken()) / 100.0;
        direction[N] = Double.parseDouble(st.nextToken()) / 100.0;

        dfs(50,50,cnt,false,1);

        System.out.println(1.0-simple);

    }
}
