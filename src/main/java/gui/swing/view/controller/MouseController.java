package gui.swing.view.controller;


import gui.swing.observer.Subscriber;
import gui.swing.view.MainFrame;
import gui.swing.view.MapView;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

@Getter
@Setter
public class MouseController extends MouseAdapter implements Subscriber {
    private MapView mapView;

    public MouseController(MapView mapView) {
        this.mapView = mapView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("mouse clicked");
        Point pos = e.getPoint();
        double scaling = mapView.getScalingf();
        int x = (int) (pos.x / scaling);
        int y = (int) (pos.y / scaling);
        MainFrame.getInstance().getProjectView().startMouseClicked(x, y, mapView);
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // System.out.println("mouse pressed");
        Point pos = e.getPoint();
        double scaling = mapView.getScalingf();
        int x = (int) (pos.x / scaling);
        int y = (int) (pos.y / scaling);
        MainFrame.getInstance().getProjectView().startMousePressedState(x, y, mapView);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("mouse released");
        Point pos = e.getPoint();
        double scaling = mapView.getScalingf();
        int x = (int) (pos.x / scaling);
        int y = (int) (pos.y / scaling);
        MainFrame.getInstance().getProjectView().startMouseReleaseState(x, y, mapView);

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point pos = e.getPoint();
        double scaling = mapView.getScalingf();
        int x = (int) (pos.x / scaling);
        int y = (int) (pos.y / scaling);
        MainFrame.getInstance().getProjectView().startMouseDragedState(x, y, mapView);

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
}

