package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
// https://www.acmicpc.net/problem/10798
// 세로 읽기
public class boj_1017_10798 {

    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char chars[][] = new char[15][15];

        String S = bf.readLine();
        int index=0;
        do{
            for(int i=0;i<S.length();i++){
                chars[index][i]=S.charAt(i);
            }
            index++;
            S=bf.readLine();
        }while(S!=null);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                if(chars[j][i]==0){
                    continue;
                }
                sb.append(chars[j][i]);
            }
        }

        System.out.println(sb);

    }
}
