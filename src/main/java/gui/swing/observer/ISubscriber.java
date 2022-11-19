package gui.swing.observer;

import gui.swing.message.MessageGenerator;

public interface ISubscriber {
    void update(Object notification);
}
