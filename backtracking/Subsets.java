package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给一个数组，返回所有可能的子数组，包括空数组和自身
 */
public class Subsets {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<Integer> innerList = new ArrayList<>();
        Arrays.sort(S);
        for(int i=0;i<=S.length;i++){
            backTracking(S,innerList,0,i);
        }
        return result;
    }

    public void backTracking(int[] S,ArrayList<Integer> innerList,int start,int len){
        if(len<0){
            return;
        }else if(len==0){
            result.add(new ArrayList<>(innerList));
        }

        for(int i=start;i<S.length;i++){
            innerList.add(S[i]);
            backTracking(S,innerList,i+1,len-1);
            innerList.remove(innerList.size()-1);
        }
    }
}
