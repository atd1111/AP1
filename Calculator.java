import java.io.PrintStream;
/**
 * Created by ATD on 13/09/2016.
 */
public class Calculator {
    private static final int    NUMBER_TYPE = 1,
                                OPERATOR_TYPE = 2;

    private static final String PLUS = "+",
                                MINUS = "-",
                                PRODUCT = "*",
                                DIVISION = "/",
                                EXPONENT = "^";

    private OperandStack stack;
    private TokenList tokenList;
    private PrintStream out;

    Calculator(TokenList tokenList) {
        stack = new OperandStack();
        this.tokenList = tokenList;
        out = System.out;
        tokenReader();
    }

    private void tokenReader() {
        for (int i = 0; i < tokenList.size(); i++) {
            if (tokenList.get(i).getType() == NUMBER_TYPE) {
                stack.push(tokenList.get(i).getDoubleToken());
            } else if (tokenList.get(i).getType() == OPERATOR_TYPE) {
                Double firstOperand = stack.pop();
                Double secondOperand = stack.pop();
                Double result = calculator(firstOperand,secondOperand,tokenList.get(i).getValue());
                stack.push(result);
            }
        }
    }

    Double calculator(Double firstOperand, Double secondOperand, String operator) {
        Double result = 0.0;
        switch (operator) {
            case PLUS:
                result = firstOperand + secondOperand;
                break;
            case MINUS:
                result = secondOperand - firstOperand;
                break;
            case PRODUCT:
                result = firstOperand * secondOperand;
                break;
            case DIVISION:
                if (firstOperand == 0) {
                    out.println("Invalid operation, cannot divide by 0");
                    System.exit(0);
                } else {
                    result = secondOperand / firstOperand;
                }
                break;
            case EXPONENT:
                Double ans = 1.0;
                if (firstOperand != 0) {
                    Double absExponent = firstOperand > 0 ? firstOperand : (-1) * firstOperand;
                    for (int i = 1; i <= absExponent; i++) {
                        ans *= secondOperand; // second operand
                    }
                    if (firstOperand < 0) {
                        ans = 1.0 / ans;
                    }
                } else {
                    // exponent is 0
                    ans = 1.0;
                }
                result = ans;
                break;
            default:
                out.println("ERROR: invalid operation");
                System.exit(0);
        }
        return result;
    }

    public Double getResult() {
        return stack.top();
    }
}
