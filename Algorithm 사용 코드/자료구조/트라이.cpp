#include <bits/stdc++.h>
#include <string>

using namespace std;

struct Trie
{
	// 알파벳 26자
	Trie *childNode[26];
	bool isFinish;

	Trie()
	{
		isFinish = false;
		for (int i = 0; i < 26; i++)
			childNode[i] = NULL;
	}

	~Trie()
	{
		for (int i = 0; i < 26; i++)
		{
			// childNode[i] == NULL == 0
			// NULL이 아닌 값은 데이터 삭제
			if (childNode[i])
				delete childNode[i];
		}
	}
	
	// void insert(char *c)
	void insert(string& str, int i)
	{
    		// 문자열 끝인 경우
		// str.size()==i  =>  *c=='\0'
		if (str.size() == i)
		{
			isFinish = true;

		}
		else
		{
			// nextNode = *c-'A';
			int nextNode = str[i] - 'A';
			
			if (childNode[nextNode] == NULL)
			{
				childNode[nextNode] = new Trie();
			}
			
			//insert(c+1);
			childNode[nextNode]->insert(str, i + 1);
		}
	}
	
	// bool find(char *c)
	bool find(string& str,int i)
	{
		// 해당 문자가 기존의 트라이에 있는지 판단.
		// abc라는 문자만 트라이에 있고, ab를 탐색할 때 해당 노드는 
		// 트라이에 없기 때문에 isFinish(false) 출력
		// str.size()==i  =>  *c=='\0'
		if (str.size() == i)
		{
			return isFinish;
		}
		
		// nextNode = *c-'A';
		int nextNode = str[i] - 'A';

		if (childNode[nextNode] == NULL)
			return false;
		//find(c+1);
		return childNode[nextNode]->find(str,i+1);
	}
};
