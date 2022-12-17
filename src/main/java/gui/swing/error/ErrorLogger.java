package gui.swing.error;

import gui.swing.observer.Subscriber;

public interface ErrorLogger extends Subscriber {
    void log(String error);

}
