import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// boj.17135 캐슬 디펜스
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter out  = new BufferedWriter(new OutputStreamWriter(System.out));

        //int T=10;
        String[] s = bf.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // 행
        int M = Integer.parseInt(s[1]); // 열
        int D = Integer.parseInt(s[2]); // 궁수 거리

        int result=0;

        ArrayList<Node> enemy= new ArrayList<>();

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine()," ");
            for(int j=0;j<M;j++){
                int t = Integer.parseInt(st.nextToken());
                if(t==1){
                    enemy.add(new Node(i,j));
                }
            }
        }

        // 적 위치 열 기준으로 오름차순 정렬
        Collections.sort(enemy);
        // 궁수의 위치
        int com[] = new int[M];
        for(int j=0;j<3;j++){
            com[M-j-1]=1;
        }

        do{
            Node archers[] = new Node[3];
            int p=0;

            ArrayList<Node> enemyCopy = new ArrayList<>();
            for(int i=0;i<enemy.size();i++){
                enemyCopy.add(enemy.get(i).copy());
            }

            for(int j=0;j<M;j++){
                if(com[j]==1){
                    archers[p++] = new Node(N,j);
                }
            }

            int nowResult=0;

            while(true){
                int eSize = enemyCopy.size();

                int deleteNumber[] = new int[3];
                for(int i=0;i<3;i++){
                    Node archer = archers[i];
                    deleteNumber[i]=-1;
                    int minDis = Integer.MAX_VALUE;
                    for(int j=0;j<eSize;j++){
                        Node e = enemyCopy.get(j);

                        if(!e.isLive)
                            continue;
                        int dis = Math.abs(archer.y-e.y)+Math.abs(archer.x-e.x);
                        if(dis <= D && dis < minDis){
                            minDis=dis;
                            deleteNumber[i]=j;
                        }
                    }

                }
                for(int i=0;i<3;i++){
                    int deleteIndex=deleteNumber[i];
                    if(deleteIndex!=-1 && enemyCopy.get(deleteIndex).isLive){
                        nowResult++;

                        enemyCopy.get(deleteIndex).isLive=false;
                    }
                }

                // 종료 조건 1. 모든 적이 제거된 경우
                boolean isEnemyAllDelete = false;

                for(int j=0;j<eSize;j++){
                    Node e = enemyCopy.get(j);

                    if(e.isLive){
                        e.y++;
                        if(e.y == N){
                            e.isLive=false;
                        }
                    }
                    isEnemyAllDelete |=e.isLive;

                }
                if(!isEnemyAllDelete){
                    break;
                }
            }
            if(result < nowResult){
                result=nowResult;
            }


        }while(np(M,com));

        System.out.println(result);

    }

    public static boolean np(int p , int[] com){
        int i=p-1;
        while(i>0 && com[i-1]>=com[i]){
            i--;
        }
        if(i==0)
            return false;

        int j=p-1;
        while(com[i-1]>=com[j]){
            j--;
        }
        int tmp = com[i-1];
        com[i-1]=com[j];
        com[j]=tmp;

        int K=p-1;

        while(i<K){
            tmp = com[i];
            com[i]=com[K];
            com[K]=tmp;
            i++;
            K--;
        }

        return true;
    }

    static class Node implements Comparable<Node>{
        int y;
        int x;
        public boolean isLive;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
            isLive=true;

        }

        @Override
        public int compareTo(Node o) {
            Node n = (Node)o;
            if(this.x < n.x){
                return -1;
            }
            else{
                return 1;
            }
        }

        Node copy(){
            return new Node(y,x);
        }
    }
}
