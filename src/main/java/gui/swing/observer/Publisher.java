package gui.swing.observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Publisher {
    List<Subscriber> subscribers = new ArrayList<>();
    void addSubscriber (Subscriber subscriber);
    void removeSubscriber (Subscriber subscriber);
    void notifySubscribers (Object notification) throws IOException;
}
