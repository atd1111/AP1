import java.io.PrintStream;
import java.util.Scanner;

public class Main implements CalculatorInterface {

    Scanner in;
    PrintStream out;

    Main() {
        out = System.out;
    }

    public TokenList readTokens(String input) {
        TokenList result = new CharacterList();
        in = new Scanner(input);
        while (in.hasNext()) {
            if (in.hasNextDouble()) {
                result.add(new Character(in.nextDouble()));
            } else {
                result.add(new Character(in.next()));
            }
        }
        in.close();
        return result;
    }

    public Double rpn(TokenList tokens) {
        return new Calculator(tokens).getResult().getDoubleToken();
    }

    public TokenList shuntingYard(TokenList tokens) {
        return new ShuntingYard(tokens).getOutput();
    }

    private void start() {
        //TODO  While there is input, read line and parse it.
        out.println("result: "+rpn(shuntingYard(readTokens("6 * 6 * ( 5 + 3 ) / 8 - 12 / 6 * 4"))));
    }

    public static void main(String[] argv) {
        new Main().start();
    }
}
