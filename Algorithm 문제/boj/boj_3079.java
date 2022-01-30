package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3079
// 입국심사
public class boj_1001_3079 {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N;
        long M;

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        long times[] = new long[N];

        for(int i=0;i<N;i++){
            times[i]=Long.parseLong(bf.readLine());
        }

        // last => 끝나는 시간의 최대값.
        long start = 1;
        long last = 1000000000000000000L;
        long result=last;


        while(start <= last){
            // mid로 끝나는 시간 기준으로 각 부분에서 몇 명을 처리할 수 있는가
            long mid = (start+last)/2;

            if(check(M,mid,times)){
                last=mid-1;
                result = Long.min(result,mid);
            }
            else{
                start=mid+1;
            }
        }
        System.out.println(result);
    }

    public static boolean check(long M,long mid, long times[]){
        for(int i=0;i<times.length;i++){
            M-=mid/times[i];
            // 이거 안해주면 언더플로 가능
            if(M<=0){
                return true;
            }
        }
        return false;
    }
}
