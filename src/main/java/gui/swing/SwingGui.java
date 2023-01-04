package gui.swing;

import core.GuiInterface;
import gui.swing.comands.CommandManager;
import gui.swing.message.EventType;
import gui.swing.message.Message;
import gui.swing.message.MessageGenerator;
import gui.swing.observer.Subscriber;
import gui.swing.view.MainFrame;

import javax.swing.*;
import java.io.IOException;

public class SwingGui implements GuiInterface {

    private MainFrame instance;
    private MessageGenerator msgGen;
    private CommandManager commandManager;

    public SwingGui(MessageGenerator msgGen) {
        this.msgGen = msgGen;
        commandManager = new CommandManager();
        msgGen.addSubscriber(this);
    }

    @Override
    public void start() {
        instance = MainFrame.getInstance();
        instance.setVisible(true);
    }

    @Override
    public void update(Object notification) {
        Message msg = (Message) notification;

        for (EventType eventType: EventType.values()){
            if (eventType.equals(msg.getEventType())){
                JOptionPane.showMessageDialog(instance, msg.getText(), msg.getEventType().toString(), JOptionPane.WARNING_MESSAGE);
            }
        }

    }

    @Override
    public CommandManager getCommandManager(){
        return commandManager;
    }

    @Override
    public void disableUndoAction() {
        MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);

    }

    @Override
    public void disableRedoAction() {
        MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
    }

    @Override
    public void enableUndoAction() {
        MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
    }

    @Override
    public void enableRedoAction() {
        MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {

    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {

    }

    @Override
    public void notifySubscribers(Object notification) throws IOException {

    }
}
