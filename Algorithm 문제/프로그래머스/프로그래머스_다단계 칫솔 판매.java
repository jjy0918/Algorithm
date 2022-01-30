import java.util.*;

class Solution {
public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        HashMap<String,Integer> nameToNum = new HashMap<>();

        int index=0;
        nameToNum.put("-",10001);

        // String -> Index
        for(String s : enroll){
            nameToNum.put(s,index);
            index++;
        }
        
        // 자식의 부모 노드 저장
        int parents[] = new int[enroll.length];
        int money[] = new int[enroll.length];

        for(int i=0;i<enroll.length;i++){
            int parent = nameToNum.get(referral[i]);
            int child = nameToNum.get(enroll[i]);

            parents[child]=parent;
        }
        
        // 해당 노드부터 부모로 올라가면서 10% 상납
        for(int i=0;i<seller.length;i++){
            int name = nameToNum.get(seller[i]);
            int spendMoney = amount[i]*10;

            money[name]+=amount[i]*90;
            name=parents[name];
            while(name!=10001 && spendMoney >0){
                int totalMoney=spendMoney;
                spendMoney/=10;
                money[name]+=totalMoney-spendMoney;
                name=parents[name];
            }

        }

        return money;
    }
}