/**
 * Created by ATD on 13/09/2016.
 */
public class CharacterList implements TokenList {
    // TODO array list is a no go
    //private ArrayList<Token> tokenList;

    private Token[] tokenArray;

    CharacterList() {
        tokenArray = new Token[0];
    }

    @Override
    public void add(Token token) {
        Token[] tempArray = copyArray(new Token[tokenArray.length + 1],0,tokenArray.length);
        tempArray[tempArray.length - 1] = token;
        tokenArray =  tempArray;
    }

    //TODO this is a mess
    @Override
    public void remove(int index) {
        if (index == tokenArray.length - 1) {
            Token[] tempArray1 = copyArray(new Token[index],0,index);
            tokenArray = tempArray1;
        } else {
            Token[] tempArray1 = copyArray(new Token[index], 0, index);
            /*for (int i = 0; i < tempArray1.length; i++) {
                System.out.println(tempArray1[i].getValue());
            }*/
            Token[] tempArray2 = copyArray(new Token[tokenArray.length - index - 1], index + 1, tokenArray.length);
            Token[] tempArrayResult = new Token[tempArray1.length + tempArray2.length];
            System.arraycopy(tempArray1, 0, tempArrayResult, 0, tempArray1.length);
            System.arraycopy(tempArray2, 0, tempArrayResult, tempArray1.length, tempArray2.length);
            tokenArray = tempArrayResult;
        }
    }

    @Override
    public void set(int index, Token token) {
        tokenArray[index] = token;
    }

    @Override
    public Token get(int index) {
        return tokenArray[index];
    }

    @Override
    public int size() {
        return tokenArray.length;
    }

    private Token[] copyArray(Token[] result, int startOfRange, int endOfRange) {
        int index = 0;
        for (int i = startOfRange; i < endOfRange; i++) {
            result[index] = tokenArray[i];
            index += 1;
        }
        return result;
    }
}
