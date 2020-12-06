/*
    [2019 카카오 개발자 겨울 인턴십] 크레인 인형뽑기 게임(C++)
    https://programmers.co.kr/learn/courses/30/lessons/64061
    https://9327144.tistory.com/entry/2019-%EC%B9%B4%EC%B9%B4%EC%98%A4-%EA%B0%9C%EB%B0%9C%EC%9E%90-%EA%B2%A8%EC%9A%B8-%EC%9D%B8%ED%84%B4%EC%8B%AD-%ED%81%AC%EB%A0%88%EC%9D%B8-%EC%9D%B8%ED%98%95%EB%BD%91%EA%B8%B0-%EA%B2%8C%EC%9E%84C
*/

#include <bits/stdc++.h>

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    
    // 크레인으로 가져온 인형을 담을 바구니
    stack<int> bags;
    
    // 크레인을 움직이는 moves 값 순회
    for(auto m : moves)
    {
        for(int i=0;i<board.size();i++)
        {
       		// 해당 위치의 값이 0이 아닌 경우
            // ==> 해당 위치에 인형이 존재한다.
            if(board[i][m-1]!=0)
            {
                int dollNumber = board[i][m-1];
                if(bags.empty())
                    bags.push(dollNumber);
                else if(bags.top()==dollNumber)
                {
                    bags.pop();
                    answer+=2;
                }
                else
                    bags.push(dollNumber);
                    
                board[i][m-1]=0;
                
                break;
            }
        }
    }
    
    
    return answer;
}