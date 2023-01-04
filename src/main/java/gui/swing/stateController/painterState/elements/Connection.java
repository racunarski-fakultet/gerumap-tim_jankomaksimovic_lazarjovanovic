package gui.swing.stateController.painterState.elements;

import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.implementation.Element;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter

public class Connection extends Element {

    private Component firstComp;
    private Component secondComp;

    public Connection(String name, MapNode parent, Color color, int stroke, Component firstComp, Component secondComp) {
        super(name, parent, color, stroke);
        this.firstComp = firstComp;
        this.secondComp = secondComp;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Connection) {
            Connection otherObj = (Connection) obj;
            return ((this.getFirstComp().equals(otherObj.getFirstComp()) && this.getSecondComp().equals(otherObj.getSecondComp())) ||
                    (this.getFirstComp().equals(otherObj.getSecondComp()) && this.getSecondComp().equals(otherObj.getFirstComp())));
        }
        return false;
    }
}

