package gui.swing.message;

import gui.swing.error.ConsoleLogger;
import gui.swing.observer.IPublisher;
import javafx.event.EventType;

public interface MessageGenerator extends IPublisher {
    void generateMessage(EventType eventType);
}
