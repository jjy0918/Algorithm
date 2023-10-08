package boj.y2022;

public class boj_1091 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        int[] S = new int[N];
        int[] base = new int[N];
        int[] now = new int[N];
        for(int i = 0; i < N; i++) {
            base[i] = i % 3;
            now[i] = i % 3;
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        int shuffleCount = 0;

        while (true) {
            if (isSame(now, S)) {
                System.out.println(shuffleCount);
                break;
            }

            now = shuffle(now, P);
            shuffleCount++;

            if (isSame(now, base)) {
                System.out.println(-1);
                break;
            }
        }
    }

    private static int[] shuffle(int[] now, int[] rule) {
        int[] result = new int[now.length];

        for(int i = 0; i < now.length; i++) {
            result[i] = now[rule[i]];
        }

        return result;
    }

    private static boolean isSame(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
}
