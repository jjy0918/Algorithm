package boj.y2022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// boj 1644 소수의 연속 합
// https://www.acmicpc.net/problem/1644
public class boj_0313_1644 {

    // false -> 소수 맞음 / true -> 소수 아님
    public static boolean isNotPrimes[] = new boolean[4000001];

    public static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        checkPrime();

        int start = 0;
        int last = 0;
        int sum = primes.get(start);
        int result = 0;
        while(start <= last) {
            if(sum > N) {
                sum -= primes.get(start);
                start++;
            }
            else{
                if(sum == N) {
                    result++;
                }
                last++;
                if(last == primes.size()) {
                    break;
                }
                sum += primes.get(last);
            }
        }

        System.out.println(result);

    }

    public static void checkPrime(){
        for(int i=2;i<4000001;i++){
            if(isNotPrimes[i]){
                continue;
            }
            primes.add(i);
            for(int j=i*2;j<4000001;j+=i) {
                isNotPrimes[j] = true;
            }
        }
    }
}
