/*
    [2019 카카오 개발자 겨울 인턴십] 크레인 인형뽑기 게임(C++)
    https://programmers.co.kr/learn/courses/30/lessons/64065
    https://9327144.tistory.com/entry/2019-%EC%B9%B4%EC%B9%B4%EC%98%A4-%EA%B0%9C%EB%B0%9C%EC%9E%90-%EA%B2%A8%EC%9A%B8-%EC%9D%B8%ED%84%B4%EC%8B%AD-%ED%8A%9C%ED%94%8CC
*/

#include <bits/stdc++.h>
#include <unordered_map>
#include <string>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    unordered_map<int,int> um;
    string number="";
    
    for(auto c : s)
    {
        if(c=='{' || c=='}')
            continue;
        else if(c==',')
        {
            um[stoi(number)]++;
            number="";
        }
        else
            number+=c;
    }
    um[stoi(number)]++;
    
    answer=vector<int>(um.size(),0);
    
    for (auto u : um)
	{
		answer[um.size()-u.second]=u.first;
	}
    
    
    return answer;
}