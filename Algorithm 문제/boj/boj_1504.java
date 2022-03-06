import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1504
// 특정한 최단 경로
public class Main {

    public static List<Node> arr[] = new ArrayList[801];
    public static final int MAX = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for(int i=0;i<=N;i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b,c));
            arr[b].add(new Node(a,c));
        }
        st = new StringTokenizer(bf.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int startToV1 = d(1, v1);
        int v1ToV2 = d(v1, v2);
        int v2ToEnd = d(v2, N);

        int startToV2 = d(1, v2);
        int v2ToV1 = d(v2, v1);
        int v1ToEnd = d(v1, N);

        long sum1 = startToV1+v1ToV2+v2ToEnd;
        long sum2 = startToV2+v2ToV1+v1ToEnd;

        if(startToV1>=MAX || v1ToV2 >= MAX || v2ToEnd >= MAX ||
                startToV2 >= MAX || v2ToV1 >= MAX || v1ToEnd >= MAX) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(sum1, sum2));
        }
    }

    public static int d(int startIndex, int endIndex) {
        int visited[] = new int[801];
        for(int i=0;i<801;i++) {
            visited[i] = MAX;
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(startIndex, 0));
        while (!q.isEmpty()) {
            Node nowNode = q.poll();
            if(visited[nowNode.index] < nowNode.weight) {
                continue;
            }
            visited[nowNode.index] = nowNode.weight;
            for(Node nextNode: arr[nowNode.index]) {
                int nextWeight = nextNode.weight+ nowNode.weight;
                if(visited[nextNode.index] <= nextWeight) {
                    continue;
                }
                visited[nextNode.index] = nextWeight;
                q.add(new Node(nextNode.index, nextWeight));
            }
        }

        return visited[endIndex];
    }

    public static class Node implements Comparable<Node>{
        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
