package gui.swing.state;

import core.ApplicationFramework;
import gui.swing.comands.AbstractCommand;
import gui.swing.comands.implementation.AddConnectCommand;
import gui.swing.stateController.painterState.ConnectPainter;
import gui.swing.stateController.painterState.ElementPainter;
import gui.swing.stateController.painterState.elements.Component;
import gui.swing.view.MapView;
import gui.swing.stateController.painterState.elements.Connection;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConnectState extends State{
    Component c1;
    Component c2;
    private ConnectPainter connectPainter;
    private Connection connection;
    List<ElementPainter> newEP = new ArrayList<ElementPainter>();
    private Point pos1;
    private Point pos2;
    @Override
    public void mouseClickedState(int x, int y, MapView mV) throws IOException {


    }

    @Override
    public void mousePressedState(int x, int y, MapView mV) throws IOException {
        pos1 = new Point(x, y);
        pos2 = new Point(x, y);
        c1 = null;
        c2 = null;
        newEP.clear();

        for(ElementPainter p : mV.getMindMap().getPicasos()){
            if(p.elementAt(pos1)){
                c1 = (Component) p.getElement();
                c2 = (Component) p.getElement();

                connection = new Connection("Link + " + mV.getMindMap().getChildren().size(), c1.getParent(), Color.BLACK, 2, c1, c2);
                pos1 = new Point(c1.getX(), c1.getY());
                connectPainter = new ConnectPainter(connection, pos1, pos2);
                newEP.add(connectPainter);
            }
        }

        for(ElementPainter n : newEP){
            mV.getMindMap().getPicasos().add(n);
        }
    }


    @Override
    public void mouseDragedState(int x, int y, MapView mV) throws IOException {
        pos2.setLocation(x, y);
        mV.repaint();

    }

    @Override
    public void mouseReleaseState(int x, int y, MapView mV) throws IOException {
        if(c1 == null || c2 == null){
            return;
        }
        pos2.setLocation(x, y);


        for(ElementPainter p : mV.getMindMap().getPicasos()){
            if(p.elementAt(pos2) && p.getElement() instanceof Component){
                Component comp = (Component)p.getElement();
                pos2 = new Point(comp.getX(), comp.getY());
                connectPainter.setPos2(pos2);

                c2 = (Component) p.getElement();
                //pos2 = new Point(c2.getX(), c2.getY());
                connection.setSecondComp(c2);
                pos2 = new Point(c2.getX(), c2.getY());
                break;
            }
        }

        if(c1.equals(c2)){
            mV.getMindMap().getPicasos().remove(connectPainter);
            mV.update(this);
            return;
        }

        for(ConnectPainter painter : c1.getConnectList()){
            Connection c1 = (Connection) painter.getElement();
            if(c1.equals(connection)){
                mV.getMindMap().getPicasos().remove(connectPainter);
                mV.update(this);
                return;
            }
        }

        for(ConnectPainter painter : c2.getConnectList()){
            Connection c1 = (Connection) painter.getElement();
            //pos2 = new Point(c2.getX(), c2.getY());
            if(c1.equals(connection)){
                mV.getMindMap().getPicasos().remove(connectPainter);
                mV.update(this);
                return;
            }
        }

        AbstractCommand command = new AddConnectCommand(c1, c2, mV, connectPainter, connection);
        ApplicationFramework.getInstance().getGuiInterface().getCommandManager().addCommand(command);
        mV.repaint();

    }
}
