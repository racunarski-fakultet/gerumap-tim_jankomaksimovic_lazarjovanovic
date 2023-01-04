package gui.swing.controller;

import core.ApplicationFramework;
import gui.swing.mapRepository.implementation.Project;
import gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class SaveAction extends AbstractGeRuMapAction{
    public SaveAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/Save.png"));
        putValue(NAME, "Save");
        putValue(SHORT_DESCRIPTION, "Save action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();

        if(!(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project))
            return;

        Project project = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        File projectFile = null;

        if(!project.isChanged()){
            return;
        }

        if(project.getFilePath() == null || project.getFilePath().isEmpty()){
            if(jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION){
                projectFile = jfc.getSelectedFile();
                project.setFilePath(projectFile.getPath());
            }else{
                return;
            }
        }
        ApplicationFramework.getInstance().getSerializer().saveProject(project);
        project.setChanged(false);
    }
}
