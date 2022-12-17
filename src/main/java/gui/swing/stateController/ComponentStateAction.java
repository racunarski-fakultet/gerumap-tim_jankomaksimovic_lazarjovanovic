package gui.swing.stateController;

import gui.swing.controller.AbstractGeRuMapAction;
import gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ComponentStateAction extends AbstractGeRuMapAction {
    public ComponentStateAction() {
        //putValue(SMALL_ICON, loadIcon("images/delete.jpg"));
        putValue(NAME, "New Component");
        putValue(SHORT_DESCRIPTION, "New Component");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startComponentState();

    }
}
