/**
 * Created by ATD on 16/09/2016.
 */
public class ShuntingYard {
    private final static String     LEFT_PARENTHESIS = "(",
                                    RIGHT_PARENTHESIS = ")";

    private OperationStack operationStack;
    private TokenList input;
    private TokenList output;
    private int index;

    ShuntingYard(TokenList input) {
        operationStack = new OperationStack();
        this.input = input;
        output = new CharacterList();
        index = 0;
        SYAlgorithm(input);
    }


    private void SYAlgorithm(TokenList input) {
        while (index < input.size()) {
            if (input.get(index).tokenIsDouble()) {
                output.add(input.get(index));
            } else if (input.get(index).tokenIsOperator(input.get(index).getValue())) {
                operationPusher(input);
            } else if (input.get(index).tokenIsParenthesis(input.get(index).getValue())) {
                parenthesisPusher(input);
            }
            index += 1;
        }
        while (operationStack.size() != 0) {
            output.add(operationStack.pop());
        }
    }

    private void operationPusher(TokenList input) {
        while (operationStack.size() != 0 && !operationStack.top().getValue().equals(LEFT_PARENTHESIS) && operationStack.top().getPrecedence() >= input.get(index).getPrecedence()) {
            if (topOfStackIsParenthesis()) {
                operationStack.pop();
            } else {
                output.add(operationStack.pop());
            }
        }
        operationStack.push(input.get(index));
    }

    private void parenthesisPusher(TokenList input) {
        if (input.get(index).getValue().equals(LEFT_PARENTHESIS)) {
            operationStack.push(input.get(index));
        } else if (input.get(index).getValue().equals(RIGHT_PARENTHESIS)) {
            while (operationStack.size() != 0 && !operationStack.top().getValue().equals(LEFT_PARENTHESIS)) {
                output.add(operationStack.pop());
            }
            if (operationStack.size() != 0) {
                operationStack.pop();
            }
        }
    }

    private boolean topOfStackIsParenthesis() {
        return operationStack.top().getValue().equals(LEFT_PARENTHESIS);
    }

    public TokenList getOutput() {
        return output;
    }
}