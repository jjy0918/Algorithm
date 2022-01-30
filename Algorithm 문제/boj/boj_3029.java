package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
// https://www.acmicpc.net/problem/3029
// 경고
public class boj_1017_3029 {
    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String startTime[] = bf.readLine().split(":");
        String endTime[] = bf.readLine().split(":");

        int restTime = 0;
        int num=3600;

        for(int i=0;i<3;i++,num/=60){
            restTime+=Integer.parseInt(endTime[i])*num;
            restTime-=Integer.parseInt(startTime[i])*num;
        }

        StringBuilder sb = new StringBuilder();
        num=3600;
        if(restTime<=0){
            restTime+=24*num;
        }
        for(int i=0;i<3;i++,num/=60){
            int nowtime = restTime/num;
            if(nowtime<10){
                sb.append("0");
            }
            sb.append(nowtime);
            sb.append(":");
            restTime%=num;
        }

        sb.setLength(sb.length()-1);

        System.out.println(sb);


    }
}
