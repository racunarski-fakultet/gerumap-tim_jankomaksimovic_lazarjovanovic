package gui.swing.controller;

import core.ApplicationFramework;
import gui.swing.mapRepository.implementation.Project;
import gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class OpenAction extends AbstractGeRuMapAction{

    public OpenAction () {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/Open.png"));
        putValue(NAME, "Open");
        putValue(SHORT_DESCRIPTION, "Open action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        if(jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION){
            try{
                File file = jfc.getSelectedFile();
                Project project = ApplicationFramework.getInstance().getSerializer().loadProject(file);
                //MainFrame.getInstance().getMapTree().loadProject(project);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }
}
