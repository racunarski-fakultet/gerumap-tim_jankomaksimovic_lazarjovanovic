package gui.swing.stateController;

import core.ApplicationFramework;
import gui.swing.comands.AbstractCommand;
import gui.swing.comands.implementation.RemoveElementCommand;
import gui.swing.controller.AbstractGeRuMapAction;
import gui.swing.mapRepository.implementation.Element;
import gui.swing.mapRepository.implementation.MindMap;
import gui.swing.stateController.painterState.ConnectPainter;
import gui.swing.stateController.painterState.ElementPainter;
import gui.swing.stateController.painterState.elements.Component;
import gui.swing.view.MainFrame;
import gui.swing.view.MapView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class DeleteStateAction extends AbstractGeRuMapAction {

    public DeleteStateAction() {
        putValue(SMALL_ICON, loadIcon("/images/deleteState.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        List<ElementPainter> newL = new ArrayList<>();

        MapView mV = MainFrame.getInstance().getProjectView().getMapView();
        for (ElementPainter p : mV.getMindMap().getPicasos()) {
            for (Element el : mV.getMapSelectionModel().getSelected()) {
                if (p.getElement().equals(el)) {
                    if (p.getElement() instanceof Component) {
                        Component c = (Component) p.getElement();


                        for (ConnectPainter painter : c.getConnectList()) {
                            newL.add(painter);
                        }
                    }
                    newL.add(p);
                }
            }
        }
        AbstractCommand command = new RemoveElementCommand(newL, mV);
        ApplicationFramework.getInstance().getGuiInterface().getCommandManager().addCommand(command);

    }
}
