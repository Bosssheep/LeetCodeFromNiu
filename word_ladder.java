import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end
 Given:
 start ="hit"
 end ="cog"
 dict =["hot","dot","dog","lot","log"]
 As one shortest transformation is"hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length5.
 //主要思想：广度优先搜索。先构造一个字符串队列，并将start加入队列。1.对队列头字符串做单个字符替换
 //每次替换后，2.判断是否和end匹配，如果匹配，返回答案；3.没有匹配，则在字典里面查询是否有“邻居字符串”,
 //如果有，则将该字符串加入队列，同时将该字符串从字典里删除。重复1的过程，知道和end匹配。如果最后队列
 //为空还未匹配到，则返回0.
 */
public class word_ladder {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> queue = new LinkedList<>();
        int res = 1;

        queue.offer(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                String s = queue.poll();
                size--;
                if(isDiffOne(s,end)){
                    return res+1;
                }
                Iterator<String> it = dict.iterator();
                while(it.hasNext()){
                    String str = it.next();
                    if(isDiffOne(str,s)){
                        queue.offer(str);
                        it.remove();
                    }
                }
            }
            res++;
        }
        return 0;
    }
    //判断s1 s2是否只相差一个字母
    private boolean isDiffOne(String s1,String s2){
        int count = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))
                count++;
        }
        return count==1 ? true:false;
    }
}
