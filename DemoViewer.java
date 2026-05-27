import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class DemoViewer {

    public static void main(String[] args) {
        JFrame frame = new JFrame(); // outer shell of the TV
        Container pane = frame.getContentPane(); // screen inside the TV where you put stuff
        pane.setLayout(new BorderLayout()); // divide the screen into 5 zones: top, bottom, left, right, center

        JSlider headingSlider = new JSlider(0, 360, 180);
        pane.add(headingSlider, BorderLayout.SOUTH); // slider knob that controls left right rotation. lives at the
                                                     // bottom (South)

        JSlider pitchSlider = new JSlider(SwingConstants.VERTICAL, -90, 90, 0);
        pane.add(pitchSlider, BorderLayout.EAST); // slider knob. controls up-down rotation. placed on the right side
                                                  // (East)

        // picture on the screen where the shape gets drawn. lives in the center.
        JPanel renderPanel = new JPanel() {

            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.BLACK);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }

        };

        pane.add(renderPanel, BorderLayout.CENTER);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }

}
