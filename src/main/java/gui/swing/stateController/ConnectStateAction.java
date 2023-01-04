package gui.swing.stateController;

import gui.swing.controller.AbstractGeRuMapAction;
import gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class ConnectStateAction extends AbstractGeRuMapAction {

    public ConnectStateAction() {
        putValue(SMALL_ICON, loadIcon("/images/Connect.png"));
        putValue(NAME, "Connect");
        putValue(SHORT_DESCRIPTION, "Connect");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startConnectState();

    }
}
