package gui.swing.stateController;

import gui.swing.controller.AbstractGeRuMapAction;
import gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class ZoomOutStateAction extends AbstractGeRuMapAction {
    public ZoomOutStateAction() {
        //putValue(SMALL_ICON, loadIcon("images/delete.jpg"));
        putValue(NAME, "Zoom Out");
        putValue(SHORT_DESCRIPTION, "ZoomOut");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().getMapView().zoomOut();

    }
}
