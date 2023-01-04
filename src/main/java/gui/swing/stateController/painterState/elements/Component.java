package gui.swing.stateController.painterState.elements;

import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.implementation.Element;
import gui.swing.stateController.painterState.ConnectPainter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

    @Getter
    @Setter


    public class Component extends Element {
        private int w = 100, h =  50;
        private int x, y;

        private List<ConnectPainter> connectList;

        public Component(String name, MapNode parent, Color color, int stroke, int x, int y){
            super(name, parent, color, stroke);
            this.x = x;
            this.y = y;
            connectList = new ArrayList<>();
        }

        public void setX(int x) {
            this.x = x;
            notifySubscribers(this);
        }

        public void setY(int y) {
            this.y = y;
            notifySubscribers(this);
        }

        public void setPos(int x, int y){
            this.x = x;
            this.y = y;
            notifySubscribers(this);
        }

    }

