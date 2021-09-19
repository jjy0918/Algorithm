package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://www.acmicpc.net/problem/9935
// 문자열 폭발
public class boj_0919_9935 {
    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char original[] = bf.readLine().toCharArray();

        char bombs[] = bf.readLine().toCharArray();


        Stack<Character> result = new Stack<>();


        for(int i=0;i<original.length;i++){

            char nowChar = original[i];

            if(nowChar == bombs[bombs.length-1] && result.size() >= bombs.length-1){
                Stack<Character> st = new Stack<>();
                st.add(nowChar);
                boolean isBomb=true;
                for(int j = bombs.length-2;j>=0;j--){
                    if(result.peek() == bombs[j]){
                        st.add(result.pop());
                    }
                    else{
                        isBomb=false;
                        break;
                    }
                }

                if(!isBomb){
                    while(!st.isEmpty()){
                        result.add(st.pop());
                    }
                }

            }
            else{
                result.add(nowChar);
            }


        }

        StringBuilder sb = new StringBuilder();

        while(!result.isEmpty()){
            sb.append(result.pop());
        }

        sb.reverse();

        String answer = sb.toString();

        if(sb.length()==0){
            answer="FRULA";
        }

        System.out.println(answer);

    }
}
