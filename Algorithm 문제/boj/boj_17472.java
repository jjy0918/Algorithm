import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//boj.17472 다리 만들기2

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter out  = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int boards[][] = new int[N][M];

        int dy[] = {0,0,1,-1};
        int dx[] = {1,-1,0,0};

        int islandCount=0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                int n = Integer.parseInt(st.nextToken());
                if(n==1){
                    n=-1;
                }
                boards[i][j]=n;
            }
        }

        ArrayList<pair> islandStart = new ArrayList<>();

        // 각 섬 구분
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(boards[i][j]>=0){
                    continue;
                }
                islandCount++;

                Queue<pair> q = new LinkedList<>();
                q.add(new pair(i,j));
                boards[i][j]=islandCount;
                islandStart.add(new pair(i,j));

                while (!q.isEmpty()){
                    pair nowNode = q.poll();

                    for(int d=0;d<4;d++){
                        int ny = nowNode.y+dy[d];
                        int nx = nowNode.x+dx[d];

                        if(ny < 0 || nx < 0 || ny >= N || nx >= M || boards[ny][nx]>=0){
                            continue;
                        }

                        boards[ny][nx]=islandCount;
                        q.add(new pair(ny,nx));
                    }
                }

            }
        }



        // y번째 섬까지 가는데 다리 x가 소요된다.
        ArrayList<pair> arr[] = new ArrayList[islandCount];

        for(int i=0;i<islandCount;i++){
            arr[i]=new ArrayList<>();
        }


        for(int i=0;i<islandCount;i++){
            pair startNode = islandStart.get(i);

            Queue<pair> q = new LinkedList<>();
            q.add(new pair(startNode.y,startNode.x));

            boolean isVisited[][]= new boolean[N][M];
            isVisited[startNode.y][startNode.x]=true;

            while (!q.isEmpty()){
                pair nowNode = q.poll();

                for(int d=0;d<4;d++){
                    int ny = nowNode.y+dy[d];
                    int nx = nowNode.x+dx[d];

                    if(ny < 0 || nx < 0 || ny >= N || nx >= M || isVisited[ny][nx]){
                        continue;
                    }



                    // 해당 방향으로 진행해보기
                    // 최소값인지 확인 필요
                    // 다리 2개 이상인지 확인 필요
                    if(boards[ny][nx]==0){
                        int bridgeLength=0;

                        while(ny >= 0 && nx >=0 && ny < N && nx < M && boards[ny][nx]==0){
                            bridgeLength++;

                            ny+=dy[d];
                            nx+=dx[d];
                        }

                        // 다리 거리 2 이상으로 연결한 다른 대륙을 만난 경우
                        if(ny >= 0 && nx >=0 && ny < N && nx < M && boards[ny][nx] != 0 && bridgeLength >= 2){

                            boolean isSameIsland=false;

                            for(int ar=0;ar<arr[i].size();ar++){
                                pair nowIsland = arr[i].get(ar);

                                // 같은 섬이 있는 경우
                                if(nowIsland.y == boards[ny][nx]){
                                    // 더 다리의 길이가 짧은 값으로 갱신해준다.
                                    nowIsland.x = Math.min(nowIsland.x,bridgeLength);
                                    isSameIsland=true;
                                }
                            }

                            if(!isSameIsland){
                                arr[i].add(new pair(boards[ny][nx],bridgeLength));
                            }
                        }

                    }
                    else{
                        isVisited[ny][nx]=true;
                        q.add(new pair(ny,nx));

                    }
                }
            }
        }

        System.out.println(prim(arr));



        //StringTokenizer st = new StringTokenizer(bf.readLine()," ");

    }

    public static int prim(ArrayList<pair> arr[]){

        int SIZE = arr.length;


        boolean isVisited[] = new boolean[SIZE+1];

        PriorityQueue<pair> pq = new PriorityQueue<>();

        isVisited[1]=true;

        int result=0;

        for(int i=0;i<arr[0].size();i++){
            pair nowPair = arr[0].get(i);
            pq.add(new pair(nowPair.y,nowPair.x));
        }

        while(!pq.isEmpty()){
            pair nowNode = pq.poll();

            if(isVisited[nowNode.y]){
                continue;
            }

            isVisited[nowNode.y]=true;
            result+=nowNode.x;

            for(int i=0;i<arr[nowNode.y-1].size();i++){
                pair nextNode = arr[nowNode.y-1].get(i);
                if(isVisited[nextNode.y])
                    continue;

                pq.add(new pair(nextNode.y,nextNode.x));
            }

        }

        for(int i=1;i<=SIZE;i++){
            if(!isVisited[i]){
                result=-1;
                break;
            }
        }

        return result;

    }


    public static class pair implements Comparable<pair>{
        int y;
        int x;

        public pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        // 거리가 작은 값 부터 출력
        @Override
        public int compareTo(pair o) {
            if(this.x > o.x){
                return 1;
            }
            return -1;
        }
    }
}
