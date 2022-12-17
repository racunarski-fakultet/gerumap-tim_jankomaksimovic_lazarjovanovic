package gui.swing.mapRepository.implementation;

import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.composite.MapNodeComposite;
import gui.swing.observer.Subscriber;

public class ProjectExplorer extends MapNodeComposite {

    public ProjectExplorer(String name) {
        super(name, null);
    }



    @Override
    public void add(MapNode child) {
        if(child != null && child instanceof Project)
        {
            Project project = (Project) child;
            if(!this.getChildren().contains(project))
            {
                this.getChildren().add(project);
            }
        }
    }

    @Override
    public void remove(MapNode child) {

        Project project = (Project) child;
        if(this.getChildren().contains(project))
        {
            this.getChildren().remove(project);
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
