package boj.y2022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1647
// 도시 분할 계획
public class boj_0220_1647 {

    public static List<Node>[] arr = new ArrayList[100001];

    public static boolean visited[] = new boolean[100001];

    public static int N = 0;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b,c));
            arr[b].add(new Node(a,c));
        }

        System.out.println(mst(1));
    }

    public static class Node implements Comparable<Node>{
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static int mst(int startIndex){
        int mstWeight = 0;

        int lastWeight = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startIndex,0));

        while (!pq.isEmpty() && N!=0){
            Node nowNode = pq.poll();

            if(visited[nowNode.num]){
                continue;
            }

            visited[nowNode.num] = true;
            mstWeight += nowNode.weight;
            N--;
            lastWeight = Integer.max(lastWeight, nowNode.weight);
            arr[nowNode.num]
                    .stream()
                    .filter(it -> !visited[it.num])
                    .forEach(pq::add);
        }
        return mstWeight - lastWeight;
    }
}
