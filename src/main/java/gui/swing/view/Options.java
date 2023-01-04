package gui.swing.view;

import javax.swing.*;

public class Options extends JToolBar {
    public Options(){
        super(VERTICAL);
        setFloatable(false);
        add(MainFrame.getInstance().getActionManager().getComponentStateAction());
        add(MainFrame.getInstance().getActionManager().getSelectStateAction());
        add(MainFrame.getInstance().getActionManager().getConnectStateAction());
        add(MainFrame.getInstance().getActionManager().getMoveStateAction());
        add(MainFrame.getInstance().getActionManager().getZoomInStateAction());
        add(MainFrame.getInstance().getActionManager().getZoomOutStateAction());
        add(MainFrame.getInstance().getActionManager().getCentarComponentStateAction());
        add(MainFrame.getInstance().getActionManager().getSettingsStateAction());
        add(MainFrame.getInstance().getActionManager().getDeleteStateAction());



    }
}
