package gui.swing.state;

import gui.swing.stateController.painterState.ElementPainter;
import gui.swing.view.MapView;

import java.awt.*;
import java.io.IOException;

public class SelectState extends State{
    @Override
    public void mouseClickedState(int x, int y, MapView mV) throws IOException {
        for (ElementPainter ep: mV.getPainters()){
            if (ep.elementAt(new Point(x, y))){
                mV.getMapSelectionModel().getSelected().add(ep.getElement());
                ep.getElement().setColor(Color.MAGENTA);
                mV.repaint();
            }
        }
    }

    @Override
    public void mousePressedState(int x, int y, MapView mV) throws IOException {

    }

    @Override
    public void mouseDragedState(int x, int y, MapView mV) throws IOException {

    }

    @Override
    public void mouseReleaseState(int x, int y, MapView mV) throws IOException {

    }
}
