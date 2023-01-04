package gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ExitAction extends AbstractGeRuMapAction{

    public ExitAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_ESCAPE, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON,loadIcon("/images/logout.png"));
        putValue(NAME, "Exit");
        putValue(SHORT_DESCRIPTION, "Exit");
    }

    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
