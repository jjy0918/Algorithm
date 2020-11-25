#include <algorithm>

// 정렬
// 기본 오름 차순
sort(vec.begin(), vec.end());

// 내림 차순
sort(vec.begin(), vec.end(), greater<int>());

// 원소 제거 (범위)
vec.erase(vec.begin()+3, vec.end());

// 원소 제거(특정 원소)
vec.erase(remove(vec.begin(), vec.end(), 10), vec.end());

// 중복 원소 제거
vec.erase(unique(vec.begin(), vec.end()), vec.end());

// 원소 개수
count(vec.begin(), vec.end(), 3)

// 이진 탐색
binary_search(v.begin(), v.end(), 25)

*lower_bound(v.begin(), v.end(), 25)
*upper_bound(v.begin(), v.end(), 25)