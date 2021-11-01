import javax.jws.soap.SOAPBinding;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// boj 1194 달이 차오른다, 가자.
public class Main {

    public static Character boards[][];

    public static boolean visited[][][];

    public static int result=Integer.MAX_VALUE;

    public static int N;
    public static int M;

    public static int dy[]={0,0,1,-1};
    public static int dx[]={1,-1,0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter out  = new BufferedWriter(new OutputStreamWriter(System.out));

        //int T=10;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M][1<<6];

        boards = new Character[N][M];

        pair start = null;

        for(int i=0;i<N;i++){
            String now = bf.readLine();
            for(int j=0;j<M;j++){
                boards[i][j] = now.charAt(j);
                if (boards[i][j]=='0'){
                    start = new pair(i,j,0,0);
                }

            }
        }

        System.out.println(bfs(start));

        //StringTokenizer st = new StringTokenizer(bf.readLine()," ");

    }

    public static int bfs(pair startIndex){

        Queue<pair> q = new LinkedList<>();

        q.add(startIndex);

        visited[startIndex.y][startIndex.x][startIndex.key] = true;

        while(!q.isEmpty()){

            pair nowIndex = q.poll();

            for(int d = 0 ;d<4;d++){

                int ny = nowIndex.y+dy[d];
                int nx = nowIndex.x+dx[d];
                int ncnt = nowIndex.cnt + 1;
                int nkey = nowIndex.key;

                if(ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx][nowIndex.key] || boards[ny][nx]=='#'){
                    continue;

                }

                if(boards[ny][nx] == '1'){
                    return ncnt;
                }

                if(boards[ny][nx] >= 'A' && boards[ny][nx] <= 'F'){

                    int nowDoor = 1<<(boards[ny][nx]-'A');

                    // 내 키로 들어갈 수 있는 문이 아닌 경우
                    if((nkey & nowDoor) != nowDoor){
                        continue;
                    }
                }

                // 키를 만난 경우
                if(boards[ny][nx] >= 'a' && boards[ny][nx] <= 'f'){
                    int nowkey = 1<<(boards[ny][nx]-'a');

                    nkey |= nowkey;
                }

                visited[ny][nx][nkey] = true;
                q.add(new pair(ny,nx,ncnt,nkey));

            }

        }

        return -1;

    }

    public static class pair{
        int y;
        int x;
        int cnt;
        int key;

        public pair(int y, int x, int cnt,int key) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.key=key;
        }
    }
}
