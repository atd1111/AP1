/**
 * Created by ATD on 16/09/2016.
 */
public class ShuntingYard {
    private final static String DOUBLE_SELECTOR = "Double",
                                LEFT_PARENTHESIS = "(",
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
    }

    private void SYAlgorithm(TokenList input) {
        while (index < input.size()) {
            if (input.get(index).getClass().getSimpleName().equals(DOUBLE_SELECTOR)) {
                output.add(input.get(index));
            } else if (input.get(index).tokenIsOperator(input.get(index))) {
                while (operationStack.top().getPrecedence() > input.get(index).getPrecedence()) {
                    output.add(input.get(index));
                }
                operationStack.push(input.get(index));
            } else if (input.get(index).getValue().equals(LEFT_PARENTHESIS)) {
                operationStack.push(input.get(index));
            } else if (input.get(index).getValue().equals(RIGHT_PARENTHESIS)) {
                while (!operationStack.top().getValue().equals(LEFT_PARENTHESIS)) {
                    output.add(operationStack.pop());
                }
                operationStack.pop();
            }
        }
        while (operationStack.size() != 0) {
            output.add(operationStack.pop());
        }
    }
}

