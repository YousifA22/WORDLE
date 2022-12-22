import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller implements ActionListener {

    Model model;

    View view;


    public Controller(Model m, View v) {

        this.model = m;
        this.view = v;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().length()==5){

                model.setGuessedWord(e.getActionCommand());

                view.update();

            }else{
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f,"Word must be 5 letters long");

            }





    }
}
