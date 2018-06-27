/**
 * 回文的最小分割数
 * 1.dp[i]表示当前i到len-1这段的最小分割数
 * 2.dp[i]=min{dp[j+1]+1}（i=<j<len）其中str[i..j]必须是回文、
 * 3.p[i][j]=true表示str[i..j]是回文
 * 4.p[i][j]=s.charAt(i)==s.charAt(j) && (j-i<2||p[i+1][j-1])
 */

public class palindrome_partitioning_ii {

    public int minCut(String s) {
        int len = s.length();
        int[] dp = new int[len+1];
        boolean[][] p  = new boolean[len][len];
        dp[len] = -1; //保证dp[len-1] = 0

        for(int i=len-1;i>=0;i--){
            dp[i] = Integer.MAX_VALUE;
            for(int j = i;j < len;j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<2||p[i+1][j-1]) ){
                    p[i][j] = true;
                    dp[i] = Math.min(dp[i],dp[j+1]+1);
                }
            }
        }
        return dp[0];
    }

}
