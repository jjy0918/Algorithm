/*
    [2019 카카오 개발자 겨울 인턴십] 크레인 인형뽑기 게임(C++)
    https://programmers.co.kr/learn/courses/30/lessons/64064
    https://9327144.tistory.com/entry/2019-%EC%B9%B4%EC%B9%B4%EC%98%A4-%EA%B0%9C%EB%B0%9C%EC%9E%90-%EA%B2%A8%EC%9A%B8-%EC%9D%B8%ED%84%B4%EC%8B%AD-%EB%B6%88%EB%9F%89-%EC%82%AC%EC%9A%A9%EC%9E%90C
*/

#include <bits/stdc++.h>

using namespace std;

set<int> s;

// search_id => 불량 사용자에 맞는 사용자 아이디 목록
// selectedIDNum => 기존 조합의 개수
// addNumber => 조합을 이루기 위해 선택된 값
// resultNumber => 조합된 값.
void dfs(vector<vector<int>> &search_id, int numberSize, int addNumber, int resultNumber)
{
	// 기존의 조합안에 새로 추가 될 값이 존재하는지 확인
	// &연산을 이용하여 last의 인덱스가 기존의 조합(resultNumber)에 
	// 존재하는지 확인,
	// 존재한다 => 중복 값이 있다.
	// 존재하지 않는다 => 중복 값이 없다.
	if (resultNumber & (1 << addNumber))
		return;

	// 기존 조합에 새로운 값 추가
	resultNumber |= (1 << addNumber);

	// 조합의 길이가 제재 아이디 목록 개수와 같은지 확인
	if (numberSize == search_id.size())
	{
		// 같다면, set에 추가.
		// set은 중복을 허용하지 않는다.
		s.insert(resultNumber);

		return;
	}

	for (int i = 0; i < search_id[numberSize].size(); i++)
	{
		dfs(search_id, numberSize + 1, search_id[numberSize][i], resultNumber);
	}

	return;
}

// 제재 아이디 찾기
void findstr(vector<string> user_id, string banned_id, vector<int> &v)
{
	bool isSame = false;
	for (int i = 0; i < user_id.size(); i++)
	{
		string uid = user_id[i];
		isSame = true;
		if (uid.size() != banned_id.size())
			continue;

		for (int j = 0; j < uid.size(); j++)
		{
			if (banned_id[j] == '*')
				continue;
			if (uid[j] != banned_id[j])
			{
				isSame = false;
				break;
			}
		}

		// 제재 아이디 찾기 성공.
		if (isSame)
			v.push_back(i);
	}
}



int solution(vector<string> user_id, vector<string> banned_id) {

	vector<vector<int>> search_id;
	for (int i = 0; i < banned_id.size(); i++)
	{
		vector<int> v;
		findstr(user_id, banned_id[i], v);
		search_id.push_back(v);
	}
	

	for (int i = 0; i < search_id[0].size(); i++)
	{

		dfs(search_id, 1, search_id[0][i],0);
	}


	return s.size();
}