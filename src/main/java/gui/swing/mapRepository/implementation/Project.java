package gui.swing.mapRepository.implementation;

import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.composite.MapNodeComposite;
import gui.swing.observer.Publisher;
import gui.swing.observer.Subscriber;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
@Getter
@Setter

public class Project extends MapNodeComposite implements Publisher {

    private static int counter=1;
    private String author;
    protected boolean changed = true;
    protected String filePath;

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

    public void setAuthor(String name) {
        author = name;
        notifySubscribers(this);
    }

    public String getAuthor() {
        return author;
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
