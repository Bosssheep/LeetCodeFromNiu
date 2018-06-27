import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 For example,
     Given[100, 4, 200, 1, 3, 2],
     The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
 Your algorithm should run in O(n) complexity.
 思路：
     用哈希表保存这些数，从左往右遍历数组，并且在哈希表里搜索这个数，并且在哈希表里搜寻 这个数-1 是否存在，若存在，结果+1，并且继续搜寻-1是否存在。
     +1逻辑依旧如此。并且将其标记为false表示遍历过了。
 */

public class longest_consecutive_sequence {
    public int longestConsecutive(int[] num) {
        int resMax = -1;
        if(num==null||num.length==0)
            return 0;
        if(num.length==1)
            return 1;

        int pre;//前数的前一个数
        int post;//后一个数
        int max=1;//暂时的最大连续值
        Map<Integer,Boolean> hashmap = new HashMap<>();
        for(int n:num){
            hashmap.put(n,true);
        }

        for(int i=0;i<num.length;i++){
            if(hashmap.get(num[i])==true){
                pre = num[i]-1; //当前数的前一个相邻数
                post = num[i]+1;//当前数的后一个相邻数
                while(hashmap.containsKey(pre)){
                    hashmap.put(pre,false);//置值为false，下次不用再访问
                    pre--;//找相邻的前一个数
                    max++;
                }
                while(hashmap.containsKey(post)){
                    post++;//找相邻的后一个数
                    max++;
                }
                if(resMax < max)
                    resMax = max;
                max = 1;
            }
        }
        return resMax;
    }
}
