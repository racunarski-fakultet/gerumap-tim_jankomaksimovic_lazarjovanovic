package gui.swing.mapRepository.factory;

import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.implementation.Element;
import gui.swing.mapRepository.implementation.MindMap;
import gui.swing.mapRepository.implementation.Project;
import gui.swing.mapRepository.implementation.ProjectExplorer;
import gui.swing.observer.Subscriber;

import java.io.IOException;

public class ProjectFactory extends NodeFactory{
    @Override
    public MapNode createNode(MapNode node) throws IOException {
        return new Project("Project" + ((ProjectExplorer) node).getChildren().size(), node);
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {

    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {

    }

    @Override
    public void notifySubscribers(Object notification) {

    }
}
