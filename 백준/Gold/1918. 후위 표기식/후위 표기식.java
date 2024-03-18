import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] infix = br.readLine().toCharArray();
        StringBuilder answer = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (char targetChar : infix) {
            if (targetChar >= 'A' && targetChar <= 'Z')
                answer.append(targetChar);
            else {
                if (stack.isEmpty() /*|| stack.peek() == '('*/) {
                    stack.push(targetChar);
                    continue;
                }
                char stackedChar = stack.peek();
                switch (targetChar) {
                    case '(':
                        stack.push(targetChar);
                        break;
                    case '+':
                    case '-':
                        if (stackedChar == '+' || stackedChar == '-') {
                            answer.append(stack.pop());
                        } else if(stackedChar != '(') {
                            answer.append(stack.pop());
                            if (!stack.isEmpty() && stack.peek() != '(') {
                                answer.append(stack.pop());
                            }
                        }
                        stack.push(targetChar);
                        break;
                    case '*':
                    case '/':
                        if (stackedChar == '*' || stackedChar == '/') {
                            answer.append(stack.pop());
                            stack.push(targetChar);
                        } else {
                            stack.push(targetChar);
                        }
                        break;
                    case ')':
                        while (stack.peek() != '(') {
                            answer.append(stack.pop());
                        }
                        stack.pop();
                }
            }
        }
        while (!stack.isEmpty()){
            answer.append(stack.pop());
        }
        System.out.println(answer);
    }
}