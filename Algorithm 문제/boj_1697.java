import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1697
// 숨바꼭질
public class Main {

    static int dy[]=new int[]{1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int visited[] = new int[100001];

        Arrays.fill(visited,Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();

        visited[N]=0;
        q.add(N);

        while (!q.isEmpty()){

            int now = q.peek();
            q.poll();

            if(now==K){
                break;
            }

            int cnt = visited[now]+1;

            for(int i=0;i<3;i++){
                int next;
                if(i==2){
                    next=now*2;
                }
                else{
                    next = now+dy[i];
                }
                if(next < 0 || next > 100000 ||visited[next]!=Integer.MAX_VALUE){
                    continue;
                }
                visited[next]=cnt;
                q.add(next);

            }
        }

        System.out.println(visited[K]);
        
    }
}
