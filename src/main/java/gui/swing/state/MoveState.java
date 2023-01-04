package gui.swing.state;

import core.ApplicationFramework;
import gui.swing.comands.AbstractCommand;
import gui.swing.comands.implementation.MoveCommand;
import gui.swing.message.EventType;
import gui.swing.stateController.painterState.ConnectPainter;
import gui.swing.stateController.painterState.ElementPainter;
import gui.swing.stateController.painterState.elements.Component;
import gui.swing.stateController.painterState.elements.Connection;
import gui.swing.view.MapView;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoveState extends State{
    private Component component;
    private AbstractCommand moveC;
    int flag = 0;
    int x1, y1;
    int xPrim, yPrim;
    private List<ElementPainter> painters = new ArrayList<ElementPainter>();

    @Override
    public void mouseClickedState(int x, int y, MapView mV) throws IOException {

    }

    @Override
    public void mousePressedState(int x, int y, MapView mV) {
        painters.clear();
        Point point = new Point(x, y);
        for (ElementPainter p : mV.getMindMap().getPicasos()) {
            if (p.getElement() instanceof Component) {
                Component c = (Component) p.getElement();
                if (mV.getMapSelectionModel().getSelected().contains(c)) {
                    if (p.elementAt(point)) {
                        x1 = x;
                        y1 = y;
                        xPrim = x;
                        yPrim = y;
                        flag = 1;
                        break;
                    } else {
                        flag = 0;
                    }
                }
            }
        }
    }




    @Override
    public void mouseDragedState(int x, int y, MapView mV) {
        if (flag == 1) {
            for(ElementPainter p : mV.getMindMap().getPicasos()){
                if(p.getElement() instanceof Component){
                    Component c = (Component) p.getElement();
                    if (mV.getMapSelectionModel().getSelected().contains(c)) {
                        if(!painters.contains(p))
                            painters.add(p);
                        c.setX(c.getX() - (xPrim - x));
                        c.setY(c.getY() - (yPrim - y));
                        for(ConnectPainter painter : c.getConnectList()){
                            Connection con = (Connection) painter.getElement();
                            if(con.getFirstComp().equals(c)){
                                Point pos1 = new Point(painter.getPos1().x - (xPrim - x), painter.getPos1().y - (yPrim - y));
                                painter.setPos1(pos1);
                            }else{
                                Point pos2 = new Point(painter.getPos2().x - (xPrim - x), painter.getPos2().y - (yPrim - y));
                                painter.setPos2(pos2);
                            }
                        }
                    }
                }
                mV.repaint();
            }
            xPrim -= xPrim - x;
            yPrim -= yPrim - y;
        }
    }


    @Override
    public void mouseReleaseState(int x, int y, MapView mV) throws IOException {
        if(flag == 1) {
            AbstractCommand command = new MoveCommand( x, x1, y, y1, mV, painters);
            ApplicationFramework.getInstance().getGuiInterface().getCommandManager().addCommand(command);
        }
    }
}

    /*private Component cmp;

    @Override
    public void mouseClickedState(int x, int y, MapView mV) throws IOException {
    }
    @Override
    public void mousePressedState(int x, int y, MapView mV) throws IOException {
        for(ElementPainter ep: mV.getMindMap().getPicasos()){
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
*/
