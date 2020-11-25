#include <vector>  // 헤더 선언 필요

vector<int> v;  // int 자료형을 저장하는 벡터 선언

// 벡터의 초기 크기를 n으로 설정.
vector<int> v(n);  

// 벡터의 초기 크기를 n으로 설정하고, 모두 p로 초기화
vector<int> v(n,p);

// nxm 크기의 벡터를 선언하고, 모두 p로 초기화
vector<vector<int>> v(n,vector<m,p>);

// i번째 원소 제거
v.erase(v.begin()+i);

// 벡터 vDest에 벡터 v를 복사하여 저장
vector<int> vDest(v);

// 벡터 vDest에 벡터 v의 i번째 원소부터 끝까지 복사하여 저장
vector<int> vDest = vector<int>(v.being()+i, v.end);

// 벡터에서 "=" 연산자는 Deep Copy로 작동한다. 
vector<int> vDest;
vDest=v;

// 벡터에 원소가 있는지 확인. 원소가 있는 경우 true, 없는 경우 false 반환
v.empty();  

// 벡터의 크기 재조정.
v.resize(n);
