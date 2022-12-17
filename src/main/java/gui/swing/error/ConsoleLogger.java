package gui.swing.error;

import gui.swing.message.Message;
import gui.swing.message.MessageGenerator;
import gui.swing.observer.Subscriber;

import java.io.IOException;
import java.util.Date;

public class ConsoleLogger implements ErrorLogger {
    private MessageGenerator messageGenerator;

    public ConsoleLogger(MessageGenerator messageGenerator) {
        this.messageGenerator = messageGenerator;
        this.messageGenerator.addSubscriber(this);
    }

    @Override
    public void log(String greska) {
        System.out.println(greska);
    }

    @Override
    public void update(Object notification) {
        Date date = new Date();
        String error = "("+date+") "+ ((Message) notification).toString();

        log(error);
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
