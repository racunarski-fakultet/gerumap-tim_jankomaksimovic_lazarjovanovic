package gui.swing.message;

import gui.swing.observer.ISubscriber;
import javafx.event.EventType;
import gui.swing.message.MessageGenerator;

import static gui.swing.message.EventType.*;


public class MessageGeneratorImplementation implements MessageGenerator{
    private Message message;

    @Override
    public void generateMessage(EventType eventType) {
        if (ERROR.equals(eventType)) {
            createMessage("Greska: ", eventType);
        } else if (CANNOT_DELETE_PROJECT_EXPLORER.equals(eventType)) {
            createMessage("Ne moze da se obriše Project Explorer", eventType);
        } else if (CANNOT_ADD_CHILD.equals(eventType)) {
            createMessage("Ne moze da se doda na ovu komponentu", eventType);
        } else if (MUST_INSERT_NAME.equals(eventType)) {
            createMessage("Ime projekta ne sme biti prazno", eventType);
        } else if (CANNOT_DELETE_FILE.equals(eventType)) {
            createMessage("Ovaj file ne sme da se obrise", eventType);
        } else if (RESOURCE_NOT_FOUND.equals(eventType)) {
            createMessage("Ne postoji putanja", eventType);
        } else if (NODE_ALREADY_EXISTS.equals(eventType)) {
            createMessage("Ova komponenta vec postoji", eventType);
        }

    }

    @Override
    public void addSubscriber(ISubscriber subscriber) {
        if (subscriber == null  && subscribers.contains(subscriber)) return;
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(ISubscriber subscriber) {
        if (subscriber == null && !(subscribers.contains(subscriber)) && subscribers.isEmpty()) return;
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if (notification == null && subscribers.isEmpty()) return;
        for (ISubscriber s: subscribers){
            s.update(this.message);
        }
    }

    private void createMessage(String tekst, EventType eventType) {
        this.message = new Message(tekst, eventType);
        notifySubscribers(this);
    }
}
