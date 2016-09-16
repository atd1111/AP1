import java.util.Stack;

/**
 * Created by ATD on 16/09/2016.
 */
public class OperandStack implements DoubleStack {
    private Stack<Double> stack;

    OperandStack() {
        stack = new Stack<>();
    }

    @Override
    public void push(Double element) {
        stack.push(element);
    }

    @Override
    public Double pop() {
        return stack.pop();
    }

    @Override
    public Double top() {
        return stack.peek();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
