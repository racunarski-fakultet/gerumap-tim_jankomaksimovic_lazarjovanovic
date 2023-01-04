package gui.swing.stateController.painterState;

import gui.swing.mapRepository.implementation.Element;
import gui.swing.stateController.painterState.elements.Component;
import lombok.Getter;
import lombok.Setter;


import java.awt.*;
import java.awt.geom.Ellipse2D;

@Getter
@Setter

public class ComponentPainter extends ElementPainter{

    private Shape s;
    private Element element;
    private Component c;

    public ComponentPainter(Element element){
        this.element = element;
        c = (Component) element;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(element.getColor());
        g2D.setStroke(new BasicStroke(element.getStroke()));
        s = new Ellipse2D.Float(c.getX() - 50, c.getY() - 25, c.getW(), c.getH());
        g2D.draw(getS());

        if(element instanceof Component) {
            Component c = (Component) element;
            g.drawString(c.getName(), (int) c.getX() - 27, (int) c.getY()+4 );
        }
    }


    @Override
    public boolean elementAt(Point pos) {
        return getS().contains(pos);
    }
}


