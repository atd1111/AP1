import java.util.ArrayList;

/**
 * Created by ATD on 13/09/2016.
 */
public class CharacterList implements TokenList {
    // TODO arraylist is a no go
    private ArrayList<Token> tokenList;
    private Token[] tokenArray;
    private Token[] tempArray;

    CharacterList() {
        tokenList = new ArrayList<>();
        tokenArray = new Token[0];
    }

    @Override
    public void add(Token token) {
        tokenList.add(token);

        tempArray = copyArray(new Token[tokenArray.length + 1]);
        tempArray[tempArray.length - 1] = token;
        tokenArray =  tempArray;
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

    private Token[] copyArray(Token[] result) {
        for (int i = 0; i < tokenArray.length; i++) {
            result[i] = tempArray[i];
        }
        return result;
    }
}
