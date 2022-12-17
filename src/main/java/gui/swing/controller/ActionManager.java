package gui.swing.controller;

import gui.swing.stateController.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionManager {

    private InfoAction infoAction;
    private ExitAction exitAction;
    private NewAction newAction;
    private RenameAction renameAction;
    private DeleteAction deleteAction;
    private ComponentStateAction componentStateAction;
    private ConnectStateAction connectStateAction;
    private DeleteStateAction deleteStateAction;
    private MoveStateAction moveStateAction;
    private SelectStateAction selectStateAction;
    private SettingsStateAction settingsStateAction;
    private ZoomInStateAction zoomInStateAction;
    private ZoomOutStateAction zoomOutStateAction;


    public ActionManager()
    {
        initialiseActions();
    }

    private void initialiseActions()
    {
        exitAction = new ExitAction();
        newAction = new NewAction();
        renameAction = new RenameAction();
        deleteAction = new DeleteAction();
        infoAction  = new InfoAction();
        componentStateAction = new ComponentStateAction();
        connectStateAction = new ConnectStateAction();
        deleteStateAction = new DeleteStateAction();
        moveStateAction = new MoveStateAction();
        selectStateAction = new SelectStateAction();
        settingsStateAction = new SettingsStateAction();
        zoomInStateAction = new ZoomInStateAction();
        zoomOutStateAction = new ZoomOutStateAction();


    }

}
