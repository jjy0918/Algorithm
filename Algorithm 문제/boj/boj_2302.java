import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2302 {

    private static Integer[][] D = new Integer[41][2];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());

        dp();

        int prev = 1;
        int result = 1;
        for(int i=0;i<M;i++) {
            int n = Integer.parseInt(br.readLine());
            result *= D[n-prev][0] + D[n-prev][1];
            prev=n+1;
        }

        if (prev<N+1) {
            result *= D[N+1-prev][0] + D[N+1-prev][1];
        }

        System.out.println(result);
    }

    public static void dp() {
        D[0][0] = 0;
        D[0][1] = 1;

        for(int i=1; i<41; i++) {
            D[i][0] = D[i-1][0] + D[i-1][1];
            D[i][1] = D[i-1][0];

            System.out.println(i+" = " + (D[i][0] + D[i][1]));
        }
    }
}
