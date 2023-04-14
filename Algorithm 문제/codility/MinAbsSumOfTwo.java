import java.util.ArrayList;
import java.util.List;

class Solution {
	public int solution(int[] A) {

		List<Integer> sortedList = new ArrayList<>();
		for (int i = 0;i< A.length; i++) {
			sortedList.add(A[i]);
		}
		sortedList.sort(Integer::compareTo);

		int result = Integer.MAX_VALUE;

		int start = 0;
		int last = sortedList.size() - 1;
		while (start <= last) {
			int sum = sortedList.get(start) + sortedList.get(last);
			result = Integer.min(result, Math.abs(sum));

			if (sum < 0) {
				start++;
			} else {
				last--;
			}
		}

		return result;
	}
}
