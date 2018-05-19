import java.util.Stack;

/**
 * Reverse Polish Notation:逆波兰式，也叫后缀表达式
 */
public class ReversePolishNotation {


    public static void main(){
        ReversePolishNotation test = new ReversePolishNotation();
        String[] tokens = {"0","3","/"};
        System.out.println(test.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<Integer>();
        for(int i= 0 ;i < tokens.length;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                int result = 0;
                String c = tokens[i];
                if(c.equals("+")){
                    result =  num1+num2;
                }
                if(c.equals("-")){
                    result = num1-num2;
                }
                if(c.equals("*")){
                    result = num1*num2;
                }
                if(c.equals("/")){
                    result = num1/num2;
                }
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

}
