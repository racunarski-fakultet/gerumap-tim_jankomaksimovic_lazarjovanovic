package gui.swing.mapRepository.factory;

import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.implementation.Element;
import gui.swing.mapRepository.implementation.MindMap;
import gui.swing.mapRepository.implementation.Project;

public class ElementFactory extends NodeFactory{
    @Override
    public MapNode createNode(MapNode node) {
        return new Element("Element" + ((MindMap) node).getChildren().size(), node);
    }
}
