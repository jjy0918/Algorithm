package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_0917_2644 {

    public static List<Integer> arr[] = new ArrayList[101];

    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=1;i<=n;i++){
            arr[i]=new ArrayList<>();
        }

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        int m = Integer.parseInt(bf.readLine());

        for(int i=0;i<m;i++){
            st = new StringTokenizer(bf.readLine());

            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[p].add(c);
            arr[c].add(p);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[101];

        q.add(start);
        visited[start]=true;


        int cnt=1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int now = q.peek();
                q.poll();

                for(int next : arr[now]){

                    if(visited[next]){
                        continue;
                    }

                    if(next==end){
                        System.out.println(cnt);
                        return;
                    }

                    q.add(next);
                    visited[next]=true;
                }
            }
            cnt++;
        }

        System.out.println(-1);
    }
}
