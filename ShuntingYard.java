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
        SYAlgorithm(input);
    }

    private void SYAlgorithm(TokenList input) {
        while (index < input.size()) {
            System.out.println("SY considering: "+input.get(index).getValue());
            if (input.get(index).tokenIsDouble()) {
                output.add(input.get(index));

                //System.out.println(input.get(index).getValue()+" added to output");
            } else if (input.get(index).tokenIsOperator(input.get(index).getValue())) {
                System.out.println("operator");
                if (operationStack.size() > 0) {
                    while (operationStack.top().getPrecedence() > input.get(index).getPrecedence()) {
                        output.add(operationStack.pop());
                        System.out.println("top precedence: "+operationStack.top().getPrecedence()+" operator precedence: "+input.get(index).getPrecedence());
                        //System.out.println(input.get(index).getValue()+" added to output");
                    }
                }
                operationStack.push(input.get(index));
            } else if (input.get(index).getValue().equals(LEFT_PARENTHESIS)) {
                System.out.println("left parenthesis");
                operationStack.push(input.get(index));
            } else if (input.get(index).getValue().equals(RIGHT_PARENTHESIS)) {
                System.out.println("right parenthesis");
                if (operationStack.size() > 0) {
                    System.out.println(operationStack.top().getValue()+" :top of operation stack");

                    while (!operationStack.top().getValue().equals(LEFT_PARENTHESIS)) {
                        System.out.println(operationStack.top().getValue()+" adding to output");
                        output.add(operationStack.pop());
                        System.out.println(operationStack.top().getValue()+" new top");
                        //System.out.println(input.get(index).getValue()+" added to output");
                    }
                }
                operationStack.pop();
            }
            index += 1;
        }
        while (operationStack.size() != 0) {
            System.out.println("popped!!");
            output.add(operationStack.pop());
        }
    }

    public TokenList getOutput() {
        return output;
    }
}