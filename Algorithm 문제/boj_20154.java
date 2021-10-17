package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.acmicpc.net/problem/20154
// 이 구역의 승자는 누구인가
public class boj_1017_20154 {
    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt[] = new int[]{
                3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1
        };

        char S[] = bf.readLine().toCharArray();

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<S.length;i++){
            list.add(cnt[S[i]-'A']);
        }
        list.add(0);

        while(list.size()!=2){
            List<Integer> newList = new ArrayList<>();
            for(int i=0;i<list.size()-1;i+=2){
                newList.add((list.get(i)+list.get(i+1))%10);
            }
            newList.add(0);
            list=newList;
        }

        if(list.get(0)%2==1){
            System.out.println("I'm a winner!");
        }
        else{
            System.out.println("You're the winner?");
        }

    }
}
