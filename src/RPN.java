import java.util.Stack;

/**
 * Created by admin on 2017/4/6.
 */
// 表达式的后续表达式 计算结果
//    利用栈
public class RPN {
    public int evalRPN(String[] tokens) {
        String op = "+-/*";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
//            改进的地方  可以将 数压栈 放入 switch default中
            if (!op.contains(tokens[i])){
                stack.push(Integer.valueOf(tokens[i]));
            }else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (tokens[i]){
                    case "+":
                        stack.push(num1+num2);
                        break;
                    case "-":
                        stack.push(num2-num1);
                        break;
                    case "*":
                        stack.push(num1*num2);
                        break;
                    case "/":
                        stack.push(num2/num1);
                        break;
                }
            }
        }
        return stack.peek();
    }
}
