package gui.swing.view;

import javax.swing.*;

public class Toolbar extends JToolBar {

    public Toolbar()
    {
        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getExitAction());
        add(MainFrame.getInstance().getActionManager().getAuthorAction());
        add(MainFrame.getInstance().getActionManager().getNewAction());
        add(MainFrame.getInstance().getActionManager().getDeleteAction());
        add(MainFrame.getInstance().getActionManager().getRenameAction());
        add(MainFrame.getInstance().getActionManager().getUndoAction());
        add(MainFrame.getInstance().getActionManager().getRedoAction());
        add(MainFrame.getInstance().getActionManager().getOpenAction());
        add(MainFrame.getInstance().getActionManager().getSaveAction());

    }
}
