package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1107
// 리모컨

public class boj_0921_1107 {

    public static int result=Integer.MAX_VALUE;

    public static int N,M;
    public static int NSize;

    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        M = Integer.parseInt(bf.readLine());

        NSize = String.valueOf(N).length();

        boolean numbers[] = new boolean[11];
        if(M>0){
            StringTokenizer st =new StringTokenizer(bf.readLine());
            for(int i=0;i<M;i++){
                numbers[Integer.parseInt(st.nextToken())]=true;
            }
        }


        result = Math.abs(N-100);

        StringBuilder nowNumber = new StringBuilder();

        findNum(numbers,nowNumber);

        System.out.println(result);


    }

    public static void findNum(boolean numbers[],StringBuilder nowNumber){

        if(nowNumber.length() > 6){
            return;
        }
        if(nowNumber.length()>0){
            int nowN = Integer.parseInt(nowNumber.toString());
            int nowSize = String.valueOf(nowN).length();
            result = Integer.min(Math.abs(N-Integer.parseInt(nowNumber.toString()))+nowSize,result);

        }


        for(int i=0;i<=9;i++){
            if(!numbers[i]){
                nowNumber.append(i);
                findNum(numbers,nowNumber);
                nowNumber.setLength(nowNumber.length()-1);
            }
        }
    }
}
