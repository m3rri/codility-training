import java.util.stream.IntStream;
//O(N)
class Solution {
    public int solution(int[] A) {
        if(A.length==2){
            return Math.abs(A[0]-A[1]);
        }else{
            int result = Integer.MAX_VALUE;
            int totalSum = IntStream.of(A).reduce((acc, curr)->acc+curr).getAsInt();
            int frontSum = 0;
            int a;
            
            for(int i=0; i<A.length-1; i++){
                a = A[i];

                frontSum += a;
                totalSum -= a;
                //System.out.println("front : "+frontSum+", total : "+totalSum);

                result = Math.min(result, Math.abs(totalSum-frontSum));
                //System.out.println("result : "+result);
                if(result==0 || result==1){
                    break;
                }
            }
            
//             for(int a : A){
//                 frontSum += a;
//                 totalSum -= a;
//                 //System.out.println("front : "+frontSum+", total : "+totalSum);

//                 result = Math.min(result, Math.abs(totalSum-frontSum));
//                 //System.out.println("result : "+result);
//                 if(result==0 || result==1){
//                     break;
//                 }
//             }
//failed [-10, -20, -30, -40, 100] case -> 92%

            return result;
        }
    }
}
