import java.util.stream.IntStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//O(N + M)
class Solution {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int a : A){
            if(a<=N){
                Integer value = map.get(a);

                if(value!=null){
                    value++;
                }else{
                    value=1;
                }

                map.put(a, value);
            }else{
                Collection<Integer> values = map.values();
                if(values.size()>0){
                    max += Collections.max(values);
                    map = new HashMap<>();
                }
            }
        }

        for(int i=0; i<N; i++){
            Integer value = map.get(i+1);
            counters[i] = max + (value==null ? 0 : value);
        }

        return counters;
    }
}

import java.util.stream.IntStream;

//O(N*M) -> 55%
class Solution {
    private int[] counters;

    public int[] solution(int N, int[] A) {
        int max = 0;
        initCounters(N);

        for(int a : A){
            if(a<=N){
                increase(a);
            }else{
                max += getMax();
                initCounters(N);
            }
        }

        maxCounter(max);

        return this.counters;
    }

    private void initCounters(int N){
        this.counters = new int[N];
    }

    private void increase(int X){
        this.counters[X-1]++;
    }

    private void maxCounter(int max){
        this.counters = IntStream
            .of(this.counters)
            .map(a->a+max)
            .toArray();
    }

    private int getMax(){
        return IntStream
            .of(this.counters)
            .max()
            .getAsInt();
    }
}

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
