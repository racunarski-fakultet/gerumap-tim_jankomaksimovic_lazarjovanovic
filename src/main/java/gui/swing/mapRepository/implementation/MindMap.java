package gui.swing.mapRepository.implementation;

import gui.swing.comands.CommandManager;
import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.composite.MapNodeComposite;
import gui.swing.observer.Subscriber;
import gui.swing.stateController.painterState.ElementPainter;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter


public class MindMap extends MapNodeComposite {
    private static int counter = 1;
    private boolean template;
    private CommandManager commandManager = new CommandManager();
    private List<ElementPainter> picasos = new ArrayList<>();


    public MindMap(String name, MapNode parent) throws IOException {
        super(name, parent);
        setName(name + counter);
        this.template = template;
        counter++;
    }

    @Override
    public void add(MapNode child) {
        if (child != null && child instanceof Element) {
            Element project = (Element) child;
            if (!this.getChildren().contains(project)) {
                this.getChildren().add(project);
            }
        }
    }

    @Override
    public void remove(MapNode child) {
        Element element = (Element) child;
        if (this.getChildren().contains(element)) {
            this.getChildren().remove(element);
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
