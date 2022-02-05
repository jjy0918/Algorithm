import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// boj 17471 게리맨더링
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int peopleNum[] = new int[N];

        int peopleTotal=0;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            peopleNum[i]=Integer.parseInt(st.nextToken());
            peopleTotal+=peopleNum[i];
        }

        ArrayList<Integer> boards[] = new ArrayList[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            boards[i] = new ArrayList<>();

            int n = Integer.parseInt(st.nextToken());

            for(int j=0;j<n;j++){
                boards[i].add(Integer.parseInt(st.nextToken())-1);
            }

        }
        if(N==2){
            System.out.println(Math.abs(peopleNum[0] - peopleNum[1]));
            return;
        }

        int result = Integer.MAX_VALUE;


        int size = (int)Math.pow(2,N) - 1;

        for(int i=1;i<size;i++){

            Election E = new Election(N,i);

            int nowNum = E.find(peopleNum,boards);
            if(nowNum==-1){
                continue;
            }
            int enemy = Math.abs(peopleTotal-nowNum);

            result = Math.min(result,Math.abs(nowNum - enemy));
        }
        if(result==Integer.MAX_VALUE){
            result=-1;
        }

        System.out.println(result);


    }

    public static class Election{
        int N;

        // 해당 인덱스의 지역이 어느 선거구에 속해있는지
        int select;
        boolean mySelect[];

        public Election(int n, int select) {
            N = n;
            this.select = select;
            mySelect = new boolean[N];

            for(int i=0,k=1;i<N;i++,k*=2){
                if((k&select)==k){
                    mySelect[i]=true;
                }
            }


        }
        // 1의 선거구의 인원수를 체크한다.
        public int find(int[] peopleNum, ArrayList<Integer> boards[]){
            int result = 0;

            if(!check(peopleNum,boards)){
                return -1;
            }

            for(int i=0;i<N;i++){
                if(mySelect[i]){

                    if(boards[i].size()==0) {
                        return -1;
                    }
                    // 연결된 것 중에 같은것이 하나라도 있는지 판단.
                    boolean isCheck = false;
                    for(int j=0;j<boards[i].size();j++){
                        int p=boards[i].get(j);
                        // 하나라도 true가 나오면 isCheck값은 true가 된다.
                        isCheck|=mySelect[p];
                    }
                    if(!isCheck){
                        return -1;
                    }
                    result += peopleNum[i];
                }
            }

            return result;
        }

        public boolean check(int[] peopleNum, ArrayList<Integer> boards[]){
            // 해당 선거구까리 연결이 되어 있는지 확인
            boolean visited[] = new boolean[N];

            for(int i=0;i<N;i++){
                if(mySelect[i]){
                    visited[i]=true;

                    Queue<Integer> q =new LinkedList<>();
                    q.add(i);

                    while(!q.isEmpty()){

                        int now = q.poll();

                        for(int next : boards[now]){

                            if(visited[next] || !mySelect[next]){
                                continue;
                            }
                            visited[next]=true;
                            q.add(next);

                        }

                    }

                    break;
                }
            }

            for(int i=0;i<N;i++){
                if(visited[i] != mySelect[i]){
                    return false;
                }
            }

            visited = new boolean[N];
            for(int i=0;i<N;i++){
                if(!mySelect[i]){
                    visited[i]=true;

                    Queue<Integer> q =new LinkedList<>();
                    q.add(i);

                    while(!q.isEmpty()){

                        int now = q.poll();

                        for(int next : boards[now]){

                            if(visited[next] || mySelect[next]){
                                continue;
                            }
                            visited[next]=true;
                            q.add(next);

                        }

                    }

                    break;
                }
            }

            for(int i=0;i<N;i++){
                if(visited[i] == mySelect[i]){
                    return false;
                }
            }

            return true;
        }
    }
}
