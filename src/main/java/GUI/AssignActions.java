package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignActions extends JFrame implements ActionListener {

    Actions action = new Actions();
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        //all it has to do is assigning actions to buttons
        //if there is new button, new line should be added here
        if(cmd.equals("wybierz plik")) action.openFile();
        if(cmd.equals("oblicz widoczność")) action.calculate();
        if(cmd.equals("export")) action.export();


    }


}
