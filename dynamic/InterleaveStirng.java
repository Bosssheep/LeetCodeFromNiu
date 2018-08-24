package dynamic;

/**
 * S3由S1和S2交织组成，在s3中s1和s2字符的顺序是不能变化的
 * s1 ="aabcc",
   s2 ="dbbca",
 When s3 ="aadbbcbcac", return true.
 When s3 ="aadbbbaccc", return false.

动态规划：
 dp[i][j]表示s3的前i+j个字符可以由s1的前i个字符和s2的前j个字符交织而成。
 （1）dp[i][j]= (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
 （2）dp[i][j]= (dp[i][j-1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)
 */
public class InterleaveStirng {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if(len1+len2 != len3){
            return false;
        }

        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;

        for(int i=1;i<len1+1;i++){
            dp[i][0] = dp[i-1][0]&&s1.charAt(i-1) == s3.charAt(i-1);
        }
        for(int j=1;j<len2+1;j++){
            dp[0][j] = dp[0][j-1]&&s2.charAt(j-1) == s3.charAt(j-1);
        }

        for(int i=1;i<len1+1;i++){
            for(int j=1;j<len2+1;j++){
                dp[i][j]= (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))|| (dp[i][j-1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[len1][len2];
    }
}
