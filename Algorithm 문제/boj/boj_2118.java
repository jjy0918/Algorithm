package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_0929_2118 {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int boards[]= new int[N+1];

        int sum=0;

        for(int i=0;i<N;i++){
            int n = Integer.parseInt(bf.readLine());
            boards[i]=n;
            sum+=n;
        }

        int start=0;
        int last=0;

        int result=0;

        int now=boards[start];

        while(start<=last && last<N){

            int minNow = Integer.min(now,sum-now);

            result = Integer.max(result, minNow);

            if(now == minNow){
                last++;
                now+=boards[last];
            }
            else{
                now-=boards[start];
                start++;
            }

        }

        System.out.println(result);


    }
}
