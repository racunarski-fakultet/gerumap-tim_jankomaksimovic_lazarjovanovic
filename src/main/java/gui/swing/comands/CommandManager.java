package gui.swing.comands;


import core.ApplicationFramework;
import gui.swing.view.MainFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import core.GuiInterface;

public class CommandManager {
    private List<AbstractCommand> commands = new ArrayList<>();
    private int currentCommand = 0;

    public void addCommand(AbstractCommand command){
        while(currentCommand < commands.size()){
            commands.remove(currentCommand);
        }
        commands.add(command);
        doCommand();
    }
    public void doCommand(){
        if(currentCommand < commands.size()){
            commands.get(currentCommand++).doCommand();
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMapTree().getTreeView());
            ApplicationFramework.getInstance().getGuiInterface().enableUndoAction();
        }
        if(currentCommand == commands.size()){
            ApplicationFramework.getInstance().getGuiInterface().disableRedoAction();
        }
    }
    public void undoCommand(){
        if(currentCommand > 0){
            ApplicationFramework.getInstance().getGuiInterface().enableRedoAction();
            commands.get(--currentCommand).undoCommand();
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMapTree().getTreeView());
        }
        if(currentCommand == 0){
            ApplicationFramework.getInstance().getGuiInterface().disableUndoAction();
        }
    }


}
