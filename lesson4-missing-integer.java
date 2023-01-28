import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Iterator;
import java.util.Set;

//O(N) or O(N * log(N))
class Solution {
    public int solution(int[] A) {
        int result = 0;
        int M = A.length;

        if(M<=1){
            result = 1;

            if(M==1 && A[0]==1){
                result = 2;
            }
        }else{
            Set<Integer> set = new HashSet<>();
            IntStream.of(A).forEach(a->{
                if(a>0){
                    set.add(a);
                }
            });

            if(set.size()>0){
                int min = Collections.min(set);
                int max = Collections.max(set);

                if(min>1 || max<1){
                    result = 1;
                }else if(set.size()==max-min+1){
                    result = max+1;
                }else{
                    List<Integer> list = new ArrayList<>();
                    Iterator<Integer> it = set.iterator();

                    while(it.hasNext()){
                        list.add(it.next());
                    }
                    list.sort((a, b)->a-b);

                    for(int i=1; i<list.size(); i++){
                        if(list.get(i)-list.get(i-1)>1){
                            result = list.get(i-1)+1;
                            break;
                        }
                    }
                }
            }else{
                result++;
            }
        }
        
        return result;
    }
}

//짧ver
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Iterator;
import java.util.Set;

class Solution {
    public int solution(int[] A) {
        int result = 0;
        int M = A.length;

        if(M<=1){
            result = M==1 && A[0]==1 ? 2 : 1;
        }else{
            List<Integer> list = new ArrayList<>();
            IntStream.of(A).forEach(a->{
                if(a>0){
                    list.add(a);
                }
            });

            M = list.size();

            if(M<=1){
                result = M==1 && list.get(0)==1 ? 2 : 1;
            }else{
                list.sort((a, b)->a-b);

                for(int i=0; i<M; i++){
                    if(i==0){
                        if(list.get(i)>1){
                            result = 1;
                            break;
                        }
                    }else if(list.get(i)-list.get(i-1)>1){
                        result = list.get(i-1)+1;
                        break;
                    }

                    if(i==M-1){
                        result = list.get(i)+1;
                    }
                }
            }
        }
        
        return result;
    }
}
