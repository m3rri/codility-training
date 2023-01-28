import java.util.HashSet;
import java.util.Set;

//O(N)
class Solution {
    public int solution(int X, int[] A) {
        int second = -1;

        if(A.length>=X){
            Set<Integer> leavesPosition = new HashSet();

            for(int i=0; i<A.length; i++){
                leavesPosition.add(A[i]);
                
                if(leavesPosition.size()==X){
                    second = i;
                    break;
                }
            }
        }

        return second;
    }
}

import java.util.Map;
import java.util.HashMap;

//O(N)
class Solution {
    public int solution(int X, int[] A) {
        int second = -1;

        if(A.length>=X){
            Map<Integer, Boolean> leavesPosition = new HashMap();

            for(int i=0; i<A.length; i++){
                leavesPosition.put(A[i], true);
                
                if(i>=(X-1) && leavesPosition.keySet().size()==X){ //i 체크 별 차이 없음
                    second = i;
                    break;
                }
            }
        }

        return second;
    }
}
