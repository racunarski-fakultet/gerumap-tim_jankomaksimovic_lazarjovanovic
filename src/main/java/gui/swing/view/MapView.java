package gui.swing.view;

import gui.swing.mapRepository.implementation.MindMap;
import gui.swing.observer.Subscriber;
import gui.swing.stateController.painterState.ElementPainter;
import gui.swing.view.controller.MouseController;

import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.text.Element;
import java.awt.*;
@Getter
@Setter
public class MapView extends JPanel implements Subscriber {

    double translateX = 0;
    double translateY = 0;
    double scalingf = 1;

    private AffineTransform transformation = new AffineTransform();
    private MindMap mindMap;
    private JToolBar mindMapToolBar;
    //private List<ElementPainter> painters;
    private MapSelectionModel mapSelectionModel;
    MouseController mouseController;

    public MapView(MindMap mindMap) {

        this.setLayout(new BorderLayout());
        setMap(mindMap);
        //this.mouseController = new MouseController(this);
        //mouseController.setMapView(this);
        addMouseListener(new MouseController(this));
        addMouseMotionListener(new MouseController(this));


        mapSelectionModel = new MapSelectionModel();
        mapSelectionModel.addSubscriber(this);


        //painters = new ArrayList<>();

    }

    public void setMap(MindMap mindMap){
        this.mindMap = mindMap;
        this.mindMap.addSubscriber(this);

    }

    private void setUpTransformation(){
        transformation.setToScale(scalingf,scalingf);
        transformation.translate(translateX,translateY);
        repaint();
    }

    public void zoomIn(){
        scalingf *= 1.2;
        if(scalingf > 3) scalingf = 3;
        setUpTransformation();

    }
    public void zoomOut(){
        scalingf *= 0.8;
        if(scalingf < 0.4) scalingf = 0.4;
        setUpTransformation();
    }

    @Override
    public void update(Object notification) {
        repaint();
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setTransform(transformation);
        //if (mindMap.getPicasos().isEmpty()) return;
        for (ElementPainter p : mindMap.getPicasos()) {
            p.draw(g2d);

        }
    }



}



