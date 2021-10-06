package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1006_13022 {

    private static char myChar[]=new char[]{'w','o','l','f'};

    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();

        int charCnt[] = new int[26];

        for(int i=0;i<s.length();i++){
            charCnt[s.charAt(i)-'a']++;
        }

        for(int i=1;i<4;i++){
            if(charCnt[myChar[i]-'a']!=charCnt[myChar[i-1]-'a']){
                System.out.println(0);
                return;
            }
        }

        int index=0;

        while(index<s.length()){

            int cnt=0;
            for(;index<s.length();index++){
                if(s.charAt(index)=='w'){
                    cnt++;
                }
                else{
                    break;
                }
            }
            if(cnt==0){
                System.out.println("0");
                return;
            }

            for(int d=1;d<4;d++){
                for(int i=0;i<cnt;i++,index++){
                    if(s.charAt(index)!=myChar[d]){
                        System.out.println("0");
                        return;
                    }
                }
            }

        }

        System.out.println("1");

    }
}
