package gui.swing.comands.implementation;

import gui.swing.comands.AbstractCommand;
import gui.swing.stateController.painterState.ConnectPainter;
import gui.swing.stateController.painterState.ElementPainter;
import gui.swing.stateController.painterState.elements.Component;
import gui.swing.stateController.painterState.elements.Connection;
import gui.swing.view.MapView;

public class AddConnectCommand extends AbstractCommand {

    private Component comp1;
    private Component comp2;
    private MapView mV;
    private ElementPainter eP;
    private Connection connection;


    public AddConnectCommand(Component comp1, Component comp2, MapView mV, ElementPainter eP, Connection connection) {
        this.comp1 = comp1;
        this.comp2 = comp2;
        this.mV = mV;
        this.eP = eP;
        this.connection = connection;
    }

    @Override
    public void doCommand() {
        comp1.getConnectList().add((ConnectPainter) eP);
        comp2.getConnectList().add((ConnectPainter) eP);
        mV.getMindMap().add(connection);
        if(!mV.getMindMap().getPicasos().contains(eP)){
            mV.getMindMap().getPicasos().add(eP);
        }
        mV.repaint();
    }

    @Override
    public void undoCommand() {
        comp1.getConnectList().remove((ConnectPainter) eP);
        comp2.getConnectList().remove((ConnectPainter) eP);
        mV.getMindMap().remove(connection);
        mV.getMindMap().getPicasos().remove(eP);
        mV.repaint();
    }


}
