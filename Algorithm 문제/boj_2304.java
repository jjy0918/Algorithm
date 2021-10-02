package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/2304
// 창고 다각형
public class boj_1002_2304 {
    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Node> arr = new ArrayList<>();

        int N = Integer.parseInt(bf.readLine());

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int index = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            arr.add(new Node(index,height));
        }

        Collections.sort(arr,(n1, n2)->{
            if(n1.index < n2.index){
                return -1;
            }
            return 1;
        });

        int result=0;
        int startNode=-1;

        for(int i=0;i<N;i++){
            Node nowNode = arr.get(i);

            boolean isLast=true;

            for(int j=i+1;j<N;j++){
                Node nextNode =arr.get(j);
                if(nowNode.height <= nextNode.height){
                    result+=nowNode.height*(nextNode.index- nowNode.index);

                    isLast=false;
                    i=j-1;

                    nowNode=nextNode;

                    break;
                }
            }

            if(isLast){

                startNode=i;
                result+=nowNode.height;
                break;
            }
        }

        for(int i=N-1;i>startNode && startNode!=-1;i--){
            Node nowNode = arr.get(i);

            boolean isLast=true;

            for(int j=i-1;j>startNode;j--){
                Node nextNode =arr.get(j);
                if(nowNode.height <= nextNode.height){
                    result+=nowNode.height*(nowNode.index- nextNode.index);

                    isLast=false;
                    i=j+1;

                    nowNode=nextNode;

                    break;
                }
            }

            // 가장 큰거
            if(isLast){
                Node nextNode =arr.get(startNode);
                result+=nowNode.height*(nowNode.index- nextNode.index);
                break;
            }
        }

        System.out.println(result);

    }

    public static class Node{
        int index;
        int height;

        public Node(int index, int height) {
            this.index = index;
            this.height = height;
        }

    }
}
