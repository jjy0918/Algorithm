package boj.y2022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_0123_1202 {

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        List<Node> gems = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());

            int M = Integer.parseInt(st.nextToken());

            int V = Integer.parseInt(st.nextToken());

            Node node = new Node(M,V);

            gems.add(node);

        }

        List<Integer> arr = new ArrayList<>();

        for(int i=0;i<K;i++){
            arr.add(Integer.parseInt(bf.readLine()));
        }

        Collections.sort(arr);

        Collections.sort(gems);

        int startIndex = 0;

        long result = 0;

        for(int i=0;i<K;i++){
            int index = arr.get(i);

            for(;startIndex<N;startIndex++){
                if(gems.get(startIndex).M <= index){
                    pq.add(gems.get(startIndex).V);
                }
                else{
                    break;
                }
            }
            if(!pq.isEmpty()){
                result += pq.poll();

            }

        }
        System.out.println(result);
    }

    static class Node implements Comparable<Node> {
        int M;
        int V;

        public Node(int m, int v) {
            M = m;
            V = v;
        }

        @Override
        public int compareTo(Node o) {
            return this.M - o.M;
        }
    }

}
