package gui.swing.stateController;

import gui.swing.controller.AbstractGeRuMapAction;
import gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class DeleteStateAction extends AbstractGeRuMapAction {

    public DeleteStateAction() {
        //putValue(SMALL_ICON, loadIcon("images/delete.jpg"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startDeleteState();

    }
}
