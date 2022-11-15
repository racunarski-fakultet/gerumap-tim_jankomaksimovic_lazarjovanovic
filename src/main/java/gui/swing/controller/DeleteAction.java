package gui.swing.controller;

import gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class DeleteAction extends AbstractGeRuMapAction {
    public DeleteAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.ALT_MASK));
        //putValue(SMALL_ICON, loadIcon("images/kanta.jpg"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

                @Override
                public void actionPerformed(ActionEvent e) {
                }

}