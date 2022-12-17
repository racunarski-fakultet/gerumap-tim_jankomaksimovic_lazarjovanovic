package gui.swing.mapRepository.implementation;

import gui.swing.mapRepository.composite.MapNode;
import gui.swing.observer.Subscriber;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.io.IOException;

@Getter
@Setter
public class Element extends MapNode {

    private static int counter=1;
    private int stroke = 2;
    private Color color = Color.BLACK;

    private Color realColor = Color.BLACK;


    public Element(String name, MapNode parent, Color color, int stroke){
        super(name, parent);
        this.color = color;
        this.stroke = stroke;
        notifySubscribers(this);
    }

    public Element(String name, MapNode parent) throws IOException {
        super(name, parent);
        setName(name+counter);
        counter++;
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        if (subscriber == null || subs.contains(subscriber))
        return;
        subs.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        if (subscriber == null || !subs.contains(subscriber))
        return;
        subs.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Object obj) {
        if (obj == null || subs.isEmpty()) {
            return;
        }

        for (Subscriber subscriber:subs)
            subscriber.update(obj);
    }

}

