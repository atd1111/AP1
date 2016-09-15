/**
 * Created by ATD on 09/09/2016.
 */
public class Character implements Token {

    private static final int    NUMBER_TYPE = 1,
                                OPERATOR_TYPE = 2,
                                PARENTHESIS_TYPE = 3;
    private static final String[] OPERATOR_TOKENS = {"+","-","*","/","^"};
    private static final String[] PARENTHESIS_TOKENS = {"(",")"};

    private int integerToken;
    private double doubleToken;
    private String operatorToken;
    private String parenthesisToken;

    Character(Object token) {
        initializer();
        tokenParser(token);
    }

    private void initializer() {
        integerToken = 0;
        doubleToken = 0;
        operatorToken = "";
        parenthesisToken = "";
    }

    private void tokenParser(Object token) {
        if (typeFinder(token) == 1) {
            if (token.getClass().getSimpleName().equals("Integer")) {
                integerToken = (int) token;
            } else {
                doubleToken = (double) token;
            }
        } else if (typeFinder(token) == 2) {
            operatorToken = (String) token;
        } else {
            parenthesisToken = (String) token;
        }
    }

    public boolean isInt() {
        return integerToken != 0;
    }

    public boolean isDouble() {
        return doubleToken != 0;
    }

    public int getIntegerToken() {
        return integerToken;
    }

    public double getDoubleToken() {
        return doubleToken;
    }

    @Override
    public String getValue() {
        if (integerToken != 0) {
            return "" + integerToken;
        } else if (doubleToken != 0) {
            return "" + doubleToken;
        } else if (!operatorToken.isEmpty()) {
            return operatorToken;
        } else {
            return parenthesisToken;
        }
    }

    @Override
    public int getType() {
        if (integerToken != 0 || doubleToken != 0) {
            return 1;
        } else if (!operatorToken.isEmpty()) {
            return 2;
        } else {
            return 3;
        }
    }

    @Override
    public int getPrecedence() {
        return 0;
    }

    /*public boolean isToken() {
        if (typeFinder() == NUMBER_TYPE || typeFinder() == OPERATOR_TYPE || typeFinder() == PARENTHESIS_TYPE) {
            return true;
        } else {
            return false;
        }
    }*/

    /*public Object getToken() {
        return token;
    }*/

    /*public String gitGud() {
        return "gitgud";
    }*/

    private int typeFinder(Object token) {
        //System.out.println("token type is: "+token.getClass().getSimpleName());
        if (token.getClass().getSimpleName().equals("Integer") || token.getClass().getSimpleName().equals("Double")) {
            return NUMBER_TYPE;
        } else if (tokenIsOperator(token)) {
            return OPERATOR_TYPE;
        } else if (tokenIsParenthesis(token)) {
            return PARENTHESIS_TYPE;
        } else {
            return 0;
        }
    }

    private boolean tokenIsOperator(Object token) {
        for (int i = 0; i < OPERATOR_TOKENS.length; i++) {
            if (OPERATOR_TOKENS[i].equals(token)) {
                return true;
            }
        }
        return false;
    }

    private boolean tokenIsParenthesis(Object token) {
        for (int i = 0; i < PARENTHESIS_TOKENS.length; i++) {
            if (PARENTHESIS_TOKENS[i].equals(token)) {
                return true;
            }
        }
        return false;
    }
}
