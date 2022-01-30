import java.util.*;
class Solution
{
    public int solution(String s)
        {
            int answer = -1;
            
            Stack<Character> q = new Stack<>();
            
            for(int i=0;i<s.length();i++){
                char nowChar = s.charAt(i);
                if(q.isEmpty()){
                    q.add(nowChar);
                }
                else{
                    char prevChar = q.peek();
                    
                    if(prevChar == nowChar){
                        q.pop();
                        
                    }
                    else{
                        q.add(nowChar);
                    }
                    
                }
            }


            return q.isEmpty() ? 1 : 0;
        }
}