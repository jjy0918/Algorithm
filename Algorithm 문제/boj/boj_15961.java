package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/15961
// 회전 초밥
public class boj_1003_15961 {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 접시 수
        int N = Integer.parseInt(st.nextToken());

        // 초밥 가지 수
        int d = Integer.parseInt(st.nextToken());

        // 연속 먹는 접시 수
        int k = Integer.parseInt(st.nextToken());

        // 쿠폰 번호
        int c = Integer.parseInt(st.nextToken());

        int boards[] = new int[N+k];

        int selected[] = new int[d+1];

        for(int i=0;i<N;i++){
            int n = Integer.parseInt(bf.readLine());
            boards[i]=n;
        }

        int result=1;

        selected[c]++;
        for(int i=N;i<N+k;i++){
            boards[i]=boards[i-N];
            if(selected[boards[i]]==0){
                result++;
            }
            selected[boards[i]]++;

        }

        int nowSum=result;

        for(int i=k;i<N+k;i++){

            int deleteNum = boards[i-k];
            selected[deleteNum]--;

            // 빼야 하는 초밥이 모두 빠진 경우
            if(selected[deleteNum]==0){
                nowSum--;
            }

            int addNum = boards[i];
            selected[addNum]++;

            // 새로 들어온 경우
            if(selected[addNum]==1){
                nowSum++;
            }

            result = Integer.max(result,nowSum);
        }
        System.out.println(result);


    }
}
