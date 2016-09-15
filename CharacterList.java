import java.util.ArrayList;

/**
 * Created by ATD on 13/09/2016.
 */
public class CharacterList implements TokenList {

    private ArrayList<Token> tokenList;

    CharacterList() {
        tokenList = new ArrayList<>();
    }

    @Override
    public void add(Token token) {
        tokenList.add(token);
    }

    @Override
    public void remove(int index) {
        tokenList.remove(index);
    }

    @Override
    public void set(int index, Token token) {
        tokenList.set(index,token);
    }

    @Override
    public Token get(int index) {
        return tokenList.get(index);
    }

    @Override
    public int size() {
        return tokenList.size();
    }
}
