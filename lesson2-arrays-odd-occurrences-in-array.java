import java.util.*;

class Solution {
    public int solution(int[] A) {
        if(A.length==1){
            return A[0];
        }else{
            Map<Integer, Integer> test = new HashMap<>();
            
            for(int _A : A){
                Integer exists = test.get(_A);
                
                if(exists==null){
                    test.put(_A, 1);
                }else{
                    test.remove(_A);
                }
            }

            return test.keySet().stream().findFirst().get();
        }
    }
}