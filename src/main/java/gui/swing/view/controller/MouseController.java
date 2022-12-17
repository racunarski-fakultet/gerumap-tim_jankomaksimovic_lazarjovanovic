package gui.swing.view.controller;


import gui.swing.view.MainFrame;
import gui.swing.view.MapView;
import lombok.Getter;
import lombok.Setter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

@Getter
@Setter
public class MouseController implements MouseListener, MouseMotionListener {
    private MapView mapView;

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse clicked");
        MainFrame.getInstance().getProjectView().startMouseClicked(e.getX(), e.getY(), mapView);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mouse pressed");
        MainFrame.getInstance().getProjectView().startMousePressedState(e.getX(), e.getY(), mapView);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouse released");
        MainFrame.getInstance().getProjectView().startMouseReleaseState(e.getX(), e.getY(), mapView);

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouse entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouse exited");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        MainFrame.getInstance().getProjectView().startMouseDragedState(e.getX(), e.getY(), mapView);

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

