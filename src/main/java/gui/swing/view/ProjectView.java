package gui.swing.view;

import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.composite.MapNodeComposite;
import gui.swing.mapRepository.implementation.MindMap;
import gui.swing.observer.Subscriber;
import gui.swing.state.ManagerState;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class ProjectView extends JPanel implements Subscriber {

    private JTabbedPane jtp;
    private List<MapView> tabs ;
    private JLabel projectName;
    private JLabel author;
    private MapNodeComposite project;

    private ManagerState managerState;


    public ProjectView() {

        managerState = new ManagerState();

        jtp = new JTabbedPane();
        add(jtp);

        projectName = new JLabel();
        projectName.setVisible(true);
        add(projectName);

        author = new JLabel();
        author.setVisible(true);
        add(author);

        tabs = new ArrayList<>();

        BoxLayout boxL = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(boxL);
    }

    public void reloadTabs(MapNodeComposite selected){
        /*if(!tabs.isEmpty()){
            repaintTabs();
            return;
        }*/

        tabs.clear();
        jtp.removeAll();
        this.project = selected;
        project.addSubscriber(this);
        for(MapNode child : project.getChildren()){
            MapView mV = new MapView((MindMap) child);
            tabs.add(mV);

        }

        for(MapView tabN : tabs){
            jtp.add(tabN.getMindMap().getName(),tabN);
        }

        this.author.setText("Lazar");
        this.projectName.setText(project.getName());

    }

    public void repaintTabs(){
        jtp.repaint();
    }
    public MapView getMapView(){
        return (MapView) jtp.getSelectedComponent();
    }


    @Override
    public void update(Object notification) {

    }

    @Override
    public void addSubscriber(Subscriber subscriber) {

    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {

    }

    @Override
    public void notifySubscribers(Object notification) throws IOException {

    }

    public void startMouseClicked(int x, int y, MapView mV){
        try {
            managerState.getState().mouseClickedState(x, y, mV);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void startMousePressedState(int x, int y, MapView mV){
        try {
            managerState.getState().mousePressedState(x, y, mV);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void startMouseDragedState(int x, int y, MapView mV){
        try {
            managerState.getState().mouseDragedState(x, y, mV);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void startMouseReleaseState(int x, int y, MapView mV){
        try {
            managerState.getState().mouseReleaseState(x, y, mV);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void startDeleteState(){
        managerState.setDeleteState();
    }


    public void startComponentState(){
        managerState.setComponentState();
    }

    public void startMoveState(){
        managerState.setMoveState();
    }

    public void startConnectState(){
        managerState.setConnectState();
    }

    public void startSelectState(){
        managerState.setSelectState();
    }



}

//
