package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_0913_5525 {

    final static long modNum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        String s = bf.readLine();

        int size=1;
        int i = s.indexOf('I');

        for(;i<M;i++){

        }


    }
}
