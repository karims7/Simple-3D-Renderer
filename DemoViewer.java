import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.List;
import java.util.ArrayList;

/**
 * DemoViewer
 *
 * Main class and entry point of the application.
 * Builds the GUI window and will contain the rendering pipeline.
 *
 * The window layout (think of it like a TV set):
 * - JFrame = the TV body (outer shell)
 * - Container = the screen inside (holds all components)
 * - BorderLayout = divides screen into 5 zones: N, S, E, W, CENTER
 * - headingSlider = knob at the bottom, controls left-right rotation
 * - pitchSlider = knob on the right, controls up-down rotation
 * - renderPanel = the picture — this is where the 3D shape gets drawn
 *
 * renderPanel subclasses JPanel inline and overrides paintComponent().
 * polymorphism.
 */
public class DemoViewer {

    public static void main(String[] args) {
        List<Triangle> triangles = new ArrayList<>();
        triangles.add(new Triangle(
                new Vertex(100, 100, 100),
                new Vertex(-100, -100, 100),
                new Vertex(-100, 100, -100),
                Color.WHITE));

        triangles.add(new Triangle(
                new Vertex(100, 100, 100),
                new Vertex(-100, -100, 100),
                new Vertex(100, -100, -100),
                Color.RED));

        triangles.add(new Triangle(
                new Vertex(-100, 100, -100),
                new Vertex(100, -100, -100),
                new Vertex(100, 100, 100),
                Color.GREEN));

        triangles.add(new Triangle(
                new Vertex(-100, 100, -100),
                new Vertex(100, -100, -100),
                new Vertex(-100, -100, 100),
                Color.BLUE));

        JFrame frame = new JFrame();
        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());

        // slider knob — controls left-right rotation. lives at the bottom (SOUTH)
        JSlider headingSlider = new JSlider(0, 360, 180);
        pane.add(headingSlider, BorderLayout.SOUTH);

        // slider knob — controls up-down rotation. lives on the right (EAST)
        JSlider pitchSlider = new JSlider(SwingConstants.VERTICAL, -90, 90, 0);
        pane.add(pitchSlider, BorderLayout.EAST);

        // the canvas — anonymous subclass of JPanel, overrides paintComponent()
        // Java calls paintComponent() whenever it needs to redraw — polymorphism
        JPanel renderPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.BLACK);
                g2.fillRect(0, 0, getWidth(), getHeight());

                // rotation matrix building from both sliders:
                double heading = Math.toRadians(headingSlider.getValue());
                double pitch = Math.toRadians(pitchSlider.getValue());

                Matrix3 headingTransform = new Matrix3(new double[] {
                        Math.cos(heading), 0, Math.sin(heading),
                        0, 1, 0,
                        -Math.sin(heading), 0, Math.cos(heading)
                });

                Matrix3 pitchTransform = new Matrix3(new double[] {
                        1, 0, 0,
                        0, Math.cos(pitch), Math.sin(pitch),
                        0, -Math.sin(pitch), Math.cos(pitch)
                });

                Matrix3 transform = headingTransform.multiply(pitchTransform);

                g2.translate(getWidth() / 2, getHeight() / 2);
                g2.setColor(Color.WHITE);

                for (Triangle triangle : triangles) {
                    Vertex v1 = transform.transform(triangle.getV1());
                    Vertex v2 = transform.transform(triangle.getV2());
                    Vertex v3 = transform.transform(triangle.getV3());

                    Path2D path = new Path2D.Double();
                    path.moveTo(v1.getX(), v1.getY());
                    path.lineTo(v2.getX(), v2.getY());
                    path.lineTo(v3.getX(), v3.getY());
                    path.closePath();
                    g2.draw(path);
                }

            }
        };

        headingSlider.addChangeListener(e -> renderPanel.repaint());
        pitchSlider.addChangeListener(e -> renderPanel.repaint());

        pane.add(renderPanel, BorderLayout.CENTER);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}