/** 70%
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] A) {
        int expectedSum, result;
        int arrayLength = A.length;

        arrayLength++;

        expectedSum = arrayLength*(arrayLength+1)/2;
        result = IntStream.of(A)
        .reduce((acc, curr)->acc+curr)
        .getAsInt();
        
        return expectedSum-result;
    }
}
*/

//O(N) or O(N * log(N))
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] A) {
        long arrayLength = A.length;
        
        if(arrayLength==0){
            //이 경우 N=0, [1..N+1]=[1] 이어야하는데 빈배열이므로 1이 빠진 것
            return 1;
        }else{
            long expectedSum, result;

            arrayLength++;

            expectedSum = arrayLength*(arrayLength+1)/2;
            result = IntStream
                .of(A)
                .reduce((acc, curr)->acc+curr)
                .getAsInt();

            return Long.valueOf(expectedSum-result).intValue();
        }
    }
}
