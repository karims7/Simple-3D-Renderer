# 3D Renderer

A 3D renderer built from scratch in plain Java with zero external libraries.

## What Is This?

A program that takes a 3D shape — something that exists in an imaginary
world with X, Y, Z coordinates — and draws it on your flat 2D screen.

Your screen is flat. It has no depth. The whole job of a 3D renderer is
to figure out: "if this thing existed in real 3D space, what would it
look like from where I'm standing?" and then draw that.

## Why Java? Why From Scratch?

Most people think 3D rendering requires insane math and huge libraries.
It doesn't. You can build a basic one in ~200 lines of plain Java.
No dependencies. Fits in 50kb. And you actually understand every line.

## What This Covers

- **Orthographic projection** — go from 3D to 2D by dropping the Z coordinate
- **Triangle rasterization** — figure out which pixels each triangle occupies
- **Z-buffering** — when triangles overlap, draw the one that is in front
- **Flat shading** — simulate light so the shape actually looks 3D

## How to Run

Make sure Java is installed:

```bash
java --version
```

Compile and run:

```bash
javac *.java
java DemoViewer
```

A window will pop up — black background, two sliders. Drag them to rotate the shape.

## How It Works

Every time you drag a slider, the following happens:

1. The slider fires an event
2. `repaint()` is called on the render panel
3. `paintComponent()` runs from scratch
4. The screen is wiped black
5. The slider values are read and converted to radians
6. Two rotation matrices are built — one for left/right, one for up/down
7. The two matrices are combined into one
8. Every vertex of every triangle is passed through the matrix to get a rotated copy
9. The rotated triangles are drawn to screen using X and Y only (Z is dropped)

## Classes

### DemoViewer

Main class and entry point. Builds the GUI window, stores the triangle
list, and contains the rendering pipeline inside `paintComponent()`.

### Vertex

A single point in 3D space. Stores x, y, z as private doubles with
public getters.

### Triangle

One triangular face. Stores three Vertex objects and a Color as private
fields with public getters.

### Matrix3

A 3x3 rotation matrix stored as a flat array of 9 doubles.

- `multiply(Matrix3 other)` — combines two matrices into one
- `transform(Vertex in)` — applies the rotation to a vertex, returns a new rotated vertex

## Rendering Pipeline (Current State)
