import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// boj.16236 아기 상어
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter out  = new BufferedWriter(new OutputStreamWriter(System.out));

        //int T=10;

        int dy[]={0,0,1,-1};
        int dx[]={1,-1,0,0};

        int N = Integer.parseInt(bf.readLine());
        int boards[][] = new int [N][N];
        int totalNum=0;
        int nowSize=2;
        int nowEatNum=2;
        pair startNode = new pair(0,0,0);
        for(int i = 0 ;i<N;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine()," ");
            for(int j=0;j<N;j++){
                int now = Integer.parseInt(st.nextToken());

                boards[i][j]=now;
                if(now==9){
                    startNode.y=i;
                    startNode.x=j;
                    boards[i][j]=0;
                }
                else if(now!=0){
                    totalNum++;
                }
            }

        }

        while(totalNum>0){
            boolean visited[][] = new boolean[N][N];
            Queue<pair> q = new LinkedList<>();

            q.add(startNode);
            visited[startNode.y][startNode.x] = true;

            pair eatNode = new pair(-1,-1,-1);

            while(!q.isEmpty()){
                pair nowNode = q.poll();

                for(int d=0;d<4;d++){
                    int ny = nowNode.y+dy[d];
                    int nx = nowNode.x+dx[d];
                    int nTime = nowNode.time+1;

                    if(eatNode.time != -1 && eatNode.time < nTime){
                        break;
                    }

                    if(ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || boards[ny][nx] > nowSize)
                        continue;

                    if(boards[ny][nx] == 0 || boards[ny][nx] == nowSize){

                        if(eatNode.time!=-1)
                            continue;

                        visited[ny][nx]=true;

                        q.add(new pair(ny,nx,nTime));
                    }
                    else if(boards[ny][nx] < nowSize){
                        if(eatNode.time == -1 || eatNode.y > ny || (eatNode.y == ny && eatNode.x > nx)){
                            eatNode.y=ny;
                            eatNode.x=nx;
                            eatNode.time=nTime;

                        }
                    }

                }

            }

            totalNum--;

            if(eatNode.time==-1){
                break;
            }

            boards[eatNode.y][eatNode.x]=0;

            nowEatNum--;
            if(nowEatNum==0){
                nowSize++;
                nowEatNum=nowSize;
            }

            startNode = eatNode;

        }

        System.out.println(startNode.time);

    }


    static class pair{
        int y;
        int x;
        int time;

        public pair(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }

        public void print(){
            System.out.println(y+" , "+x+" : "+time);
        }
    }
}
