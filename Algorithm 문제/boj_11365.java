package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11365
// !밀비 급일
public class boj_1017_11365 {
    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String S= bf.readLine();;
        StringBuilder sb = new StringBuilder();
        do{
            StringBuilder newSb = new StringBuilder(S);
            newSb.reverse();
            sb.append(newSb);
            sb.append("\n");
            S = bf.readLine();
        }while (!S.equals("END"));

        System.out.println(sb);

    }
}
