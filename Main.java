import java.io.PrintStream;
import java.util.Scanner;

public class Main implements CalculatorInterface {

    private Scanner in;
    private PrintStream out;

    Main() {
        out = System.out;
        in = new Scanner(System.in);
    }

    public TokenList readTokens(String input) {
        TokenList result = new CharacterList();
        Scanner tokenScanner = new Scanner(input);
        while (tokenScanner.hasNext()) {
            if (tokenScanner.hasNextDouble()) {
                result.add(new Character(tokenScanner.nextDouble()));
            } else {
                result.add(new Character(tokenScanner.next()));
            }
        }
        tokenScanner.close();
        return result;
    }

    public Double rpn(TokenList tokens) {
        return new Calculator(tokens).getResult();
    }

    public TokenList shuntingYard(TokenList tokens) {
        return new ShuntingYard(tokens).getOutput();
    }

    private void start() {
        while (in.hasNextLine()) {
            // TODO %f (?) something for precision stuff
            out.println("Result: "+rpn(shuntingYard(readTokens(in.nextLine()))));
        }
        in.close();
    }

    public static void main(String[] argv) {
        new Main().start();
    }
}
