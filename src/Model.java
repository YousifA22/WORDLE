import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Model {

    private String word;
    private String wordGuessed;

    private int count;

    private boolean win;

    public static int SIZE=5;

    private List<String> words;
    private List<String> wordsGuessed;


    private String[][] buttons;

    public Model(){
        win=false;
        count=0;
        buttons = new String[SIZE][ SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = String.valueOf(' ');
            }
        }
    }



    public boolean winner(){
        if (count==5){
            win=true;
            return win;
        }
        return false;
    }

    public void letterRight(){
        count++;
    }

    public void resetCount(){
        count=0;
    }

    public void setWord(String s){
        word=s.toUpperCase();
        String[] arr= word.split("");
        words=new ArrayList<>();

        for(String c : arr){
            words.add(c);
        }


    }
    public void setGuessedWord(String s){
        wordGuessed=s.toUpperCase();
        String[] arr= wordGuessed.split("");
        wordsGuessed=new ArrayList<>();

        for(String c : arr){
            wordsGuessed.add(c);
        }


    }

    public List<String> getGuessedWord(){
        return wordsGuessed;
    }



    public List<String> getWordArray() {
        return words;
    }



    public void play(){



        for (int i = 0; i < SIZE; i++) {
            if(buttons[i][0].equals(" ")){
                for (int j = 0; j < SIZE; j++) {
                    buttons[i][j]=wordsGuessed.get(j);
                }
                break;
            }

        }

    }



    public List<String> checker(){    //used for modeltest
        List<String> correct = new ArrayList<>();
        play();
        int count=0;

        for (int i = 0; i < SIZE; i++) {
            if(buttons[i][0].equals(wordsGuessed.get(0))){
                for (int j = 0; j < SIZE; j++) {
                    if(buttons[i][j]==wordsGuessed.get(j)) count++;
                    if (words.get(j).equals(wordsGuessed.get(j))){
                        correct.add(wordsGuessed.get(j));
                        correct.add("correct");

                    } else if (words.contains(wordsGuessed.get(j))) {
                        correct.add(wordsGuessed.get(j));
                        correct.add("inside of word");
                    }else{
                        correct.add(wordsGuessed.get(j));
                        correct.add("not in word");
                    }
                }

            }

        }
        return correct;

    }

    public String[][] getBoard(){

        return buttons;
    }


}
