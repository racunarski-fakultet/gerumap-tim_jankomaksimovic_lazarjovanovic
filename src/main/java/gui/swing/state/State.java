package gui.swing.state;

import gui.swing.view.MapView;

import java.io.IOException;

public abstract class State {

    public abstract void mouseClickedState(int x, int y, MapView mV) throws IOException;
    public abstract void mousePressedState(int x, int y, MapView mV) throws IOException;
    public abstract void mouseDragedState(int x, int y, MapView mV) throws IOException;
    public abstract void mouseReleaseState(int x, int y, MapView mV) throws IOException;


}
