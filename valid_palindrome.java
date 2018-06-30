/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 "A man, a plan, a canal: Panama"is a palindrome.
 "race a car"is not a palindrome.
  we define empty string as valid palindrome.
 */
public class valid_palindrome {
    public static boolean isPalindrome(String s) {
        if(s.isEmpty())
            return true;

        if(s.length()==1)
            return true;

        int left = 0;
        int right = s.length()-1;

        while(left < right){
            char leftchar = s.charAt(left);
            char rightchar = s.charAt(right);
            while( left < right && !Character.isLetterOrDigit(leftchar)){
                leftchar = s.charAt(++left);
            }
            while( left < right && !Character.isLetterOrDigit(rightchar)){
                rightchar = s.charAt(--right);
            }
            if(left==right){
                return true;
            }

            leftchar = Character.toLowerCase(leftchar);
            rightchar = Character.toLowerCase(rightchar);
            if(leftchar!=rightchar)
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String args[]){
        String str  = "ab2a";
        boolean res = isPalindrome(str);
        System.out.print(res);
    }
}
