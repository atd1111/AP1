import java.util.Stack;

/**
 * Created by ATD on 13/09/2016.
 */
public class Calculator {

    private Stack<Token> stack;
    private CharacterList tokenList;

    Calculator(CharacterList tokenList) {
        stack = new Stack<>();
        this.tokenList = tokenList;
    }

    private void tokenReader() {
        for (int i = 0; i < tokenList.size(); i++) {
            if (tokenList.get(i).getType() == 1) {
                stack.push(tokenList.get(i));
            } else if (tokenList.get(i).getType() == 2) {
                Token firstOperand = stack.pop();
                Token secondOperand = stack.pop();
            }
        }
    }



    private Token calculator(Token firstOperand, Token secondOperand, String operator) {
        Token result;
        double firstOperandDoubleValue;
        double secondOperandDoubleValue;
        switch (operator) {
            case "+":
                firstOperandDoubleValue = firstOperand.getDoubleToken();
                secondOperandDoubleValue = secondOperand.getDoubleToken();
                result = new Character(firstOperandDoubleValue + secondOperandDoubleValue);
                break;
            case "-":
                firstOperandDoubleValue = firstOperand.getDoubleToken();
                secondOperandDoubleValue = secondOperand.getDoubleToken();
                result = new Character(secondOperandDoubleValue - firstOperandDoubleValue);
                break;
            case "*":
                firstOperandDoubleValue = firstOperand.getDoubleToken();
                secondOperandDoubleValue = secondOperand.getDoubleToken();
                result = new Character(firstOperandDoubleValue * secondOperandDoubleValue);
                break;
            case "/":
                firstOperandDoubleValue = firstOperand.getDoubleToken();
                secondOperandDoubleValue = secondOperand.getDoubleToken();
                result = new Character(secondOperandDoubleValue / firstOperandDoubleValue);
                break;
            case "^":
                firstOperandDoubleValue = firstOperand.getDoubleToken();
                for (int i = 0; i < secondOperand.getDoubleToken() - 1; i++) {
                    firstOperandDoubleValue *= firstOperandDoubleValue;
                }
                result = new Character(firstOperandDoubleValue);
                break;
            default:
                System.out.println("ERROR: invalid operation");
                result = new Character(0);
        }

        return result;
    }
}
