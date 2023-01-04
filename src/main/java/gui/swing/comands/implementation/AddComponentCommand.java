package gui.swing.comands.implementation;

import gui.swing.comands.AbstractCommand;
import gui.swing.stateController.painterState.ElementPainter;
import gui.swing.stateController.painterState.elements.Component;
import gui.swing.view.MapView;

public class AddComponentCommand extends AbstractCommand {

    private MapView mV;
    private ElementPainter eP;

    public AddComponentCommand(MapView mV, ElementPainter eP) {
        this.mV = mV;
        this.eP = eP;
    }

    @Override
    public void doCommand() {
        if(mV == null || eP == null)
            return;

        Component component = (Component) eP.getElement();
        mV.getMindMap().getPicasos().add(eP);
        mV.getMindMap().add(component);
        mV.repaint();

    }

    @Override
    public void undoCommand() {
        if(mV == null || eP == null)
            return;

        Component component = (Component) eP.getElement();
        mV.getMindMap().getPicasos().remove(eP);
        mV.getMindMap().remove(component);
        mV.repaint();
    }
}
