package gui.swing.stateController.painterState;

import gui.swing.mapRepository.implementation.Element;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.awt.*;
@Setter
@Getter
@NoArgsConstructor
public abstract class ElementPainter {

    private Element element;

    private Shape s;

    public ElementPainter(Element element){this.element = element;}

    public abstract void draw(Graphics g);

    public abstract boolean elementAt(Point pos);


}

