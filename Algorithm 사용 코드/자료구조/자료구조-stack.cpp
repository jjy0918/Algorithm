// 헤더 선언 필요
#include <stack> 

// int 자료형을 저장하는 스택 선언
stack<int> st;

// 원소 n 삽입
st.push(n);

// 맨 위 원소 제거
st.pop();

// 맨 위 원소 조회
st.top();

// 스택이 비있는지 확인.
// 비어있으면 true, 원소가 있으면 false 반환
st.empty();

// 스택의 크기(원소의 개수) 조회
st.size();