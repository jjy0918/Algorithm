package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/15565
// 귀여운 라이언
public class boj_1006_15565 {
    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N,K;

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result=Integer.MAX_VALUE;

        int dolls[] = new int[N+1];

        int start=K;
        int last=N;

        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            dolls[i]=Integer.parseInt(st.nextToken());
        }

        while (start<=last){
            // mid 크기의 윈도우에 k개가 있는가?
            int mid=(start+last)/2;

            int cnt[] = new int[3];

            for(int i=0;i<mid-1;i++){
                cnt[dolls[i]]++;
            }

            boolean isFind=false;

            for(int i=mid-1;i<N;i++){
                cnt[dolls[i]]++;

                if(cnt[1]>=K){
                    last=mid-1;
                    result = Integer.min(result,mid);
                    isFind=true;
                    break;
                }

                cnt[dolls[i+1-mid]]--;
            }

            if(!isFind){
                start=mid+1;
            }


        }

        if(result==Integer.MAX_VALUE){
            result=-1;
        }

        System.out.println(result);
    }
}
