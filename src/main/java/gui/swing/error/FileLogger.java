package gui.swing.error;


import gui.swing.message.Message;
import gui.swing.message.MessageGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileLogger implements ErrorLogger {
    private MessageGenerator messageGenerator;

    public FileLogger(MessageGenerator messageGenerator) {
        this.messageGenerator = messageGenerator;
        this.messageGenerator.addSubscriber(this);
    }
    @Override
    public void log(String greska) {
        File file = new File("error_file.txt");
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(greska);
        } catch (FileNotFoundException e){
            System.out.println("Filenotfound");
        } catch (IOException e) {
            System.out.println("IOexception");
        }
    }

    @Override
    public void update(Object notification) {
        Message message = (Message) notification;
        Date date = new Date();
        String error = "("+date+") "+ ((Message) notification).toString();
        log(error);

    }

}
