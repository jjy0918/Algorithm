package boj.y2022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_0323_12852 {

    public static Node arr[] = new Node[1000001];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<1000001;i++) {
            arr[i] = new Node(Integer.MAX_VALUE, -1);
        }

        arr[3].cnt = 1;
        arr[3].nextNum = 1;
        arr[2].cnt = 1;
        arr[2].nextNum = 1;
        arr[1].cnt = 0;

        int s = Integer.parseInt(bf.readLine());

        System.out.println(rec(s));

        StringBuilder sb = new StringBuilder();
        while(s>=1) {
            sb.append(s+" ");
            s = arr[s].nextNum;
        }
        System.out.println(sb);
    }

    public static int rec(int index) {

        if(arr[index].cnt != Integer.MAX_VALUE){
            return arr[index].cnt;
        }

        if(index%3 == 0 && arr[index].cnt > rec(index / 3) + 1) {
            arr[index].cnt = rec(index/3) + 1;
            arr[index].nextNum = index/3;
        }

        if(index%2 == 0 && arr[index].cnt > rec(index / 2) + 1) {
            arr[index].cnt = rec(index/2) + 1;
            arr[index].nextNum = index/2;
        }

        if(arr[index].cnt > rec(index - 1) + 1){
            arr[index].cnt = rec(index - 1) + 1;
            arr[index].nextNum = index - 1;
        }

        return arr[index].cnt;
    }

    static class Node {
        int cnt;
        int nextNum;

        public Node(int cnt, int nextNum) {
            this.cnt = cnt;
            this.nextNum = nextNum;
        }
    }


}
