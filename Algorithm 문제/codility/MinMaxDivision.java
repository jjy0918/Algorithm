class Solution {
	public int solution(int K, int M, int[] A) {
		int start = 0;
		int last = M * A.length;
		int result = last;

		if (A.length == 1) {
			return A[0];
		}

		while (start <= last) {
			int mid = (start + last) / 2;
			if (isPossible(A, K, mid)) {
				result = mid;
				last = mid-1;
			} else {
				start = mid + 1;
			}
		}

		return result;
	}

	public boolean isPossible(int[] A, int K, int value) {
		int nowSum = 0;
		for (int i =0;i<A.length;i++) {
			if (A[i] > value) {
				return false;
			}
			nowSum += A[i];
			if (nowSum == value) {
				K--;
				nowSum = 0;
			}

			if (nowSum > value) {
				K--;
				nowSum = A[i];
			}
		}

		if (nowSum > 0) {
			K--;
		}

		return K >= 0;
	}
}
