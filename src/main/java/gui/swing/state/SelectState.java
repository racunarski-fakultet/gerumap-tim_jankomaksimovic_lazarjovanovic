package gui.swing.state;

import gui.swing.mapRepository.implementation.Element;
import gui.swing.stateController.painterState.ElementPainter;
import gui.swing.stateController.painterState.MultiSelectionPainter;
import gui.swing.view.MapView;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectState extends State{

    private MultiSelectionPainter msp = new MultiSelectionPainter();
    private int x1, y1;
    private List<ElementPainter> newList = new ArrayList<ElementPainter>();
    @Override
    public void mouseClickedState(int x, int y, MapView mV) throws IOException {

    }


    @Override
    public void mousePressedState(int x, int y, MapView mV) throws IOException {
        if(!(mV.getMapSelectionModel().getSelected().isEmpty())) {

            mV.getMapSelectionModel().clearList();
        }

        newList.clear();

        for(ElementPainter p : mV.getMindMap().getPicasos()){
            Point pos = new Point(x, y);
            if(p.elementAt(pos)){
                mV.getMapSelectionModel().addElement(p.getElement());
            }
            else{
                x1 = x;
                y1 = y;
                newList.add(msp);
            }
        }
        if(!newList.isEmpty()) {
            for (ElementPainter eP : newList) {
                mV.getMindMap().getPicasos().add(eP);
            }
        }

    }

    @Override
    public void mouseDragedState(int x, int y, MapView mV) throws IOException {
        if(!(mV.getMapSelectionModel().getSelected().isEmpty())) {
            mV.getMapSelectionModel().clearList();
        }

        msp.updatePoints(x1, y1, x, y);
        mV.update(msp);

        for(ElementPainter p : mV.getMindMap().getPicasos()){
            if(p instanceof MultiSelectionPainter)
                continue;
            if(msp.getShape() == null){
                mV.getMindMap().getPicasos().remove(msp);
                return;
            }
            if(msp.getShape().intersects(p.getS().getBounds().getX(), p.getS().getBounds().getY(), p.getS().getBounds().getWidth(), p.getS().getBounds().getHeight())){
                mV.getMapSelectionModel().addElement(p.getElement());
            }
        }
    }

    @Override
    public void mouseReleaseState(int x, int y, MapView mV) throws IOException {
        for (ElementPainter n : newList) {
            mV.getMindMap().getPicasos().remove(n);
            msp = new MultiSelectionPainter();
        }
        mV.update(this);
    }
}
