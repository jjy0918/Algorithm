package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11720
// 숫자의 합
public class boj_1017_11720 {
    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bf.readLine();

        String N = bf.readLine();

        int result=0;
        for(int i=0;i<N.length();i++){
            result+=N.charAt(i)-'0';
        }

        System.out.println(result);

    }
}
