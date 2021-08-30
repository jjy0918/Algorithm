package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11561 {

    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for(int i=0;i<T;i++){
            long N = Long.parseLong(bf.readLine());
            long start=0;
            long last=200000000;
            long result=0;
            while(start<=last){
                long mid=(start+last)/2;
                long sum=  (mid) *(mid+1)/2;
                if(sum<=N){
                    result=Math.max(mid,result);
                    start=mid+1;
                }
                else{
                    last=mid-1;
                }
            }
            System.out.println(result);


        }

    }

}
