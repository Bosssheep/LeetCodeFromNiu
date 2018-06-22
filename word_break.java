import java.util.Set;

public class word_break {
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] arrays = new boolean[len+1];
        arrays[0] = true;

        for(int i=1;i<=len;i++){
            for(int j=0;j<i;j++){
                if(arrays[j] && dict.contains(s.substring(j,i))){
                    arrays[i] = true;
                    break;
                }
            }
        }
        return  arrays[len];
    }
}
