/*
    [2019 카카오 개발자 겨울 인턴십] 크레인 인형뽑기 게임(C++)
    https://programmers.co.kr/learn/courses/30/lessons/64063
    https://9327144.tistory.com/entry/2019-%EC%B9%B4%EC%B9%B4%EC%98%A4-%EA%B0%9C%EB%B0%9C%EC%9E%90-%EA%B2%A8%EC%9A%B8-%EC%9D%B8%ED%84%B4%EC%8B%AD-%ED%98%B8%ED%85%94-%EB%B0%A9-%EB%B0%B0%EC%A0%95C
*/

#include <bits/stdc++.h>
#include <unordered_map>

using namespace std;

unordered_map<long long, long long> m;

long long findRoom(long long n)
{
	if (m[n] == 0)
	{
		m[n] = n + 1;
		return n;
	}
	return m[n]=findRoom(m[n]);
}


vector<long long> solution(long long k, vector<long long> room_number) {
	vector<long long> answer;

	for (auto rn : room_number)
	{
		long long frn = findRoom(rn);
		answer.push_back(frn);
	}


	return answer;
}