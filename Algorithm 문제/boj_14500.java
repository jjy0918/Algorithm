package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_0919_14500 {
    private static int result=0;

    private static int dy[][]={
            {0,0,0,0},
            {0,0,1,1},
            {0,1,2,2},
            {0,1,1,2},
            {0,0,0,1}
    };

    private static int dx[][]={
            {0,1,2,3},
            {0,1,0,1},
            {0,0,0,1},
            {0,0,1,1},
            {0,1,2,1}
    };

    public static void solution(BufferedReader bf) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int boards[][] = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                boards[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<4;i++){
            boards = rotationArr(boards,N,M);
            N = boards.length;
            M = boards[0].length;
            go(boards,N,M);

            mirrorArr1(boards,N,M);
            go(boards,N,M);

            mirrorArr2(boards,N,M);
            go(boards,N,M);

            mirrorArr1(boards,N,M);
            go(boards,N,M);

            mirrorArr2(boards,N,M);
        }



        System.out.println(result);

    }

    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        solution(bf);
    }

    public static int[][] rotationArr(int boards[][],int N,int M){

        int newBoards[][] = new int[M][N];

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                newBoards[i][j] = boards[j][M-i-1];
            }
        }

        return newBoards;
    }

    public static int[][] mirrorArr1(int boards[][],int N,int M){
        for(int i=0;i<N;i++){
            for(int j=0;j<M/2;j++){
                int tmp = boards[i][j];
                boards[i][j] = boards[i][M-j-1];
                boards[i][M-j-1] = tmp;
            }
        }

        return boards;
    }

    public static int[][] mirrorArr2(int boards[][],int N,int M){

        for(int i=0;i<N/2;i++){
            for(int j=0;j<M;j++){
                int tmp = boards[i][j];
                boards[i][j] = boards[N-i-1][j];
                boards[N-i-1][j] = tmp;
            }
        }

        return boards;
    }

    public static void go(int boards[][],int N,int M){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                for(int d1=0;d1<5;d1++){
                    boolean isPossible=true;
                    int sum=0;
                    for(int d2=0;d2<4;d2++){
                        int ny = i+dy[d1][d2];
                        int nx = j+dx[d1][d2];
                        if(ny < 0 || nx < 0 || ny >= N || nx >= M){
                            isPossible=false;
                            break;
                        }
                        sum+=boards[ny][nx];
                    }
                    if(isPossible){
                        result=Integer.max(result,sum);
                    }
                }
            }
        }
    }


}
