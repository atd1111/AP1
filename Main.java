import java.io.PrintStream;
import java.util.Scanner;

public class Main implements CalculatorInterface {

    Scanner in;
    PrintStream out;

    Main() {
       initializer();
    }

    private void initializer() {
        out = System.out;
    }


    public TokenList readTokens(String input) {
        CharacterList result = new CharacterList();
        in = new Scanner(input);
        while (in.hasNext()) {
            if (in.hasNextDouble()) {
                result.add(new Character(in.nextDouble()));
            } else {
                result.add(new Character(in.next()));
            }
        }
        for (int i = 0; i < result.size(); i++) {
            out.println(String.valueOf(result.get(i).getPrecedence()));
            //out.println(result.get(i).getValue());
        }
        in.close();
        //Calculator calc = new Calculator(result);
        return result;
    }

    public Double rpn(TokenList tokens) {
        // TODO: Implement this
        return null;
    }

    public TokenList shuntingYard(TokenList tokens) {
        // TODO: Implement this
        return null;
    }

    private void start() {
        // While there is input, read line and parse it.
        readTokens("5 + ( ( 1 + 2 ) * 4 ) - 3");

    }

    public static void main(String[] argv) {
        new Main().start();
    }
}
