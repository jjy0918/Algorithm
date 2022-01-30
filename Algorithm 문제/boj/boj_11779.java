
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_11779 {

    static int visited[] = new int[1001];
    static int visitedNum[] = new int[1001];
    static List<data>[] boards = new ArrayList[1001];

    static int N;

    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter out  = new BufferedWriter(new OutputStreamWriter(System.out));

        //int T=10;


//        int T = Integer.parseInt(bf.readLine());
//        Solution s =new Solution();
//        int i[] = s.solution(100);
//        for(int ii : i){
//            System.out.println(ii);
//        }

        //StringTokenizer st = new StringTokenizer(bf.readLine()," ");

        N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        for(int i=0;i<=N;i++){
            boards[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());


            boards[start].add(new data(start,end,cost));
        }

        Arrays.fill(visited,Integer.MAX_VALUE);


        StringTokenizer st = new StringTokenizer(bf.readLine());
        int startNumber = Integer.parseInt(st.nextToken())-1;
        int endNumber = Integer.parseInt(st.nextToken())-1;

        PriorityQueue<data> pq = new PriorityQueue<>();

        pq.add(new data(startNumber, startNumber,0));

        while(!pq.isEmpty()){
            data nowData = pq.peek();
            pq.poll();

            if(nowData.cost >= visited[nowData.node]){
                continue;
            }



            visited[nowData.node] = nowData.cost;
            visitedNum[nowData.node] = nowData.preNode;

            if(nowData.node==endNumber){
                break;
            }

            for(data d : boards[nowData.node]){

                int nextCost = d.cost + nowData.cost;

                if(visited[d.node] <= nextCost){

                    continue;

                }

                pq.add(new data(nowData.node,d.node,nextCost));


            }

        }

        List<Integer> result = new ArrayList<>();

        int number=endNumber;

        while(number!=startNumber){

            result.add(number);
            number =  visitedNum[number];

        }

        result.add(startNumber);

        Collections.reverse(result);

        System.out.println(visited[endNumber]);
        System.out.println(result.size());
        for(int r : result){
            System.out.print((r+1)+" ");
        }


    }


    static class data implements Comparable<data>{
        int preNode;
        int node;
        int cost;

        public data(int preNode, int node, int cost) {
            this.preNode=preNode;
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(data o) {
            if(this.cost > o.cost){
                return 1;
            }

            return -1;
        }
    }
}
