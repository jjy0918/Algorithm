import java.util.*;

class Solution {
	public int solution(int k, int[] tangerine) {
		int answer = 0;

		Map<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i< tangerine.length;i++) {
			int num = tangerine[i];
			Integer value = map.getOrDefault(num, 0);

			map.put(num, value+1);
		}

		Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			q.add(entry.getValue());
		}
		while (!q.isEmpty()) {
			int value = q.poll();
			k -= value;
			answer++;

			if (k <= 0) {
				return answer;
			}
		}

		return answer;
	}
}

