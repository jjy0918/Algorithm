package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/17609
// 회문
public class boj_1003_17609 {


    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        for(int t=0;t<T;t++){
            String s = bf.readLine();
            sb.append(checkPalindrome(s,0,0,s.length()-1));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // start 와 last 계속 비교하여 회문인지 판단
    // result 0 : 회문 / result 1 : 유사회문 / result 2 : 아무것도 아님
    public static int checkPalindrome(String s,int result, int start,int last){

        if(result==2){
            return 2;
        }

        while(start<=last){

            if(s.charAt(start) == s.charAt(last)){
                start++;
                last--;
            }
            else{
                // 현재는 회문이 아니다 -> 하나씩 제거하여 비교해서 회문인지 판별
                // 더 작은 값으로 갱신
                result = Integer.min(checkPalindrome(s,result+1,start+1,last),checkPalindrome(s,result+1,start,last-1));
                break;
            }
        }

        return result;
    }
}
