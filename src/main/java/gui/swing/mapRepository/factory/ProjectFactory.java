package gui.swing.mapRepository.factory;

import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.implementation.Element;
import gui.swing.mapRepository.implementation.MindMap;
import gui.swing.mapRepository.implementation.Project;
import gui.swing.mapRepository.implementation.ProjectExplorer;

public class ProjectFactory extends NodeFactory{
    @Override
    public MapNode createNode(MapNode node) {
        return new Project("Project" + ((ProjectExplorer) node).getChildren().size(), node);
    }
}
