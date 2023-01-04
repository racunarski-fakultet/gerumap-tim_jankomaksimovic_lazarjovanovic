package gui.swing.stateController;

import gui.swing.controller.AbstractGeRuMapAction;
import gui.swing.mapRepository.implementation.Element;
import gui.swing.stateController.painterState.ConnectPainter;
import gui.swing.stateController.painterState.ElementPainter;
import gui.swing.stateController.painterState.elements.Component;
import gui.swing.stateController.painterState.elements.Connection;
import gui.swing.view.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;

public class CentarComponentStateAction extends AbstractGeRuMapAction {
    public CentarComponentStateAction() {
        putValue(SMALL_ICON, loadIcon("/images/CenterComponent.png"));
        putValue(NAME, "Center Component");
        putValue(SHORT_DESCRIPTION, "Center Component");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(MainFrame.getInstance().getProjectView().getMapView().getHeight() + " " +  MainFrame.getInstance().getProjectView().getMapView().getHeight() );

        if (MainFrame.getInstance().getProjectView().getMapView().getMapSelectionModel().getSelected().size() == 1) {

            for (Element central : MainFrame.getInstance().getProjectView().getMapView().getMapSelectionModel().getSelected()) {
                if (!(central instanceof Component)) {
                    return;
                }
                central.setStroke(5);

                int w = MainFrame.getInstance().getProjectView().getMapView().getWidth() / 2;
                int h = MainFrame.getInstance().getProjectView().getMapView().getHeight() / 2;

                w /= 8;
                h /= 8;
                w *= 8;
                h *= 8;
                Component c = (Component) central;
                c.setX(w);
                c.setY(h);

                for (ConnectPainter cP : c.getConnectList()) {
                    Connection con = (Connection) cP.getElement();
                    if (con.getFirstComp().equals(c)) {
                        Point pos1 = new Point(w, h);
                        cP.setPos1(pos1);
                    } else {
                        Point pos2 = new Point(w, h);
                        cP.setPos2(pos2);
                    }
                }

                int hh = 25, ww = 50, pomozimi = 100;
                for(ElementPainter p : MainFrame.getInstance().getProjectView().getMapView().getMindMap().getPicasos()) {
                    if (p.getElement() instanceof Component && !(p.getElement().equals(c))) {
                        Component k = (Component) p.getElement();
                        for (ConnectPainter painter : k.getConnectList()) {
                            Connection con = (Connection) painter.getElement();

                            if(con.getSecondComp().equals(c) || con.getFirstComp().equals(c)){

                                k.setX(ww);
                                k.setY(hh);
                                ww+=pomozimi;

                                for (ConnectPainter slikar : k.getConnectList()) {
                                    Connection linkara = (Connection) slikar.getElement();
                                    if (linkara.getFirstComp().equals(k)) {
                                        Point pos1 = new Point(k.getX(), k.getY());

                                        slikar.setPos1(pos1);
                                    } else {
                                        Point pos2 = new Point(k.getX(), k.getY());
                                        slikar.setPos2(pos2);
                                    }
                                }


                            }

                        }
                    }
                }
            }
        }


        MainFrame.getInstance().getProjectView().getMapView().repaint();
    }
}