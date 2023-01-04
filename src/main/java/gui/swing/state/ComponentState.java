package gui.swing.state;

import core.ApplicationFramework;
import gui.swing.comands.implementation.AddComponentCommand;
import gui.swing.stateController.painterState.ComponentPainter;
import gui.swing.stateController.painterState.ElementPainter;
import gui.swing.stateController.painterState.elements.Component;
import gui.swing.view.MapView;

import java.awt.*;
import java.io.IOException;

public class ComponentState extends State{
    @Override
    public void mouseClickedState(int x, int y, MapView mV) throws IOException {

    }

    @Override
    public void mousePressedState(int x, int y, MapView mV) throws IOException {


        Component component = new Component("Concept" + mV.getMindMap().getChildren().size(), mV.getMindMap(), Color.BLACK, 2, x, y);
        ComponentPainter cP = new ComponentPainter(component);
        //mV.getMindMap().getPicasos().add(cP);
        //mV.getMindMap().add(component);
        mV.getMindMap().notifySubscribers(mV);
        AddComponentCommand aDC = new AddComponentCommand(mV, cP);
        ApplicationFramework.getInstance().getGuiInterface().getCommandManager().addCommand(aDC);
        mV.repaint();
    }

    @Override
    public void mouseDragedState(int x, int y, MapView mV) throws IOException {

    }

    @Override
    public void mouseReleaseState(int x, int y, MapView mV) throws IOException {

    }
}
