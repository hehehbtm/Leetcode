import java.util.Stack;

/**
 * Created by admin on 2017/4/6.
 */
// ���ʽ�ĺ������ʽ ������
//    ����ջ
public class RPN {
    public int evalRPN(String[] tokens) {
        String op = "+-/*";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
//            �Ľ��ĵط�  ���Խ� ��ѹջ ���� switch default��
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
