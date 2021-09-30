package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1717
public class boj_0812_1717 {



    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        UnionFind uf = new UnionFind(n);

        for(int i=0;i<m;i++){
            st = new StringTokenizer(bf.readLine());

            int u = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(u==0){
                uf.unionParent(a,b);
            }
            else{
                stringBuilder.append(uf.sameParents(a,b));
            }
        }

        System.out.println(stringBuilder.toString());

    }

    public static class UnionFind{
        private int parents[];
        private int height[];

        public UnionFind(int size){
            parents = new int[size+1];
            height = new int[size+1];

            for(int i=0;i<size+1;i++){
                parents[i]=i;
            }
        }

        public int findParent(int n){
            int p = parents[n];
            if(p==n){
                return p;
            }
            return parents[n] = findParent(p);
        }

        public void unionParent(int n1,int n2){
            int p1 = findParent(n1);
            int p2 = findParent(n2);

            if(p1==p2){
                return ;
            }

            if(height[p1] > height[p2]){
                parents[p2]=p1;
            }
            else if(height[p1]<height[p2]){
                parents[p1]=p2;
            }
            else{
                parents[p1]=p2;
                height[p2]++;
            }

        }

        public String sameParents(int n1,int n2){
            int p1 = findParent(n1);
            int p2 = findParent(n2);

            if(p1==p2){
                return "YES\n";
            }

            return "NO\n";


        }
    }

}

