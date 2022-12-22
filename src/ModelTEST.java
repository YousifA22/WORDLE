import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ModelTEST {

    Model m;

    @Test
    public void getInitialStatus() {
        m = new Model();

        assertEquals(false, m.winner()); //to check if the game starts off with no winner


    }

    @Test
    public void getWordPlacement() {
        m = new Model();

        m.setGuessedWord("MEDAL");

        m.play();



        String[][] board=m.getBoard();

        for(int i=0;i<m.SIZE;i++){
            assertEquals(board[0][i], m.getGuessedWord().get(i)); //to check if the board has placed the guessed word correctly

        }


    }
    @Test
    public void checkWords() {
        m = new Model();

        m.setWord("hello");

        m.setGuessedWord("MEDAL");

        m.play();


        List<String> list= new ArrayList<>(); //to check if a letter is inside of word, in the right place, or not in word at all

        list.add(m.getGuessedWord().get(0));
        list.add("not in word");
        list.add(m.getGuessedWord().get(1));
        list.add("correct");

        list.add(m.getGuessedWord().get(2));
        list.add("not in word");

        list.add(m.getGuessedWord().get(3));
        list.add("not in word");
        list.add(m.getGuessedWord().get(4));
        list.add("inside of word");



        for(int i=0;i<list.size();i++){
            assertEquals(list.get(i), m.checker().get(i));


        }





    }


}
