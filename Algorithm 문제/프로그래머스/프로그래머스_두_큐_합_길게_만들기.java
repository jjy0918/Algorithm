import java.util.*;

class Solution {
	public int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		long q1Sum = 0;
		long q2Sum = 0;
		Queue<Integer> q1 = new ArrayDeque<>();
		Queue<Integer> q2 = new ArrayDeque<>();

		for(int i = 0;i<queue1.length;i++) {
			q1Sum += queue1[i];
			q2Sum += queue2[i];
			q1.add(queue1[i]);
			q2.add(queue2[i]);
		}

		long sum = q1Sum + q2Sum;

		if (sum % 2 == 1) {
			return -1;
		}

		while (true) {
			if (q1Sum == q2Sum) {
				return answer;
			}
            
            if(answer > 600000) {
                return -1;
            }
            
    
			if (q1Sum > q2Sum) {
				int value = q1.poll();
				q2.add(value);
				q1Sum -= value;
				q2Sum += value;
			} else {
				int value = q2.poll();
				q1.add(value);
				q2Sum -= value;
				q1Sum += value;
			}
            answer++;
		}
	}
}
