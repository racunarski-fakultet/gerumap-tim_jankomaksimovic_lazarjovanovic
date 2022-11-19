package gui.swing.mapRepository.implementation;

import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.composite.MapNodeComposite;

public class MindMap extends MapNodeComposite {
    private static int counter=1;

    public MindMap(String name, MapNode parent) {
        super(name, parent);
        setName(name+counter);
        counter++;
    }
    @Override
    public void add(MapNode child) {

    }

    @Override
    public void remove(MapNode child) {

    }
}
