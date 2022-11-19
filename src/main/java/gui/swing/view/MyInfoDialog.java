package gui.swing.view;


import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.IOException;

public class MyInfoDialog extends JDialog {
    public MyInfoDialog(Frame owner, String title) throws IOException {
        super(owner, title);


        setSize(420,250);
        setLocationRelativeTo(owner);

        initialise();

    }

    private void initialise() throws IOException{

        JPanel mainPanel = new JPanel(new GridLayout(1,2));
        JPanel leftGPanel = new JPanel();
        JPanel rightGPanel = new JPanel();

        mainPanel.setBorder(new TitledBorder(new EtchedBorder(),"Info"));
        leftGPanel.setBorder(new TitledBorder(new EtchedBorder()));
        rightGPanel.setBorder(new TitledBorder(new EtchedBorder()));

        Box lbox = Box.createVerticalBox();
        Box rbox = Box.createVerticalBox();

        lbox.add(new JLabel(new ImageIcon()));
        lbox.add(Box.createVerticalStrut(25));
        lbox.add(new JLabel("Janko Maksimović 112/22 RN"));

        rbox.add(new JLabel(new ImageIcon()));
        rbox.add(Box.createVerticalStrut(25));
        rbox.add(new JLabel("Lazar Jovanović 146/22 RN"));

        leftGPanel.add(lbox);
        rightGPanel.add(rbox);

        mainPanel.add(leftGPanel);
        mainPanel.add(rightGPanel);

        add(mainPanel);
        setVisible(true);
    }
}
