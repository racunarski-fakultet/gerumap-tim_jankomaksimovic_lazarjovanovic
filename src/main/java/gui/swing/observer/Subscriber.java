package gui.swing.observer;

import java.io.IOException;

public interface Subscriber {
    void update(Object notification);

    void addSubscriber(Subscriber subscriber);

    void removeSubscriber(Subscriber subscriber);

    void notifySubscribers(Object notification) throws IOException;
}
