package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj_0826_6137 {

    static char S[] = new char[2001];

    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        for(int i=0;i<N;i++){
            S[i]=bf.readLine().charAt(0);
        }

        int start=0;
        int end=N-1;

        int cnt=0;

        StringBuilder sb = new StringBuilder();
        while(start <= end){
            int cmp = compareChar(S[start],S[end]);
            if(cmp<0){
                sb.append(S[end]);
                end--;
                if(sb.length()>0 && (sb.length()-cnt)%80==0){
                    sb.append("\n");
                    cnt++;
                }
            }
            else if(cmp>0){
                sb.append(S[start]);
                start++;
                if(sb.length()>0 && (sb.length()-cnt)%80==0){
                    sb.append("\n");
                    cnt++;
                }
            }
            else{
               int n = dfs(start+1,end-1,1);

               char nowChar=S[start];
               if(n<0){
                   for(int i=0;i<-n;i++){
                       if(nowChar!=S[end])
                           break;
                       sb.append(S[end]);

                       end--;
                       if(sb.length()>0 && (sb.length()-cnt)%80==0){
                           sb.append("\n");
                           cnt++;
                       }
                   }


               }
               else if(n>0){


                   for(int i=0;i<n;i++){
                       if(nowChar!=S[start])
                           break;
                       sb.append(S[start]);

                       start++;
                       if(sb.length()>0 && (sb.length()-cnt)%80==0){
                           sb.append("\n");
                           cnt++;
                       }
                   }
               }
            }
        }

        System.out.println(sb.toString());


    }

    static int dfs(int start,int end,int cnt){
        if(start > end){
            return -cnt;
        }
        int cmp = compareChar(S[start],S[end]);

        if(cmp<0){
            return -cnt;
        }
        else if(cmp>0){
            return cnt;

        }
        return dfs(start+1,end-1,cnt+1);


    }

    // c1이 작으면 1
    static int compareChar(char c1,char c2){

        if(c1>=97 && c2<97){
            return 1;
        }

        if(c1<97 && c2>=97){
            return -1;
        }

        return Character.compare(c2, c1);
    }


}
