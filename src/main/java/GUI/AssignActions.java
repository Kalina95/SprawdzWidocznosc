package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignActions extends JFrame implements ActionListener {

    Actions action = new Actions();
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if(cmd.equals("wybierz plik")) action.openFile();
        if(cmd.equals("oblicz widoczność")) System.out.println("oblicz widocznosc");
        if(cmd.equals("export")) System.out.println("export");


    }


}
