package gui.swing.state;

import gui.swing.stateController.painterState.ConnectPainter;
import gui.swing.stateController.painterState.ElementPainter;
import gui.swing.stateController.painterState.elements.Component;
import gui.swing.view.MapView;

import java.awt.*;
import java.io.IOException;

public class ConnectState extends State{
    ConnectPainter cp;
    @Override
    public void mouseClickedState(int x, int y, MapView mV) throws IOException {


    }

    @Override
    public void mousePressedState(int x, int y, MapView mV) throws IOException {
        for (int i=0; i<mV.getPainters().size(); i++){
            if (mV.getPainters().get(i).elementAt(new Point(x, y))){
                cp = new ConnectPainter();
                cp.setBegining((Component) mV.getPainters().get(i).getElement());
                cp.getBegining().setPos(x,y);
                mV.getPainters().add(cp);
            }
        }
    }

    @Override
    public void mouseDragedState(int x, int y, MapView mV) throws IOException {
        cp.getEnd().setPos(x, y);
        mV.repaint();

    }

    @Override
    public void mouseReleaseState(int x, int y, MapView mV) throws IOException {
        for (ElementPainter ep: mV.getPainters()){
            if (ep.elementAt(new Point(x, y))){
                cp.setEnd((Component) ep.getElement());
                cp.getEnd().setPos(x,y);
            }
        }
        mV.repaint();

    }
}
