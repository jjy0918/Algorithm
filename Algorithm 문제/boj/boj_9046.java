package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
// https://www.acmicpc.net/problem/9046
// 복호화
public class boj_1017_9046 {
    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            int alpha[] = new int[28];

            String S = bf.readLine();

            for(int j=0;j<S.length();j++){
                if(S.charAt(j)==' '){
                    continue;
                }
                alpha[S.charAt(j)-'a']++;
            }

            int index=-1;
            int maxNum=-1;
            for(int j=0;j<28;j++){
                if(maxNum < alpha[j]){
                    maxNum=alpha[j];
                    index=j;
                }
            }

            for(int j=0;j<28;j++){
                if(maxNum == alpha[j] && j!=index){
                    maxNum=-1;
                    break;
                }

            }
            if(maxNum==-1){
                sb.append("?");
            }
            else{
                sb.append((char)(index+'a'));
            }
            sb.append("\n");

        }
        System.out.println(sb);

    }
}
