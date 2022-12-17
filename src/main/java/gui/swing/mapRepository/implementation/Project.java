package gui.swing.mapRepository.implementation;

import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.composite.MapNodeComposite;
import gui.swing.observer.Subscriber;

import java.io.IOException;

public class Project extends MapNodeComposite {

    private static int counter=1;

    public Project(String name, MapNode parent) throws IOException {
        super(name, parent);
        setName(name+counter);
        counter++;
    }

    @Override
    public void add(MapNode child) {
        if(child != null && child instanceof MindMap)
        {
            MindMap mindMap = (MindMap) child;
            if(!this.getChildren().contains(mindMap))
            {
                this.getChildren().add(mindMap);
            }
        }
    }

    @Override
    public void remove(MapNode child) {
        MindMap mindMap = (MindMap) child;
        if(this.getChildren().contains(mindMap))
        {
            this.getChildren().remove(mindMap);
        }

    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        if (subscriber == null || subs.contains(subscriber)) return;
        subs.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        if (subscriber == null || !(subs.contains((subscriber)))) return;
        subs.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if (notification == null || subs.isEmpty()) return;
        for (Subscriber s : subs) {
            s.update(this);

        }
    }
}
