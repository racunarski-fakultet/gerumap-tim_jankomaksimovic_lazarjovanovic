package core;


import gui.swing.comands.CommandManager;
import gui.swing.observer.Subscriber;


public interface GuiInterface extends Subscriber {
    void start();

    void disableUndoAction();

    void disableRedoAction();


    void enableUndoAction();

    void enableRedoAction();


    CommandManager getCommandManager();


}
