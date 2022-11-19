package gui.swing.message;

import javafx.event.EventType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Message {
    private String text;
    private EventType eventType;

    public Message(String text, EventType eventType) {
        this.text = text;
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return text+" ["+eventType+"]";
    }
}
