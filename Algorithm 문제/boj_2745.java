package boj;

import javax.jws.soap.SOAPBinding;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

// https://www.acmicpc.net/problem/2745
// 진법 변환
public class boj_0912_2745 {

    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        String number = st.nextToken();

        int baseNum = Integer.parseInt(st.nextToken());

        int result=0;

        int multiNumber=1;


        for(int i=number.length()-1;i>=0;i--){

            char nowNumber = number.charAt(i);
            int changeNum;

            if('0'<= nowNumber && nowNumber <= '9'){
                changeNum = (nowNumber - '0');
            }
            else{
                changeNum = nowNumber-'A' + 10;
            }

            result += changeNum * multiNumber;

            multiNumber *= baseNum;

        }

        System.out.println(result);



    }


}

