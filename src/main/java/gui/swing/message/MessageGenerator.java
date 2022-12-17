package gui.swing.message;

import gui.swing.observer.Publisher;

public interface MessageGenerator extends Publisher {
    void generateMessage(EventType eventType);
}
