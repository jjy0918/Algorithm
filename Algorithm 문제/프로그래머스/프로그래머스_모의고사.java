import java.util.*;
class Solution {
    
    public int num1[]=new int[]{1,2,3,4,5};
    public int num2[]=new int[]{2,1,2,3,2,4,2,5};
    public int num3[]=new int[]{3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int score1=0;
        int score2=0;
        int score3=0;
        
        int len1=5;
        int len2=8;
        int len3=10;
        
        for(int i=0;i<answers.length;i++){
            score1+=(answers[i]==num1[i%len1])?1:0;
            score2+=(answers[i]==num2[i%len2])?1:0;
            score3+=(answers[i]==num3[i%len3])?1:0;
        }

        int maxScore=score1;
        answer=new int[]{1};

        if(maxScore < score2){
            maxScore = score2;
             answer=new int[]{2};
        }
        else if(maxScore == score2){
            int newAnswer[]=new int[answer.length+1];
            for(int i=0;i<answer.length;i++){
                newAnswer[i]=answer[i];
            }
            
            newAnswer[answer.length]=2;
            answer=newAnswer;
        }
        
        if(maxScore < score3){
            maxScore = score3;
             answer=new int[]{3};
        }
        else if(maxScore == score3){
            int newAnswer[]=new int[answer.length+1];
            for(int i=0;i<answer.length;i++){
                newAnswer[i]=answer[i];
            }
            newAnswer[answer.length]=3;
            answer=newAnswer;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}