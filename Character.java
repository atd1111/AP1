/**
 * Created by ATD on 09/09/2016.
 */
public class Character implements Token {
    private static final int    NUMBER_TYPE = 1,
                                OPERATOR_TYPE = 2,
                                PARENTHESIS_TYPE = 3,
                                NO_PRECEDENCE = -1;
    private static final String[] OPERATOR_TOKENS = {"+","-","*","/","^"},
                                  PARENTHESIS_TOKENS = {"(",")"};
    private static final String[][] PRECEDENCE_MATRIX = {{"+","-"},{"*","/"},{"^"},PARENTHESIS_TOKENS};

    private double doubleToken;
    private boolean isDouble;
    private String operatorToken;
    private String parenthesisToken;

    Character(Object token) {
        initializer();
        tokenParser(token);
    }

    private void initializer() {
        doubleToken = 0;
        isDouble = false;
        operatorToken = "";
        parenthesisToken = "";
    }

    private void tokenParser(Object token) {
        if (typeFinder(token) == 1) {
            doubleToken = (double) token;
            isDouble = true;
        } else if (typeFinder(token) == 2) {
            operatorToken = (String) token;
        } else {
            parenthesisToken = (String) token;
        }
    }

    public boolean tokenIsDouble() {
        return isDouble;
    }

    public double getDoubleToken() {
        return doubleToken;
    }

    @Override
    public String getValue() {
        if (doubleToken != 0) {
            return "" + doubleToken;
        } else if (!operatorToken.isEmpty()) {
            return operatorToken;
        } else {
            return parenthesisToken;
        }
    }

    @Override
    public int getType() {
        if (doubleToken != 0) {
            return 1;
        } else if (!operatorToken.isEmpty()) {
            return 2;
        } else {
            return 3;
        }
    }

    @Override
    public int getPrecedence() {
        if (!operatorToken.isEmpty() || !parenthesisToken.isEmpty()) {
            for (int i = 0; i < PRECEDENCE_MATRIX.length; i++) {
                for (int j = 0; j < PRECEDENCE_MATRIX[0].length; j++) {
                    if (PRECEDENCE_MATRIX[i][j].equals(operatorToken) || PRECEDENCE_MATRIX[i][j].equals(parenthesisToken)) {
                        return i;  // the row of the matrix is the precedence order
                    }
                }
            }
        }
        return NO_PRECEDENCE;
    }

    private int typeFinder(Object token) {
        if (token.getClass().getSimpleName().equals("Double")) {
            return NUMBER_TYPE;
        } else if (tokenIsOperator(token)) {
            return OPERATOR_TYPE;
        } else if (tokenIsParenthesis(token)) {
            return PARENTHESIS_TYPE;
        } else {
            return 0;
        }
    }

    public boolean tokenIsOperator(Object token) {
        for (int i = 0; i < OPERATOR_TOKENS.length; i++) {
            if (OPERATOR_TOKENS[i].equals(token)) {
                return true;
            }
        }
        return false;
    }

    public boolean tokenIsParenthesis(Object token) {
        for (int i = 0; i < PARENTHESIS_TOKENS.length; i++) {
            if (PARENTHESIS_TOKENS[i].equals(token.toString())) {
                return true;
            }
        }
        return false;

    }
}
