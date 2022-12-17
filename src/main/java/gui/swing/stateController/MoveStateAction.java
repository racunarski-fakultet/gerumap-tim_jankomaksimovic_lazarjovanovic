package gui.swing.stateController;

import gui.swing.controller.AbstractGeRuMapAction;
import gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class MoveStateAction extends AbstractGeRuMapAction {

    public MoveStateAction() {
        //putValue(SMALL_ICON, loadIcon("images/delete.jpg"));
        putValue(NAME, "Move");
        putValue(SHORT_DESCRIPTION, "Move");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startMoveState();

    }
}
