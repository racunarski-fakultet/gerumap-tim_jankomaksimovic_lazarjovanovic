package gui.swing;

import core.Gui;
import gui.swing.message.EventType;
import gui.swing.message.Message;
import gui.swing.message.MessageGenerator;
import gui.swing.observer.Subscriber;
import gui.swing.view.MainFrame;

import javax.swing.*;
import java.io.IOException;

public class SwingGui extends Gui {

    private MainFrame instance;
    private MessageGenerator msgGen;

    public SwingGui(MessageGenerator msgGen) {
        this.msgGen = msgGen;
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
    public void addSubscriber(Subscriber subscriber) {

    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {

    }

    @Override
    public void notifySubscribers(Object notification) throws IOException {

    }
}
