package gui.swing.comands.implementation;

import gui.swing.comands.AbstractCommand;
import gui.swing.stateController.painterState.ConnectPainter;
import gui.swing.stateController.painterState.ElementPainter;
import gui.swing.stateController.painterState.elements.Component;
import gui.swing.stateController.painterState.elements.Connection;
import gui.swing.view.MapView;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.List;

@Setter
@Getter
public class MoveCommand extends AbstractCommand {
    private int Xprim;
    private int newX;
    private int Yprim;
    private int newY;
    private Component component;
    private MapView mV;
    private List<ElementPainter> painters;
    private int flag = 0;

    public MoveCommand(int xprim, int newX, int yprim, int newY, MapView mV, List<ElementPainter> painters) {
        Xprim = xprim;
        this.newX = newX;
        Yprim = yprim;
        this.newY = newY;
        this.mV = mV;
        this.painters = painters;
    }

    @Override
    public void doCommand() {
        if (flag > 0) {
            for (ElementPainter p : mV.getMindMap().getPicasos()) {
                if (p.getElement() instanceof Component) {
                    Component t = (Component) p.getElement();
                    if (painters.contains(p)) {
                        t.setX(t.getX() - (Xprim - newX));
                        t.setY(t.getY() - (Yprim - newY));
                        for (ConnectPainter painter : t.getConnectList()) {
                            Connection con = (Connection) painter.getElement();
                            if (con.getFirstComp().equals(t)) {
                                Point pos1 = new Point(painter.getPos1().x - (Xprim - newX), painter.getPos1().y - (Yprim - newY));
                                painter.setPos1(pos1);
                            } else {
                                Point pos2 = new Point(painter.getPos2().x - (Xprim - newX), painter.getPos2().y - (Yprim - newY));
                                painter.setPos2(pos2);
                            }
                        }
                    }
                }
            }
        }
        flag++;

        mV.repaint();

    }



    @Override
    public void undoCommand() {
        for (ElementPainter p : mV.getMindMap().getPicasos()) {
            if (p.getElement() instanceof Component) {
                Component t = (Component) p.getElement();
                if (painters.contains(p)) {
                    t.setX(t.getX() + (Xprim - newX));
                    t.setY(t.getY() + (Yprim - newY));
                    for (ConnectPainter painter : t.getConnectList()) {
                        Connection con = (Connection) painter.getElement();
                        if (con.getFirstComp().equals(t)) {
                            Point pos1 = new Point(painter.getPos1().x + (Xprim - newX), painter.getPos1().y + (Yprim - newY));
                            painter.setPos1(pos1);
                        } else {
                            Point pos2 = new Point(painter.getPos2().x + (Xprim - newX), painter.getPos2().y + (Yprim - newY));
                            painter.setPos2(pos2);
                        }
                    }
                }
            }
        }
        mV.repaint();
    }

    }


