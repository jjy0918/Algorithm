package boj.y2022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1005
// ACM Craft
public class boj_0406_1005 {

    // arr[i] = i번째 노드 후 지을 수 노드들
    public static List<Integer> arr[] = new ArrayList[1001];

    // 내가 짓기 위해서 필요한 노드의 개수
    public static int nodeCnt[] = new int[1001];

    // 내가 짓기 위한 시간
    public static int cost[] = new int[1001];

    // 내가 지어지는 최소 시간
    public static int costSum[] = new int[1001];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for(int t=0;t<T;t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            for(int i=0;i<1001;i++) {
                arr[i] = new ArrayList<>();
                costSum[i] = 0;
                nodeCnt[i] = 0;
                cost[i] = 0;
            }

            st = new StringTokenizer(bf.readLine());

            for(int i=1;i<=N;i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0;i<K;i++) {
                st = new StringTokenizer(bf.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                nodeCnt[Y]++;
                arr[X].add(Y);
            }

            int W = Integer.parseInt(bf.readLine());

            Queue<Integer> q = new LinkedList<>();

            for(int i=1;i<=N;i++) {
                if(nodeCnt[i] == 0){
                    costSum[i] = cost[i];
                    q.add(i);
                }
            }

            while (!q.isEmpty()) {
                Integer nowNode = q.poll();
                int nowCost = costSum[nowNode];

                if(nowNode == W){
                    System.out.println(nowCost);
                    break;
                }


                for(int nextIndex : arr[nowNode]) {
                    nodeCnt[nextIndex]--;

                    costSum[nextIndex] = Integer.max(costSum[nextIndex], nowCost + cost[nextIndex]);

                    if(nodeCnt[nextIndex] == 0) {
                        q.add(nextIndex);
                    }
                }

            }
        }
    }
}
