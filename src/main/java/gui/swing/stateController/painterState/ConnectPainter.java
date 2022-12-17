package gui.swing.stateController.painterState;

import gui.swing.stateController.painterState.elements.Component;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Setter
@Getter
public class ConnectPainter extends ElementPainter{
    private Component begining;
    private Component end;
    @Override
    public void draw(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(begining.getStroke()));
        g.drawLine(begining.getX(), begining.getY(), end.getX(),end.getY());

    }

    @Override
    public boolean elementAt(Point pos) {
        return false;
    }
}
