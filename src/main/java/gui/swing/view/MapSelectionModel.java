package gui.swing.view;

import gui.swing.mapRepository.implementation.Element;
import gui.swing.observer.Publisher;
import gui.swing.observer.Subscriber;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class MapSelectionModel implements Publisher {
    private List<Element> selected;
    protected List<Subscriber> subs;
    private Color oldColor;

    public MapSelectionModel() {
        selected = new ArrayList<>();
        this.subs = new ArrayList<>();
    }

    public void addElement(Element element) throws IOException {
        if (element != null) {
            this.getSelected().add(element);
            oldColor = element.getColor();
            element.setColor(Color.BLUE);
            notifySubscribers(this);
        }
    }

    public void clearList() throws IOException {
        for(Element el : this.getSelected()){
            el.setColor(oldColor);
        }
        getSelected().clear();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        if(subscriber == null)
            return;
        if(this.subs ==null)
            this.subs = new ArrayList<>();
        if(this.subs.contains(subscriber))
            return;
        this.subs.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        if(subscriber == null || this.subs == null || !this.subs.contains(subscriber))
            return;
        this.subs.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Object notification) throws IOException {
        if(notification == null || this.subs == null || this.subs.isEmpty())
            return;

        for(Subscriber sub : subs){
            sub.update(notification);
        }
    }





}

