package gui.swing.stateController.painterState;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Rectangle2D;

@Getter
@Setter

public class MultiSelectionPainter extends ElementPainter{
    private int x, y, w, l;
    private Shape shape;

    public void updatePoints(int x, int y, int x2, int y2){
        this.x = Math.min(x, x2);
        this.y = Math.min(y, y2);
        this.w = Math.abs(x2 - x);
        this.l = Math.abs(y2 - y);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.GRAY);

        shape = new Rectangle2D.Float(x, y, w, l);
        Stroke dashed = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);

        g2d.setStroke(dashed);
        g2d.draw(shape);
    }

    @Override
    public boolean elementAt(Point position) {
        return false;
    }
}
