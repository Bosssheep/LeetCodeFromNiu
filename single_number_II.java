import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 *  根据异或运算特点：
    两个相同的数进行异或，结果为0
 */
public class single_number_II {
    public int singleNumber(int[] A) {
        Map<Integer,Integer> hashmap = new HashMap<>();
        for(int i = 0; i < A.length;i++){
            Integer element = A[i];
            if(hashmap.containsKey(A[i])){
                Integer newvalue = hashmap.get(element);
                newvalue++;
                hashmap.put(element,newvalue);
            }
            else{
                hashmap.put(element,1);
            }
        }

        for(int i = 0;i<A.length;i++) {
            if (hashmap.get(A[i]) == 1)
                return A[i];
        }
        return 0;
    }
}
