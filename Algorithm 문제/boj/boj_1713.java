package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3079
// 후보 추천하기
public class boj_1001_1713 {

    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int M = Integer.parseInt(bf.readLine());

        Frame frames[] = new Frame[101];
        Arrays.fill(frames,new Frame(0,-1));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int frameNum=0;

        for(int d=0;d<M;d++){
            int num = Integer.parseInt(st.nextToken());

            // 새롭게 추가되는 경우
            if(frames[num].isEmpty()){

                // 사진틀이 가득찬 경우
                if(frameNum == N){
                    // 삭제할 사진틀의 위치
                    int deleteNum=-1;

                    for(int i=1;i<=100;i++){
                        if(frames[i].isEmpty()){
                            continue;
                        }

                        if(deleteNum==-1){
                            deleteNum=i;
                        }
                        else{
                            if(frames[deleteNum].cnt >  frames[i].cnt){
                                deleteNum=i;
                            }
                            else if(frames[deleteNum].cnt == frames[i].cnt){
                                deleteNum = frames[deleteNum].day < frames[i].day ? deleteNum : i;
                            }
                        }

                    }
                    // 해당 사진틀 번호 삭제
                    frames[deleteNum]=new Frame(0,-1);
                    frameNum--;
                }
                // 새로운 사진틀 추가
                frames[num]=new Frame(0,d);

                frameNum++;
            }

            frames[num].cnt++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=100;i++){
            if(!frames[i].isEmpty()){
                sb.append(i);
                sb.append(" ");
            }
        }

        System.out.println(sb);


    }

    public static class Frame{
        int cnt;
        int day;

        public Frame(int cnt, int day) {
            this.cnt = cnt;
            this.day = day;
        }

        public boolean isEmpty(){
            return day==-1;
        }
    }
}
