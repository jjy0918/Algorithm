package program;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_20366 {
	public static int heights[] = new int[601];
	public static int N ;

	public static void main(String[] args) throws IOException{

		System.setIn(new FileInputStream("input.txt"));

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bf.readLine());

		int result = Integer.MAX_VALUE;

		Arrays.fill(heights, Integer.MAX_VALUE);

		StringTokenizer st = new StringTokenizer(bf.readLine());

		for(int i=0;i<N;i++){
			heights[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(heights);

		for(int i=0; i<N; i++){
			for(int j=i+1;j<N;j++){
				for(int k=0;k<j;k++){
					if(i==k){
						continue;
					}
					int num = heights[i]+heights[j]-heights[k];
					// k i j
					if(k < i) {
						result = Integer.min(result, binary(i+1, j-1, num));
					}
					// i k j
					else{
						result = Integer.min(result, binary(k+1, j-1, num));
					}
					result = Integer.min(result, binary(j+1, N-1, num));
				}
			}
		}

		System.out.println(result);

	}
	// 1 4 8
	// 답은 3 last
	public static int binary(int start,int last, int num) {
		int result = Integer.MAX_VALUE;
		while(start <= last){
			int mid = (start + last)/2;
			result = Integer.min(result, Math.abs(heights[mid] - num));
			if(num == heights[mid]){
				return 0;
			}
			if(num < heights[mid]){
				last = mid-1;
			}
			else{
				start = mid+1;
			}

		}
		return result;
	}

}
