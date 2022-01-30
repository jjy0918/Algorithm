import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14503
// 로봇 청소기
public class Main {

    private static int N,M;

    private static boolean visited[][];

    private static int boards[][];

    private static int dy[]={-1,0,1,0};
    private static int dx[]={0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boards = new int[N][M];
        visited =new boolean[N][M];

        st = new StringTokenizer(bf.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                boards[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        visited[y][x]=true;

        System.out.println(rec(y,x,d,1));
    }

    public static int rec(int y,int x,int d,int cnt){

        for(int i=1;i<=4;i++){
            // 왼쪽 방향 보기
            int nd = (d-i+4)%4;
            int ny = y+dy[nd];
            int nx = x+dx[nd];

            if(ny < 0 || nx < 0 || ny >= N || nx >= M || boards[ny][nx]==1 || visited[ny][nx]){
                continue;
            }
            // 2-a. 왼쪽 방향 살펴보기
            visited[ny][nx]=true;
            return rec(ny,nx,nd,cnt+1);

        }

        int ny = y-dy[d];
        int nx = x-dx[d];
        if(ny < 0 || nx < 0 || ny >= N || nx >= M || boards[ny][nx]==1){
            return cnt;
        }

        return rec(ny,nx,d,cnt);

    }
}
