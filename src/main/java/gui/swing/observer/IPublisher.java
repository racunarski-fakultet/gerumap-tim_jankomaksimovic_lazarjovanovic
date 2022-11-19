package gui.swing.observer;

import java.util.ArrayList;
import java.util.List;

public interface IPublisher {
    List<ISubscriber> subscribers = new ArrayList<>();
    void addSubscriber (ISubscriber subscriber);
    void removeSubscriber (ISubscriber subscriber);
    void notifySubscribers (Object notification);
}
