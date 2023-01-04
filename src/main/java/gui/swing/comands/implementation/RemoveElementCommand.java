package gui.swing.comands.implementation;

import core.ApplicationFramework;
import gui.swing.comands.AbstractCommand;
import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.composite.MapNodeComposite;
import gui.swing.mapRepository.implementation.Element;
import gui.swing.message.EventType;
import gui.swing.stateController.painterState.ComponentPainter;
import gui.swing.stateController.painterState.ElementPainter;
import gui.swing.view.MainFrame;
import gui.swing.view.MapSelectionModel;
import gui.swing.view.MapView;

import java.util.ArrayList;
import java.util.List;

public class RemoveElementCommand extends AbstractCommand {

    private List<ElementPainter> painters = new ArrayList<>();
    private MapView mV;
    private ElementPainter painter;

    public RemoveElementCommand(MapView mV, ElementPainter painter) {
        this.mV = mV;
        this.painter = painter;
    }

    public RemoveElementCommand(List<ElementPainter> painters, MapView mV) {
        this.painters = painters;
        this.mV = mV;

    }


    @Override
    public void doCommand() {

        if(MainFrame.getInstance().getProjectView().getMapView().getMapSelectionModel().getSelected().isEmpty()){
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.COMPONENT_NOT_SELECTED);
            return;
        }
        if(painters.isEmpty()){
            mV.getMindMap().getPicasos().remove(painter);
            mV.getMindMap().remove(painter.getElement());
        }

            for (ElementPainter p : painters) {
                mV.getMindMap().remove(p.getElement());
                mV.getMapSelectionModel().getSelected().remove(p.getElement());
                mV.getMindMap().getPicasos().remove(p);

            }
        mV.repaint();
    }

    @Override
    public void undoCommand() {
        if(painters.isEmpty()){
            mV.getMindMap().getPicasos().add(painter);
            mV.getMindMap().add(painter.getElement());
        }
        for(ElementPainter p : painters){
            mV.getMindMap().remove(p.getElement());
            mV.getMapSelectionModel().getSelected().add(p.getElement());
            mV.getMindMap().getPicasos().add(p);

        }
        mV.repaint();
    }

    }

