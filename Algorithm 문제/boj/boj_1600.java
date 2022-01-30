import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// boj.1600 말이 되고픈 원숭이
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter out  = new BufferedWriter(new OutputStreamWriter(System.out));

        //int T=10;

        int dy1[] = {0,0,1,-1};
        int dx1[] = {1,-1,0,0};

        int dy2[] = {1,1,2,2,-1,-1,-2,-2};
        int dx2[] = {-2,2,-1,1,2,-2,1,-1};


        int K = Integer.parseInt(bf.readLine());
        String s[] = bf.readLine().split(" ");
        int W = Integer.parseInt(s[0]);
        int H = Integer.parseInt(s[1]);

        int boards[][] = new int[H][W];

        int check[][][] = new int[H][W][K+1];

        StringTokenizer st;

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(bf.readLine(), " ");

            for (int j = 0; j < W; j++) {
                boards[i][j] = Integer.parseInt(st.nextToken());

                for(int k=0;k<K+1;k++){
                    check[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        for(int k=0;k<K+1;k++){
            check[0][0][k] = 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,0,K));

        int result = Integer.MAX_VALUE;

        while(!q.isEmpty()){

            Pair nowPair = q.poll();

            for(int i=0;i<4;i++){
                int ny = nowPair.y + dy1[i];
                int nx = nowPair.x + dx1[i];

                if(ny < 0 || nx < 0 || ny >= H || nx >= W || boards[ny][nx]==1 || nowPair.cnt + 1 >= check[ny][nx][nowPair.k]) {
                    continue;
                }

                check[ny][nx][nowPair.k] = nowPair.cnt+1;
                q.add(new Pair(ny,nx,nowPair.cnt+1,nowPair.k));
            }

            if(nowPair.k > 0){
                for(int i=0;i<8;i++){
                    int ny = nowPair.y + dy2[i];
                    int nx = nowPair.x + dx2[i];

                    if(ny < 0 || nx < 0 || ny >= H || nx >= W || boards[ny][nx]==1 || nowPair.cnt + 1 >= check[ny][nx][nowPair.k-1]) {
                        continue;
                    }

                    check[ny][nx][nowPair.k-1] = nowPair.cnt+1;
                    q.add(new Pair(ny,nx,nowPair.cnt+1,nowPair.k-1));
                }
            }

        }

        for(int i=0;i<=K;i++){
            result = Integer.min(result,check[H-1][W-1][i]);
        }

        if(result==Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(result);
        }



        //StringTokenizer st = new StringTokenizer(bf.readLine()," ");

    }

    static class Pair{
        int y;
        int x;
        int cnt;
        int k;

        public Pair(int y, int x, int cnt,int k) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.k = k;
        }
    }
}




