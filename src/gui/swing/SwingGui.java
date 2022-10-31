package gui.swing;

import core.Gui;
import gui.swing.view.MainFrame;

public class SwingGui implements Gui {

    private MainFrame instance;

    @Override
    public void start() {
        instance = MainFrame.getInstance();
        instance.setVisible(true);
    }
}
