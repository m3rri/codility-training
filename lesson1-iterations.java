// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        int result = 0;
        int gapLength = 0;
        boolean start = false;

        while(N>1){
            int nameoji = N%2;

            if(start || nameoji!=0){
                start = true;

                if(nameoji!=0){
                    result = Math.max(result, gapLength);
                    gapLength = 0;
                }else{
                    gapLength++;
                }
            }
            
            N /= 2;
        }

        result = Math.max(result, gapLength);

        //System.out.println("result : " + result);

        return result;
    }
}