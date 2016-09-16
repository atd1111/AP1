interface CalculatorInterface {

    /*
     * @param in String of token to be parsed
     * @return the list of arithmetic token from the String input
     */
    TokenList readTokens(String input);

    /*
     * @param token A list of token signifying an RPN expression.
     * @return The result of the RPN expression.
     */
    Double rpn(TokenList tokens);

    /*
     * @param token A list of token signifying an arithmetic expression.
     * @return The arithmetic expression token converted into
     * Reverse-Polish-Notation.
     */
    TokenList shuntingYard(TokenList tokens);
}
