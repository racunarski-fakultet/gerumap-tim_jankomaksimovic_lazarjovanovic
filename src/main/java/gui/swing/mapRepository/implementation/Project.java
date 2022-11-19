package gui.swing.mapRepository.implementation;

import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.composite.MapNodeComposite;

public class Project extends MapNodeComposite {

   // private String autor;
    private static int counter=1;

    public Project(String name, MapNode parent) {
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
