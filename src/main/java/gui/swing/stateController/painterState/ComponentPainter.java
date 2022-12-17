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

    private Shape shape;
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
        shape = new Ellipse2D.Float(c.getX(), c.getY(), c.getW(), c.getH());
        g2D.draw(shape);

        if(element instanceof Component) {
            Component c = (Component) element;
            g.drawString(c.getName(), (int) c.getX() + 25, (int) c.getY() + 30);
        }
    }


    @Override
    public boolean elementAt(Point pos) {
        return getShape().contains(pos);
    }
}


