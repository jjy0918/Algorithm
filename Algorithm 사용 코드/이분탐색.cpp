// C++ STL 이용
// 해당 값이 있으면 true, 없으면 false
binary_search(v.begin(), v.end(), number);

// lower_bound, upper_bound
// lower_bound : 찾는 값 >= 기준 값 중 가장 작은 원소를 반환
// upper_bound : 찾는 값 > 기준 값 중 가장 작은 원소를 반환.
*lower_bound(v.begin(), v.end(), number);
*upper_bound(v.begin(), v.end(), number);

lower_bound(v.begin(), v.end(), number) - v.begin();
upper_bound(v.begin(), v.end(), number) - v.begin();

// 함수 만들어서 사용
int binarySearch(vector<int>& v, int target)
{
	// left는 첫 인덱스
	int left = 0;
	// right는 마지막 인덱스
	int right = v.size()-1; 
	int mid;

	while (left <= right)
	{
		mid = (left + right) / 2;

		// 탐색 완료한 경우 해당 인덱스 반환
		if (target == v[mid])
			return mid;
		else
		{
			// 중간 값이 더 큰 경우 중간 값 왼쪽 부분을 탐색하기 위해 right 값을 설정한다.
			if (target < v[mid])
				right = mid - 1;
			// 중간 값이 더 작은 경우 중간 값 오른쪽 부분을 탐색하기 위해 left 값을 설정한다.
			else
				left = mid + 1;
		}
	}

	// 탐색에 실패한 경우(값이 존재하지 않는 경우)
	return -1;
}