package gui.swing.stateController;

import gui.swing.mapRepository.implementation.Element;
import gui.swing.view.MainFrame;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;
@Getter
@Setter
public class StateSettings extends JDialog {
    JLabel nameLabel = new JLabel("Change the name: ");
    JLabel strokeLabel = new JLabel("Change stroke: ");
    JTextField nameTf = new JTextField(16);
    JTextField strokeTf = new JTextField(16);

    JColorChooser colorChooser = new JColorChooser();
    JButton btn = new JButton("OK");

    public StateSettings(Frame owner, String title, boolean modal) {
        super(owner, title, modal);

        JPanel panel = new JPanel(new FlowLayout());

        panel.setLayout(new FlowLayout());


        setLocationRelativeTo(owner);
        setSize(600,400);

        panel.add(nameLabel);
        panel.add(nameTf);
        panel.add(strokeLabel);
        panel.add(strokeTf);
        panel.add(colorChooser);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Element element : MainFrame.getInstance().getProjectView().getMapView().getMapSelectionModel().getSelected()){
                    System.out.println(element.getColor());
                    try {
                        element.setName(nameTf.getText());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    element.setColor(colorChooser.getColor());
                    element.setRealColor(colorChooser.getColor());

                    MainFrame.getInstance().getProjectView().getMapView().repaint();

                    if(!Objects.equals(strokeTf.getText(), "")) {
                        element.setStroke(Integer.parseInt(strokeTf.getText()));
                    }

                }

            }
        });
        panel.add(btn);

        this.add(panel);

        panel.setVisible(true);

    }
}
