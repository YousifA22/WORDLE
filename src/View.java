
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class View extends JFrame{
    private JButton[][] buttons;

    private Model model;

    private int count;

    private Controller controller;

    private String word;

    private JTextField guess;



    private List<String> words;

    private JPanel buttonPanel;
    private JPanel wordPanel;

    public List<JButton> list;






    public View(){

    super("WORDLE!");
    count=0;

    buttonPanel=new JPanel();
    wordPanel=new JPanel();
    guess=new JTextField();
    list = new ArrayList<>();



    model=new Model();
    controller=new Controller(model,this);



    while(true){   //to deal with inputs higher of lower than 5
        word=  JOptionPane.showInputDialog("Please enter the five letter word to be guessed");
        if(word.length()==5){
            break;
        }
    }











    buttonPanel.setLayout(new GridLayout(Model.SIZE, Model.SIZE));
    wordPanel.setLayout(new BorderLayout());








    wordPanel.add(guess);














    buttons = new JButton[Model.SIZE][Model.SIZE];

    for (int i = 0; i < Model.SIZE; i++){
        for (int j = 0; j < Model.SIZE; j++){
            JButton b = new JButton(" ");
            buttons[i][j] = b;
            buttons[i][j].setEnabled(false);
            list.add(buttons[i][j]);




        }
        }
        for(JButton x5:list){
            buttonPanel.add(x5);
        }



        guess.addActionListener(controller);

        model.setWord(String.valueOf(word));

        words=model.getWordArray();
        buttonPanel.setOpaque(true);
        buttonPanel.setBackground(Color.GRAY);

        this.add(buttonPanel, BorderLayout.CENTER);
        this.add(wordPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(100, 100);
        this.setPreferredSize(new Dimension(500, 400));
        this.setResizable(true);
        this.setVisible(true);
        pack();

    }

    public void update(){


        model.play();

        List<String> wordGuessed = model.getGuessedWord();

        String board[][] = model.getBoard();

        for (int i = 0; i < Model.SIZE; i++){
            if(board[i][0].equals(wordGuessed.get(0)) && count==i) {


                for (int j = 0; j < Model.SIZE; j++) {


                    buttons[i][j].setText(board[i][j]);
                    if (words.get(j).equals(wordGuessed.get(j))) {
                        buttons[i][j].setBackground(Color.GREEN);
                        model.letterRight();
                    } else if (words.contains(wordGuessed.get(j))) {
                        buttons[i][j].setBackground(Color.YELLOW);
                    }else{
                        buttons[i][j].setBackground(Color.GRAY);
                    }

                    if (model.winner()) {
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f,"Congrats you won!");
                        guess.setEnabled(false);

                    }


                }

            }
            model.resetCount();

        }
        count++;


        guess.setText("");
        if(!board[4][4].equals(" ")&& !model.winner()){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f,"Loser!");
            guess.setEnabled(false);
        }


    }

    public static void main(String[] args) {
        View v= new View();
    }



}
