import java.awt.Color;

/**
 * Vertex
 *
 * Represents a single point in 3D space.
 * Think of it like a dot floating in space.
 * X is left/right. Y is up/down. Z is depth.
 *
 */
public class Vertex {
    private double x;
    private double y;
    private double z;

    public Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}