package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/14226
// 이모티콘

public class boj_1004_14226 {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(bf.readLine());

        boolean vistied[][] = new boolean[1025][1025];

        Queue<Emo> q = new LinkedList<>();

        int result=0;

        q.add(new Emo(1,0));

        while(!q.isEmpty()){

            int size=q.size();

            while(size-- > 0){

                Emo nowEmo = q.poll();

                if(nowEmo.nowCnt==S){
                    System.out.println(result);
                    return;
                }

                // 화면 이모티콘 복사하여 클립보드에 저장
                // 화면에 아무것도 없거나 클립보드랑 똑같으면 의미 없음
                if(nowEmo.nowCnt > 0 && nowEmo.nowCnt != nowEmo.clipCnt
                        && !vistied[nowEmo.nowCnt][nowEmo.nowCnt]){
                    vistied[nowEmo.nowCnt][nowEmo.nowCnt]=true;
                    q.add(new Emo(nowEmo.nowCnt,nowEmo.nowCnt));
                }

                // 클립보드 화면으로 붙여넣기
                // 클립보드 비어 있으면 의미 없음
                if(nowEmo.clipCnt!=0  && nowEmo.nowCnt+ nowEmo.clipCnt <1025
                        && !vistied[nowEmo.nowCnt+ nowEmo.clipCnt][nowEmo.clipCnt]){
                    vistied[nowEmo.nowCnt+ nowEmo.clipCnt][nowEmo.clipCnt]=true;
                    q.add(new Emo(nowEmo.nowCnt+ nowEmo.clipCnt, nowEmo.clipCnt));
                }

                // 화면 이모티콘 하나 삭제
                // 화면 이모티콘이 없으면 의미 없음
                if(nowEmo.nowCnt>0 && !vistied[nowEmo.nowCnt-1][nowEmo.clipCnt]){
                    vistied[nowEmo.nowCnt-1][nowEmo.clipCnt]=true;
                    q.add(new Emo(nowEmo.nowCnt-1, nowEmo.clipCnt));
                }
            }
            result++;
        }
    }

    public static class Emo{
        int nowCnt;
        int clipCnt;

        public Emo(int nowCnt, int clipCnt) {
            this.nowCnt = nowCnt;
            this.clipCnt = clipCnt;
        }
    }
}
