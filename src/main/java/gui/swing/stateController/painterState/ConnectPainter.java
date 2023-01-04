package gui.swing.stateController.painterState;

import gui.swing.mapRepository.implementation.Element;
import gui.swing.stateController.painterState.elements.Component;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Line2D;

@Setter
@Getter
public class ConnectPainter extends ElementPainter{
//    private Component begining;
//    private Component end;

    private Shape s;
    private Element element;
    private Point pos1;
    private Point pos2;


    public ConnectPainter(Element element, Point pos1, Point pos2) {
        this.element = element;
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    @Override
    public void draw(Graphics g) {


        Graphics2D graphics = (Graphics2D) g;
        graphics.setColor(element.getColor());

        s = new Line2D.Float(pos1.x, pos1.y, pos2.x, pos2.y);

        graphics.setStroke(new BasicStroke(2));
        graphics.draw(getS());



    }

    @Override
    public boolean elementAt(Point pos) {
        return getS().contains(pos);
    }
}
