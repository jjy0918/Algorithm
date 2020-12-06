/*
    [2019 카카오 개발자 겨울 인턴십] 크레인 인형뽑기 게임(C++)
    https://programmers.co.kr/learn/courses/30/lessons/64062#
    https://9327144.tistory.com/entry/2019-%EC%B9%B4%EC%B9%B4%EC%98%A4-%EA%B0%9C%EB%B0%9C%EC%9E%90-%EA%B2%A8%EC%9A%B8-%EC%9D%B8%ED%84%B4%EC%8B%AD-%EC%A7%95%EA%B2%80%EB%8B%A4%EB%A6%AC-%EA%B1%B4%EB%84%88%EA%B8%B0C
*/

#include <bits/stdc++.h>


using namespace std;

bool stonesSum(vector<int> &stones, int k, int mid)
{
	int sum = 0;
	for (int i = 0; i < stones.size(); i++)
	{
		if (stones[i] - mid < 0)
		{
			sum++;

			if(sum >= k)
				return false;

		}
		else
		{
			sum = 0;
		}
		
	}
	return true;
}


int solution(vector<int> stones, int k) {
	int answer = 0;

	int maxNum = 200000000;
	int minNum = 1;

	

	while (maxNum >= minNum)
	{
		int mid = (maxNum + minNum) / 2;
		if (stonesSum(stones, k, mid))
		{
			answer = mid;
			minNum = mid + 1;
		}
		else
		{
			maxNum = mid - 1;
		}


		
	}

	return answer;
}