package gui.swing.stateController;

import gui.swing.controller.AbstractGeRuMapAction;
import gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class ZoomInStateAction extends AbstractGeRuMapAction {

    public ZoomInStateAction() {
        putValue(SMALL_ICON, loadIcon("/images/ZoomIn.png"));
        putValue(NAME, "Zoom In");
        putValue(SHORT_DESCRIPTION, "Zoom In");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().getMapView().zoomIn();

    }
}
