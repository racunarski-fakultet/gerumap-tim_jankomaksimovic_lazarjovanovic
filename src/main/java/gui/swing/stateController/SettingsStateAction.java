package gui.swing.stateController;

import gui.swing.controller.AbstractGeRuMapAction;
import gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class SettingsStateAction extends AbstractGeRuMapAction {

    public SettingsStateAction() {
        putValue(SMALL_ICON, loadIcon("/images/Settings.png"));
        putValue(NAME, "Settings");
        putValue(SHORT_DESCRIPTION, "Settings");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        StateSettings stateSettings = new StateSettings(MainFrame.getInstance(),"Settings", false);
        stateSettings.setVisible(true);
    }
}
