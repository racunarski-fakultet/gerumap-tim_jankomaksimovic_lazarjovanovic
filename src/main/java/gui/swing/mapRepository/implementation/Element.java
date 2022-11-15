package gui.swing.mapRepository.implementation;

import gui.swing.mapRepository.composite.MapNode;

public class Element extends MapNode {

    private static int counter=1;
    public Element(String name, MapNode parent) {
        super(name, parent);
        setName(name+counter);
        counter++;
    }
}
