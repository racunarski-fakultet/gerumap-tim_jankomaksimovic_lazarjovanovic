package gui.swing.view;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {

    public MyMenuBar()
    {
        JMenu fileMenu = new JMenu("File");
        //fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getProjectAction());

        this.add(fileMenu);

        JMenu infoMenu = new JMenu("Info");
        infoMenu.setMnemonic(KeyEvent.VK_I);
        infoMenu.add(MainFrame.getInstance().getActionManager().getInfoAction());


        this.add(infoMenu);

    }
}
