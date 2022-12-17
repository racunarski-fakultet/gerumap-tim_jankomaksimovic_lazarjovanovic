package gui.swing.state;

import gui.swing.stateController.painterState.ElementPainter;
import gui.swing.stateController.painterState.elements.Component;
import gui.swing.view.MapView;

import java.awt.*;
import java.io.IOException;

public class MoveState extends State{
    private Component cmp;

    @Override
    public void mouseClickedState(int x, int y, MapView mV) throws IOException {
    }
    @Override
    public void mousePressedState(int x, int y, MapView mV) throws IOException {
        for(ElementPainter ep: mV.getPainters()){
            if (ep.elementAt(new Point(x, y))) {
                cmp = (Component) ep.getElement();
            }
        }
    }

    @Override
    public void mouseDragedState(int x, int y, MapView mV) throws IOException {
        cmp.setX(x);
        cmp.setY(y);
        mV.repaint();
    }

    @Override
    public void mouseReleaseState(int x, int y, MapView mV) throws IOException {
        cmp.setPos(x, y);
        mV.repaint();
    }
}
