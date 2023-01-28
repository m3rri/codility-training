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
