import java.util.Stack;

/**
 * Created by ATD on 16/09/2016.
 */
public class OperationStack implements TokenStack {
    private Stack<Token> stack;

    OperationStack() {
        stack = new Stack<>();
    }

    @Override
    public void push(Token token) {
        stack.push(token);
    }

    @Override
    public Token pop() {
        return stack.pop();
    }

    @Override
    public Token top() {
        return stack.peek();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
