package gui.swing.mapRepository.factory;

import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.implementation.Element;

public class ProjectFactory extends NodeFactory{
    @Override
    public MapNode createNode(MapNode node) {
        return new Element("Project", node);
    }
}
