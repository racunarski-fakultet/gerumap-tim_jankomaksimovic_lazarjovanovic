package gui.swing.state;

import gui.swing.stateController.painterState.ElementPainter;
import gui.swing.view.MapView;

import java.awt.*;
import java.io.IOException;

public class DeleteState extends State{
    @Override
    public void mouseClickedState(int x, int y, MapView mV) throws IOException {
        Point point = new Point(x, y);
        for (int i = 0; i<mV.getPainters().size(); i++){
            ElementPainter p = mV.getPainters().get(i);
            if (p.elementAt(point)==true) {
                mV.getMindMap().remove(p.getElement());
                mV.getPainters().remove(p);
            }
        }
        mV.repaint();
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
