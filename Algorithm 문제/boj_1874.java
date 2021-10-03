package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_1003_1874 {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        Stack<Integer> st = new Stack<>();

        StringBuilder sb = new StringBuilder();

        int stackNum=1;

        for(int i=0;i<N;i++){
            int now = Integer.parseInt(bf.readLine());

            if(st.isEmpty()){
                st.push(stackNum);
                stackNum++;
                sb.append("+");
                sb.append("\n");
            }

            while(!st.isEmpty()){

                int nowNum = st.peek();

                if(nowNum>=100001){
                    st.clear();
                    sb.setLength(0);
                    sb.append("NO");
                    sb.append("\n");
                    break;
                }

                if(nowNum == now){
                    st.pop();
                    sb.append("-");
                    sb.append("\n");
                    break;
                }

                st.push(stackNum);
                stackNum++;
                sb.append("+");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
