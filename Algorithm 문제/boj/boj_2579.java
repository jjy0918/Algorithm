package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2579
// 계단 오르기
public class boj_0919_2579 {
    private static int result=0;
    private static int arr[];
    private static int N;
    private static int visited[][];
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        arr = new int[N+3];
        visited= new int[3][N+3];

        for(int i=1;i<=N;i++){
            arr[i]=Integer.parseInt(bf.readLine());
        }

        dfs(0,0,-22);

        System.out.println(result);

    }

    // 세 계단 연속 불가능 => 직전 + 1 == 현재 == 미래 - 1
    public static void dfs(int nowFloor,int sum, int p){
        if(nowFloor==N){
            result=Integer.max(result,sum);
            return;
        }
        if(nowFloor>N){
            return;
        }

        int nextStep=1;
        if(nowFloor-1==p && p!=0){
            nextStep=2;
        }

        // 현재칸 = 5층
        // 다음 칸 5층 + 1층 == 500 // 5층 + 2층
        // 6층 => 5층 + 1층 => 1000 , 4층 + 2층
        for(;nextStep<=2;nextStep++){

            if(visited[nextStep][nowFloor+nextStep] >= sum+arr[nowFloor+nextStep]){
                continue;
            }
            visited[nextStep][nowFloor+nextStep] = sum+arr[nowFloor+nextStep];
            dfs(nowFloor+nextStep,sum+arr[nowFloor+nextStep],nowFloor);
        }
    }


}
