import java.awt.Color;

/**
 * Triangle
 *
 * Represents one flat triangular face of a 3D shape.
 * Holds three Vertex objects (its corners) and a Color.
 * Every 3D shape is made of triangles. Our tetrahedron needs 4.
 *
 */
public class Triangle {
    private Vertex v1;
    private Vertex v2;
    private Vertex v3;
    private Color color;

    public Triangle(Vertex v1, Vertex v2, Vertex v3, Color color) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.color = color;
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public Vertex getV3() {
        return v3;
    }

    public Color getColor() {
        return color;
    }
}