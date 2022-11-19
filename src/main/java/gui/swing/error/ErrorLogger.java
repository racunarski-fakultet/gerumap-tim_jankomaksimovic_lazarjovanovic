package gui.swing.error;

import gui.swing.observer.ISubscriber;

public interface ErrorLogger extends ISubscriber {
    void log(String error);

}
