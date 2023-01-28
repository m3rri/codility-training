import java.util.HashSet;
import java.util.Set;

//O(N) or O(N * log(N))
class Solution {
    public int solution(int[] A) {
        int result = 0;
        int MAX = A.length;

        if(MAX==1){
            result = A[0]==1 ? 1 : 0;
        }else{
            int min = 1000000001;
            int max = 0;
            Set<Integer> set = new HashSet<>();

            for(int a:A){
                set.add(a);
                min = Math.min(min, a);
                max = Math.max(max, a);

                if(set.size()==MAX){
                    if(min==1 && max==MAX){
                        result = 1;
                    }

                    break;
                }
            }
        }
        
        return result;
    }
}
