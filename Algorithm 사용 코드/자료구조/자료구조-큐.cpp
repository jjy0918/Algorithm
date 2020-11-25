// 헤더 선언 필요
#include <queue>

// int 자료형을 저장하는 큐 선언
queue<int> q;

// 원소 n 삽입
q.push(n);

// 맨 처음 원소 제거
q.pop();

// 맨 처음 원소 조회
q.front();

// 큐이 비어있는지 확인
// 원소가 없으면 true, 원소가 있으면 false 반환
q.empty();

// 큐의 크기(원소의 개수) 조회
q.size();

// 우선순위 큐

// 헤더 선언 필요
#include<queue>

// int 자료형을 저장하는 우선순위 큐 선언
// priority_queue<자료형, 구현체, 비교 연산자> pq; 
// 비교 연산자 생략 시 maxheap으로 선언된다.
priority_queue<int, vector<int>> pq;  

// less와 greater는 헤더에 #include <functional> 선언이 필요하다.
// maxheap(루트가 우선순위가 제일 높다) 선언
priority_queue<int, vector<int>, less<int>> pq;  

// minheap(루트가 우선순위가 제일 낮다) 선언
priority_queue<int, vector<int>, greater<int>> pq;  