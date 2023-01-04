package gui.swing.controller;

import core.ApplicationFramework;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RedoAction extends AbstractGeRuMapAction{
    public RedoAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/Redo.png"));
        putValue(NAME, "Redo");
        putValue(SHORT_DESCRIPTION, "Redo");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ApplicationFramework.getInstance().getGuiInterface().getCommandManager().doCommand();
    }
}
