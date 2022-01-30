package boj.y2022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/2143
// 두 배열의 합
public class boj_0118_2143 {

    public static long sumA[] = new long[1001];
    public static long sumB[] = new long[1001];

    public static List<Long> sumListA = new ArrayList<>();
    public static Map<Long,Long> sumMapB = new TreeMap<>();


    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        int N = Integer.parseInt(bf.readLine());

        long result=0;

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            for(int j=i;j<N;j++){
                sumA[j]+=num;
            }
        }

        int M = Integer.parseInt(bf.readLine());

        st = new StringTokenizer(bf.readLine());

        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            for(int j=i;j<M;j++){
                sumB[j]+=num;
            }
        }

        for(int i=0;i<N;i++){
            sumListA.add(sumA[i]);
            for(int j=i+1;j<N;j++){
                sumListA.add(sumA[j]-sumA[i]);
            }
        }

        for(int i=0;i<M;i++){
            long cnt = sumMapB.containsKey(sumB[i]) ? sumMapB.get(sumB[i]) : 0;
            sumMapB.put(sumB[i], cnt+1);
            for(int j=i+1;j<M;j++){
                cnt = sumMapB.containsKey(sumB[j]-sumB[i]) ? sumMapB.get(sumB[j]-sumB[i]) : 0;
                sumMapB.put(sumB[j]-sumB[i], cnt+1);
            }
        }

        Collections.sort(sumListA);

        for(long a : sumListA){
            result += sumMapB.containsKey(T-a) ? sumMapB.get(T-a) : 0;
        }

        System.out.println(result);

    }

}
