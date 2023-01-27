import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] A, int K) {
        int arrayLen = A.length;

        if(arrayLen==0){
            return A;
        }
        
        K = K >= arrayLen ? K % arrayLen : K;

        if(K==0){
            //System.out.println("skip");
            return A;
        }else{
            return IntStream.concat(
                IntStream.of(A)
                    .skip(arrayLen-K),
                IntStream.of(A)
                    .limit(arrayLen-K)
            ).toArray();
        }
    }
}