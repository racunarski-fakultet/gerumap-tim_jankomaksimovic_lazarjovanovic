import core.ApplicationFramework;
import core.Gui;
import core.MapRepository;
import gui.swing.SwingGui;
import gui.swing.error.ConsoleLogger;
import gui.swing.error.ErrorLogger;
import gui.swing.error.FileLogger;
import gui.swing.mapRepository.MapRepositoryImplementation;
import gui.swing.message.MessageGenerator;
import gui.swing.message.MessageGeneratorImplementation;

public class AppCore {
    public static void main(String[] args) {
        ApplicationFramework appCore = ApplicationFramework.getInstance();

        MapRepository mapRepository = new MapRepositoryImplementation();
        MessageGenerator messageGenerator = new MessageGeneratorImplementation();
        Gui gui = new SwingGui(messageGenerator);
        ErrorLogger console = new ConsoleLogger(messageGenerator);
        ErrorLogger file =  new FileLogger(messageGenerator);
        messageGenerator.addSubscriber(gui);
        messageGenerator.addSubscriber(console);
        messageGenerator.addSubscriber(file);

        appCore.initialise(gui, mapRepository, console, file, messageGenerator);
        appCore.run();
    }
}
