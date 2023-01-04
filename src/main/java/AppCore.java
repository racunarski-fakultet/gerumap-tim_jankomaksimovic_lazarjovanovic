import core.*;
import gui.swing.SwingGui;
import gui.swing.error.ConsoleLogger;
import gui.swing.error.ErrorLogger;
import gui.swing.error.FileLogger;
import gui.swing.mapRepository.MapRepositoryImplementation;
import gui.swing.message.MessageGenerator;
import gui.swing.message.MessageGeneratorImplementation;
import gui.swing.serializer.GsonSerializer;

public class AppCore {
    public static void main(String[] args) {
        ApplicationFramework appCore = ApplicationFramework.getInstance();

        MapRepository mapRepository = new MapRepositoryImplementation();
        MessageGenerator messageGenerator = new MessageGeneratorImplementation();
        GuiInterface gui = new SwingGui(messageGenerator);
        ErrorLogger console = new ConsoleLogger(messageGenerator);
        ErrorLogger file =  new FileLogger(messageGenerator);
        Serializer serializer = new GsonSerializer();
        messageGenerator.addSubscriber(gui);
        messageGenerator.addSubscriber(console);
        messageGenerator.addSubscriber(file);

        appCore.initialise(gui, mapRepository, console, file, messageGenerator, serializer);
        appCore.run();
    }
}
