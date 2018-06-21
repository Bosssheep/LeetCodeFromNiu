import java.util.*;

/**
 *

 Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 Return all such possible sentences.
 For example, given
 s ="catsanddog",
 dict =["cat", "cats", "and", "sand", "dog"].
 A solution is["cats and dog", "cat sand dog"].
 */

public class word_break_li {
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
            HashMap<String,List<String>> map = new HashMap<String,List<String>>();
            return dfs(s,dict,map);
    }

    public static ArrayList<String> dfs(String s,Set<String> dict, HashMap<String,List<String>> map){
        if(map.containsKey(s))
            return (ArrayList<String>) map.get(s);

        ArrayList<String> lists  =  new ArrayList<>();
        if(s.equals("")) {
            lists.add("");
        }
        else{
            int len = s.length();
            for(int i=1;i <= len ;i++){
                String sub = s.substring(0,i);
                //截取左字串，如果在字典中，则继续获得剩下的右字串能形成单词的列表
                if(dict.contains(sub)){
                    ArrayList t = dfs(s.substring(i,len),dict,map);
                    if(t.size()==0){
                        continue;
                    }
                    else{
                        //拼接左右的单词
                        for(int j = 0;j < t.size();j++){
                            StringBuilder temp = new StringBuilder();
                            temp.append(sub).append(" ").append(t.get(j));
                            lists.add(temp.toString().trim());
                        }
                    }
                }
            }
        }
        map.put(s,lists);//map存放s字符串对应组成的英语句子
        return lists;
    }

    public static void main(String[] args){
        String s = "a";
        Set<String> set = new HashSet<>();
        set.add("a");

        ArrayList<String> res = wordBreak(s,set);
        System.out.print(res);
    }
}
