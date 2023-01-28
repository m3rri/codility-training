import java.util.stream.IntStream;

//O(N*M) -> 55%
class Solution {
    private int[] counters;

    public int[] solution(int N, int[] A) {
        this.counters = new int[N];

        for(int a : A){
            if(a<=N){
                increase(a);
            }else{
                maxCounter();
            }
        }

        return this.counters;
    }

    private void increase(int X){
        this.counters[X-1]++;
    }

    private void maxCounter(){
        int max = getMax();
        
        this.counters = IntStream
            .of(this.counters)
            .map(a->max)
            .toArray();
    }

    private int getMax(){
        return IntStream
            .of(this.counters)
            .max()
            .getAsInt();
    }
}
