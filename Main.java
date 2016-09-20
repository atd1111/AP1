import java.io.PrintStream;
import java.util.Scanner;

public class Main implements CalculatorInterface {

    ShuntingYard shuntingYard;
    Scanner in;
    PrintStream out;

    Main() {
       initializer();
    }

    private void initializer() {
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
        for (int i = 0; i < result.size(); i++) {
            //out.println(String.valueOf(result.get(i).getPrecedence()));
            //out.printf(result.get(i).getValue());
        }
        in.close();
        //Calculator calc = new Calculator(result);
        shuntingYard = new ShuntingYard(result);
        TokenList rpn = shuntingYard.getOutput();
        for (int i = 0; i < rpn.size(); i++) {
            out.println(rpn.get(i).getValue());
        }
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
        readTokens("9 + 24 / ( 7 - 3 )");

    }

    public static void main(String[] argv) {
        new Main().start();
    }
}
