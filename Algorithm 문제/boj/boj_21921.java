package boj.y2022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/21921
// 블로그
public class boj_0225_21921 {

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Node result;
        int sum = 0;
        for(int i=0;i<X;i++) {
            sum += arr.get(i);
        }
        result = new Node(sum);

        for(int i=X;i<N;i++){
            sum -= arr.get(i-X);
            sum += arr.get(i);

            result.setResult(sum);

        }
        result.print();
    }

    public static class Node {
        private int result;
        private int period;

        public Node(int sum) {
            this.result = sum;
            this.period=1;
        }

        public void setResult(int sum) {
            if(this.result == sum) {
                this.period++;
            }
            else if(this.result < sum) {
                this.result = sum;
                this.period = 1;
            }
        }
        public void print(){
            if(this.result == 0) {
                System.out.println("SAD");
            } else {
                System.out.println(this.result);
                System.out.println(this.period);
            }
        }

    }
}
